package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.UserH5Feedback;

/**
 * 落地页H5反馈Service接口
 * 
 * @author xxk
 * @date 2022-07-01
 */
public interface IUserH5FeedbackService 
{
    /**
     * 查询落地页H5反馈
     * 
     * @param id 落地页H5反馈主键
     * @return 落地页H5反馈
     */
    public UserH5Feedback selectUserH5FeedbackById(Long id);

    /**
     * 查询落地页H5反馈列表
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 落地页H5反馈集合
     */
    public List<UserH5Feedback> selectUserH5FeedbackList(UserH5Feedback userH5Feedback);

    /**
     * 新增落地页H5反馈
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 结果
     */
    public int insertUserH5Feedback(UserH5Feedback userH5Feedback);

    /**
     * 修改落地页H5反馈
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 结果
     */
    public int updateUserH5Feedback(UserH5Feedback userH5Feedback);

    /**
     * 批量删除落地页H5反馈
     * 
     * @param ids 需要删除的落地页H5反馈主键集合
     * @return 结果
     */
    public int deleteUserH5FeedbackByIds(Long[] ids);

    /**
     * 删除落地页H5反馈信息
     * 
     * @param id 落地页H5反馈主键
     * @return 结果
     */
    public int deleteUserH5FeedbackById(Long id);
}
