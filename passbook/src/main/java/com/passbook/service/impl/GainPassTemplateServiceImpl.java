package com.passbook.service.impl;


import com.passbook.service.IGainPassTemplateService;
import com.passbook.vo.GainPassTemplateRequest;
import com.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/***
 * <h1>领取优惠券功能实现</h1>
 */
@Slf4j
@Service
public class GainPassTemplateServiceImpl implements IGainPassTemplateService{

    private final StringRedisTemplate stringRedisTemplate;

    private final HbaseTemplate hbaseTemplate;

    @Autowired
    public GainPassTemplateServiceImpl(StringRedisTemplate stringRedisTemplate, HbaseTemplate hbaseTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response gainPassTemplate(GainPassTemplateRequest request) throws Exception {
        return null;
    }
}
