package com.passbook.merchants.service.impl;


import com.alibaba.fastjson.JSON;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class MerchantsServImplTest {
    
    @Autowired
    private IMerchantsServ merchantsServ;
    
    @Test
    public  void testCreateMerchants() {
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        
        request.setName("20元优惠券");
        request.setAddress("北京");
        request.setLogoUrl("www.baidu.com");
        request.setBusinessLicenseUrl("www.yuetuvip.com");
        request.setPhone("1234567890");
        merchantsServ.createMerchants(request);
        log.info(JSON.toJSONString(request));
    }
    @Test
    public void buildMerchants() {
        log.info(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(17)));
        
    }
    @Test
    public void  testDropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(17);
        passTemplate.setDecs("这是个优惠券");
        passTemplate.setLimit(100L);
        passTemplate.setBackground(3);
        passTemplate.setSummary("这是个满减劵");
        passTemplate.setTitle("满20减5元");
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));
      
        log.info(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }

}