package com.passbook.service;

import com.passbook.vo.PassTemplate;

public interface IHbasePassService {

    /**
     * 写入
     * @param passTemplate
     * @return
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
