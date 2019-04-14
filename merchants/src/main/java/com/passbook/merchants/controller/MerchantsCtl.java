package com.passbook.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MerchantsCtl
 * @Author yaochaochen
 * @Date 2019-04-14 15:41
 **/
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {
    
    private final IMerchantsServ merchantsServ;

    @Autowired
    public MerchantsCtl(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }
    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        
        log.info("createMerchants: {}", JSON.toJSONString(request));
       return merchantsServ.createMerchants(request);
        
        
    }
    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfoById(@PathVariable Integer id) {
        
        log.info("buildMerchantsInfoById {}", id);
        
        return merchantsServ.buildMerchantsInfoById(id);
    }
    @ResponseBody
    @PostMapping("/pass")
    public Response dropPassTemplate(PassTemplate template) {
        log.info("dropPassTemplate:{}", JSON.toJSONString(template));
        return merchantsServ.dropPassTemplate(template);
    }
}
