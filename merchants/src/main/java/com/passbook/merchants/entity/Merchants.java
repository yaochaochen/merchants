package com.passbook.merchants.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <h1>商户对象</h1>
 * @ClassName Merchants
 * @Author yaochaochen
 * @Date 2019-04-14 13:24
 **/
@Data
@NoArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {
    
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;
    /*商户名称 全局唯一*/
    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    /**商户logo*/
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;
    
    /**营业执照*/
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;
    
    /**商户联系电话*/
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;
    
    /**商户地址**/
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    
    /*商户是否审核通过**/
    @Basic
    @Column(name = "is_audit", nullable = false)
    private boolean isAudit = false;
    
}
