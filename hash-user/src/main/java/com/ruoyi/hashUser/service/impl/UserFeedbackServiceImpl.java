package com.ruoyi.hashUser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.UserFeedbackMapper;
import com.ruoyi.hashUser.domain.UserFeedback;
import com.ruoyi.hashUser.service.IUserFeedbackService;

/**
 * 用户意见反馈Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-05
 */
@Service
public class UserFeedbackServiceImpl implements IUserFeedbackService 
{
    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    /**
     * 查询用户意见反馈
     * 
     * @param id 用户意见反馈主键
     * @return 用户意见反馈
     */
    @Override
    public UserFeedback selectUserFeedbackById(String id)
    {
        return userFeedbackMapper.selectUserFeedbackById(id);
    }

    /**
     * 查询用户意见反馈列表
     * 
     * @param userFeedback 用户意见反馈
     * @return 用户意见反馈
     */
    @Override
    public List<UserFeedback> selectUserFeedbackList(UserFeedback userFeedback)
    {
        return userFeedbackMapper.selectUserFeedbackList(userFeedback);
    }

    /**
     * 新增用户意见反馈
     * 
     * @param userFeedback 用户意见反馈
     * @return 结果
     */
    @Override
    public int insertUserFeedback(UserFeedback userFeedback)
    {
        userFeedback.setCreateTime(DateUtils.getNowDate());
        return userFeedbackMapper.insertUserFeedback(userFeedback);
    }

    /**
     * 修改用户意见反馈
     * 
     * @param userFeedback 用户意见反馈
     * @return 结果
     */
    @Override
    public int updateUserFeedback(UserFeedback userFeedback)
    {
        return userFeedbackMapper.updateUserFeedback(userFeedback);
    }

    /**
     * 批量删除用户意见反馈
     * 
     * @param ids 需要删除的用户意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteUserFeedbackByIds(String[] ids)
    {
        return userFeedbackMapper.deleteUserFeedbackByIds(ids);
    }

    /**
     * 删除用户意见反馈信息
     * 
     * @param id 用户意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteUserFeedbackById(String id)
    {
        return userFeedbackMapper.deleteUserFeedbackById(id);
    }
}
