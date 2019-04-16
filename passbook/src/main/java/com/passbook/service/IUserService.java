package com.passbook.service;

import com.passbook.vo.Response;
import com.passbook.vo.User;

public interface IUserService {


    /**
     * <h2>创建用户</h2>
     * @param user {@link User}
     * @return {@link Response}
     * */
    Response createUser(User user) throws Exception;
}
