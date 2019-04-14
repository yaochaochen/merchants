package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>响应对象</h1>
 * @ClassName Response
 * @Author yaochaochen
 * @Date 2019-04-14 14:00
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * 正确返回 0
     */
    private Integer errorCode = 0;
    /***
     * 正确返回空
     */
    private String errorMsg = "";
    
    private  Object data;

    /**
     * 正确响应
     * @param data
     */
    public  Response(Object data) {
         this.data = data;
    }
    
}
