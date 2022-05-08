package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.UserFeedback;

/**
 * 用户意见反馈Mapper接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface UserFeedbackMapper 
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
     * 删除用户意见反馈
     * 
     * @param id 用户意见反馈主键
     * @return 结果
     */
    public int deleteUserFeedbackById(String id);

    /**
     * 批量删除用户意见反馈
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserFeedbackByIds(String[] ids);
}
