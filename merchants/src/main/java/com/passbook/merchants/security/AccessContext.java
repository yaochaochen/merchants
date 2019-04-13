package com.passbook.merchants.security;

/**
 * <h1>单独存储每个线程的token信息</h1>
 * @ClassName AccessContext
 * @Author yaochaochen
 * @Date 2019-04-14 00:44
 **/
public class AccessContext  {
    
    public static  final ThreadLocal<String> token = new ThreadLocal<String>();
    
    public static String getToken() {
        return token.get();
    }
    
    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }
    
    public static void cleanAccessKey() {
        token.remove();
    }
    
}
