package com.passbook.merchants.vo;

import com.passbook.merchants.constans.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import com.passbook.merchants.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.NumberUp;

/**
 * 创建商户请求对象
 * @ClassName CreateMerchantsRequest
 * @Author yaochaochen
 * @Date 2019-04-14 14:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest  {
    /*商户名称*/
    private String name;
    
    /*商户logo*/
    private String logoUrl;
    
    /*商户营业执照*/
    private String businessLicenseUrl;
    
    private String phone;

    /**商户地址*/
    private String address;

    /**
     * 验证参数有效性
     * @param merchantsDao
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        
        if (merchantsDao.findByName(name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }
        
        if (null == this.logoUrl) {
            
            return  ErrorCode.EMPY_LOGO;
        }
        if (null  == this.address) {
            return  ErrorCode.EMPY_ADDRESS;
        }
        if (null == this.phone) {
            return ErrorCode.ERROR_PHONE;
        }
        return ErrorCode.SUCCESS;
    }

    /**
     *请求对象转换 
     * @return
     */
    
    public Merchants toMerchants() {
        
        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setAddress(address);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        
        return merchants;
    }
    
}
