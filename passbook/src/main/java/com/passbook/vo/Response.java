package com.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Response
 * @Author yaochaochen
 * @Date 2019-04-15 16:36
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    
    private Integer errorCode = 0;
    
    private String errorMsg = "";
    
    private Object data;
    
    public Response(Object data) {
        this.data = data;
    }
    
    public static Response success() {
        
        return new Response();
    }
    
    
}
