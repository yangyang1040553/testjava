package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.UserFeedback;

/**
 * 用户意见反馈Service接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface IUserFeedbackService 
{
    /**
     * 查询用户意见反馈
     * 
     * @param id 用户意见反馈主键
     * @return 用户意见反馈
     */
    public UserFeedback selectUserFeedbackById(String id);

    /**
     * 查询用户意见反馈列表
     * 
     * @param userFeedback 用户意见反馈
     * @return 用户意见反馈集合
     */
    public List<UserFeedback> selectUserFeedbackList(UserFeedback userFeedback);

    /**
     * 新增用户意见反馈
     * 
     * @param userFeedback 用户意见反馈
     * @return 结果
     */
    public int insertUserFeedback(UserFeedback userFeedback);

    /**
     * 修改用户意见反馈
     * 
     * @param userFeedback 用户意见反馈
     * @return 结果
     */
    public int updateUserFeedback(UserFeedback userFeedback);

    /**
     * 批量删除用户意见反馈
     * 
     * @param ids 需要删除的用户意见反馈主键集合
     * @return 结果
     */
    public int deleteUserFeedbackByIds(String[] ids);

    /**
     * 删除用户意见反馈信息
     * 
     * @param id 用户意见反馈主键
     * @return 结果
     */
    public int deleteUserFeedbackById(String id);
}
