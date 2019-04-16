package com.passbook.vo;

import com.passbook.entity.Merchants;

/**
 * @ClassName PassInfo
 * @Author yaochaochen
 * @Date 2019-04-15 16:40
 **/
public class PassInfo {


    /** 优惠券 */
    private Pass pass;

    /** 优惠券模板 */
    private PassTemplate passTemplate;

    /** 优惠券对应的商户 */
    private Merchants merchants;

     public PassInfo(Pass pass, PassTemplate passTemplate, Merchants merchants) {

         this.pass =pass;
         this.passTemplate = passTemplate;
         this.merchants = merchants;
     }
}
