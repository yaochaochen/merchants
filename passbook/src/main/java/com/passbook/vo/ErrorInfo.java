package com.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ErrorInfo
 * @Author yaochaochen
 * @Date 2019-04-15 16:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {
    
    public static final Integer ERROR = -1;
    
    public Integer code;
    
    private String message;
    
    private String url;
    
    private T data;
    
}
