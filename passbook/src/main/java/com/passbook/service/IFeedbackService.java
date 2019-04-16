package com.passbook.service;

import com.passbook.vo.Feedback;
import com.passbook.vo.Response;

/***
 * 
 * <h1>评论功能: 即用户评论相关实现</h1>
 */

public interface IFeedbackService {

    /**
     * 
     * <h2>创建评论</h2>
     * @param feedback {@link Feedback}
     * @return
     */
    Response createFeedback(Feedback feedback);


    /***
     * <h1>获取用户下的评论</h1>
     * @param userId 用户id
     * @return {@link Response}
     */
    Response getFeedback(Long userId);
    
    
}
