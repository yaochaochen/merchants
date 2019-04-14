package com.passbook.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.passbook.merchants.constans.Constans;
import com.passbook.merchants.constans.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import com.passbook.merchants.entity.Merchants;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.CreateMerchantsResponse;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <h1>商户接口实现</h1>
 * @ClassName MerchantsServImpl
 * @Author yaochaochen
 * @Date 2019-04-14 14:32
 **/
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {
    
    private final MerchantsDao merchantsDao;
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode errorCode = request.validate(merchantsDao);
        
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1); 
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
            
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
            
        }
        response.setData(merchantsResponse);
        
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        
        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);
        if (null == merchants) {
            response.setErrorCode(ErrorCode.MECHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MECHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        
        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constans.TEMPLATE_TOPIC,
                    Constans.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("dropPassTemplate :{}", passTemplate);
             
        }
        
        return response;
    }
}
