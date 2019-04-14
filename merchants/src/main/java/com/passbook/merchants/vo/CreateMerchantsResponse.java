package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户响应对象
 * @ClassName CreateMerchantsResponse
 * @Author yaochaochen
 * @Date 2019-04-14 14:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantsResponse  {
    
    /**商户Id 创建失败 -1 **/
    private Integer id;
}
