package com.passbook.merchants.service.impl;

import com.passbook.merchants.constans.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.CreateMerchantsResponse;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao) {
        this.merchantsDao = merchantsDao;
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
        return null;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        return null;
    }
}
