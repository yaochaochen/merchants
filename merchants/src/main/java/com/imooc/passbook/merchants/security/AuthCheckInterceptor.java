package com.imooc.passbook.merchants.security;

import com.imooc.passbook.merchants.constans.Constans;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h1>权限连接器</h1>
 * @ClassName AuthCheckInterceptor
 * @Author yaochaochen
 * @Date 2019-04-14 00:50
 **/
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        
        String token = httpServletRequest.getHeader(Constans.TOKEN_STRING);
        
        if (StringUtils.isEmpty(token)) {
            throw  new Exception("Header中缺少" + Constans.TOKEN_STRING);
        }
        if (!token.equals(Constans.TOKNE)) {
            throw  new Exception("Heard中的" + Constans.TOKEN_STRING + "错误");
        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        
        AccessContext.cleanAccessKey();

    }
}
