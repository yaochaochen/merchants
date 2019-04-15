package com.passbook.utils;

import com.passbook.vo.Feedback;
import com.passbook.vo.GainPassTemplateRequest;
import com.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * <h1>Id生成器</h1>
 * @ClassName RowKeyGenUtil
 * @Author yaochaochen
 * @Date 2019-04-15 09:50
 **/
@Slf4j
public class RowKeyGenUtil {


    /**
     * <h2>根据提供的 PassTemplate 对象生成 RowKey</h2>
     * @param template {@link PassTemplate}
     * @return rowKey
     */

    public static String genPassTemplateRowKey(PassTemplate template) {
        
        String passInfo  = template.getId()+ "_" + template.getTitle();
        
        String rowKey = DigestUtils.md2Hex(passInfo);
        
        log.info("GenPassTemplateRowKey {}, {}", passInfo, rowKey);
        
        return rowKey;
        
    }

    /**
     * <h2>根据提供的领取优惠券请求生成 RowKey, 只可以在领取优惠券的时候使用</h2>
     * Pass RowKey = reversed(userId) + inverse(timestamp) + PassTemplate RowKey
     * @param request {@link GainPassTemplateRequest}
     * @return String RowKey
     * */
    public static String genPassRowKey(GainPassTemplateRequest request) {

        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    /**
     * <h2>根据 Feedback 构造 RowKey</h2>
     * @param feedback {@link Feedback}
     * @return String RowKey
     * */
    public static String genFeedbackRowKey(Feedback feedback) {

        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
    
    
}
