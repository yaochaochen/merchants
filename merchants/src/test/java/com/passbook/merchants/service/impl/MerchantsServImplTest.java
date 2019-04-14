package com.passbook.merchants.service.impl;


import com.alibaba.fastjson.JSON;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}