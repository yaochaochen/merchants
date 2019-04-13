package com.passbook.merchants.constans;

/**
 * 错误码枚举定义
 */
public enum ErrorCode {
    
    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "商户名称重复"),
    EMPY_LOGO(2,"商户logo为空"),
    EMPY_BUSINESS_LINCESE(3,"商户营业执照为空"),
    ERROR_PHONE(4,"商户电话有误"),
    EMPY_ADDRESS(5,"商户地址为空"),
    MECHANTS_NOT_EXIST(6,"商户不存在");
    
    private Integer code;
    
    private String desc;
    
    ErrorCode(Integer code, String desc) {
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
