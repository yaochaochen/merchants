package com.passbook.constant;

/**
 * <h1>评论类型</h1>
 * @ClassName FeedbackType
 * @Author yaochaochen
 * @Date 2019-04-15 09:38
 **/
public enum  FeedbackType {
    
    
    PASS("pass", "针对优惠券的评论"),
    APP("app", "针对卡包的评论");
    
    private String code;
    
    private String desc;
    
    FeedbackType(String code, String desc) {
        this.code = code;
        this.desc = desc;
        
    }
    
    public String getCode() {
        
        return this.code;
    }
    
    public String getDesc() {
        return this.desc;
    }
}
