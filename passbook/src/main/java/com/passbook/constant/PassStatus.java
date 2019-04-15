package com.passbook.constant;

/**
 * <h1>优惠券枚举</h1>
 */
public enum PassStatus {
    
    
    
    UNUSED(1, "未被使用"),
    USED(2, "已使用"),
    ALL(3,"全部领取");
    
    private Integer code;
    
    private String desc;
    
    
    PassStatus(Integer code, String desc){
        this.code = code;
        this.desc = desc;
        
    }
    
    public Integer getCode() {
        return this.code;
    }
    
    public String getDesc() {
        return this.desc;
    }
}
