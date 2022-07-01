package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserH5FeedbackMapper;
import com.ruoyi.hashuser.domain.UserH5Feedback;
import com.ruoyi.hashuser.service.IUserH5FeedbackService;

/**
 * 落地页H5反馈Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-01
 */
@Service
public class UserH5FeedbackServiceImpl implements IUserH5FeedbackService 
{
    @Autowired
    private UserH5FeedbackMapper userH5FeedbackMapper;

    /**
     * 查询落地页H5反馈
     * 
     * @param id 落地页H5反馈主键
     * @return 落地页H5反馈
     */
    @Override
    public UserH5Feedback selectUserH5FeedbackById(Long id)
    {
        return userH5FeedbackMapper.selectUserH5FeedbackById(id);
    }

    /**
     * 查询落地页H5反馈列表
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 落地页H5反馈
     */
    @Override
    public List<UserH5Feedback> selectUserH5FeedbackList(UserH5Feedback userH5Feedback)
    {
        return userH5FeedbackMapper.selectUserH5FeedbackList(userH5Feedback);
    }

    /**
     * 新增落地页H5反馈
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 结果
     */
    @Override
    public int insertUserH5Feedback(UserH5Feedback userH5Feedback)
    {
        userH5Feedback.setCreateTime(DateUtils.getNowDate());
        return userH5FeedbackMapper.insertUserH5Feedback(userH5Feedback);
    }

    /**
     * 修改落地页H5反馈
     * 
     * @param userH5Feedback 落地页H5反馈
     * @return 结果
     */
    @Override
    public int updateUserH5Feedback(UserH5Feedback userH5Feedback)
    {
        return userH5FeedbackMapper.updateUserH5Feedback(userH5Feedback);
    }

    /**
     * 批量删除落地页H5反馈
     * 
     * @param ids 需要删除的落地页H5反馈主键
     * @return 结果
     */
    @Override
    public int deleteUserH5FeedbackByIds(Long[] ids)
    {
        return userH5FeedbackMapper.deleteUserH5FeedbackByIds(ids);
    }

    /**
     * 删除落地页H5反馈信息
     * 
     * @param id 落地页H5反馈主键
     * @return 结果
     */
    @Override
    public int deleteUserH5FeedbackById(Long id)
    {
        return userH5FeedbackMapper.deleteUserH5FeedbackById(id);
    }
}
