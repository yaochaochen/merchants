package com.passbook.merchants.service;

import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;

/**
 * <h1>商户服务接口</h1>
 */
public interface IMerchantsServ {

    /**
     * <h2>创建商户</h2>
     * @param request {@link CreateMerchantsRequest}
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据Id构造商户信息</h2>
     * @param id 商户Id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
    
    
    
    
}
