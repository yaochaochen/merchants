package com.passbook.dao;

import com.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * <h2>通过Id查询商户对象</h2>
     * @param id 主键
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);


    /**
     * <h2>根据商户获取商户对象</h2>
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);

    /**
     * <h2>根据商户 IDS 获取商户对象</h2>
     * @param ids
     * @return
     */
    List<Merchants> findByIdIn(List<Integer> ids);
}
