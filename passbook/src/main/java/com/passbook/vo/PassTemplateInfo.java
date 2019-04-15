package com.passbook.vo;

import com.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PassTemplateInfo
 * @Author yaochaochen
 * @Date 2019-04-15 16:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassTemplateInfo {

    /** 优惠券模板 */
    private PassTemplate passTemplate;

    /** 优惠券对应的商户 */
    private Merchants merchants;
    
}
