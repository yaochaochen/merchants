package com.passbook.mapper;


import com.passbook.constant.Constants;
import com.passbook.vo.User;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * @ClassName UserRowMapper
 * @Author yaochaochen
 * @Date 2019-04-15 19:00
 **/
public class UserRowMapper implements RowMapper<User> {
    
   private static byte[] FAMILY_B = Constants.UserTabale.FAMILY_B.getBytes();
   
   private static byte[] NAME = Constants.UserTabale.NAME.getBytes();
   
   private static byte[] AGE = Constants.UserTabale.AGE.getBytes();
   
   private static byte[] SEX = Constants.UserTabale.SEX.getBytes();
   
   private static byte[] FAMILY_O = Constants.UserTabale.FAMILY_O.getBytes();
   
   private static byte[] PHONE = Constants.UserTabale.PHONE.getBytes();
   
   private static byte[] ADDRESS = Constants.UserTabale.ADDRESS.getBytes();
   
   


    @Override
    public User mapRow(Result result, int i) throws Exception {
        
        User.BaseInfo baseInfo = new User.BaseInfo(
                
                Bytes.toString(result.getValue(FAMILY_B, NAME)),
                (Bytes.toInt(result.getValue(FAMILY_B, AGE))),
                Bytes.toString(result.getValue(FAMILY_B, SEX))
                 
        );
        User.OtherInfo otherInfo = new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O, PHONE)),
                Bytes.toString(result.getValue(FAMILY_O, ADDRESS))
        );
        return new User(Bytes.toLong(result.getRow()), baseInfo,otherInfo);
    }
}
