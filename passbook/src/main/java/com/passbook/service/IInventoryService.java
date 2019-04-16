package com.passbook.service;

import com.passbook.vo.Response;

public interface IInventoryService {

    /**
     * <h2>获取库存信息</h2>
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getInventoryInfo(Long userId) throws Exception;
    
}
