package com.passbook.merchants.vo;

import com.passbook.merchants.constans.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>投放优惠券</h1>
 * @ClassName PassTemplate
 * @Author yaochaochen
 * @Date 2019-04-14 13:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    
    private Integer id;

    /**
     优惠券 标题
     */
    private String title;
    
    /*优惠券摘要*/
    private String summary;
    
    /*优惠券描述*/
    private String decs;
    
    /**对打优惠券个数**/
    private long limit;
    
    /**优惠券是否有token*/
    private boolean passToken;
    
    /**优惠券背景**/
    private Integer background;
    
    /**优惠券开始时间*/
    private Date start;
    
    /**优惠券结束时间*/
    private Date end;

    /***
     * 校验优惠券的有效性
     * @param merchantsDao
     * @return {@link MerchantsDao}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        
        if(null == merchantsDao.findById(id)) {
            return ErrorCode.MECHANTS_NOT_EXIST;
        }
        return  ErrorCode.SUCCESS;
        
    }
    
}
