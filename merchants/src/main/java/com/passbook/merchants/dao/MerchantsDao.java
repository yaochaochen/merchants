package com.passbook.merchants.dao;

import com.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 接口
 * @ClassName MerchantsDao
 * @Author yaochaochen
 * @Date 2019-04-14 13:41
 **/
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * 根据主键查寻
     * @param id 商户Id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据商户名称查询
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
    
}
