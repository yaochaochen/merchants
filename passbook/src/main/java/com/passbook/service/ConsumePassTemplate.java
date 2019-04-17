package com.passbook.service;

import com.alibaba.fastjson.JSON;
import com.passbook.constant.Constants;
import com.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * <h1>消费 kafka</h1>
 * @ClassName ConsumePassTemplate
 * @Author yaochaochen
 * @Date 2019-04-15 20:38
 **/
@Slf4j
@Component
public class ConsumePassTemplate {
    
    private final IHbasePassService passService;

    @Autowired
    public ConsumePassTemplate(IHbasePassService passService) {
        this.passService = passService;
    }
    
    @KafkaListener(topics = {Constants.TEMPLATE_TOPIC})
    public void receive(
            @Payload String passTemplate, 
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, 
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, 
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic ) {

        log.info("Consumer Receive PassTemplate {}", passTemplate);

        PassTemplate pt = new PassTemplate();
        try {
            pt = JSON.parseObject(passTemplate, PassTemplate.class);

        } catch (Exception ex) {
            log.error("", ex.getMessage());
        }
        log.info("", passService.dropPassTemplateToHBase(pt));
    }
}
