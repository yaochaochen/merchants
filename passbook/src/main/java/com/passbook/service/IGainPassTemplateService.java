package com.passbook.service;

import com.passbook.vo.GainPassTemplateRequest;
import com.passbook.vo.Response;

public interface IGainPassTemplateService {

    /**
     * <h2>用户领取优惠券</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}

