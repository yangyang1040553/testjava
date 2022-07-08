package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserTelegramMapper;
import com.ruoyi.hashuser.domain.UserTelegram;
import com.ruoyi.hashuser.service.IUserTelegramService;

/**
 * 用户飞机Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-08
 */
@Service
public class UserTelegramServiceImpl implements IUserTelegramService 
{
    @Autowired
    private UserTelegramMapper userTelegramMapper;

    /**
     * 查询用户飞机
     * 
     * @param id 用户飞机主键
     * @return 用户飞机
     */
    @Override
    public UserTelegram selectUserTelegramById(Long id)
    {
        return userTelegramMapper.selectUserTelegramById(id);
    }

    /**
     * 查询用户飞机列表
     * 
     * @param userTelegram 用户飞机
     * @return 用户飞机
     */
    @Override
    public List<UserTelegram> selectUserTelegramList(UserTelegram userTelegram)
    {
        return userTelegramMapper.selectUserTelegramList(userTelegram);
    }

    /**
     * 新增用户飞机
     * 
     * @param userTelegram 用户飞机
     * @return 结果
     */
    @Override
    public int insertUserTelegram(UserTelegram userTelegram)
    {
        userTelegram.setCreateTime(DateUtils.getNowDate());
        return userTelegramMapper.insertUserTelegram(userTelegram);
    }

    /**
     * 修改用户飞机
     * 
     * @param userTelegram 用户飞机
     * @return 结果
     */
    @Override
    public int updateUserTelegram(UserTelegram userTelegram)
    {
        userTelegram.setUpdateTime(DateUtils.getNowDate());
        return userTelegramMapper.updateUserTelegram(userTelegram);
    }

    /**
     * 批量删除用户飞机
     * 
     * @param ids 需要删除的用户飞机主键
     * @return 结果
     */
    @Override
    public int deleteUserTelegramByIds(Long[] ids)
    {
        return userTelegramMapper.deleteUserTelegramByIds(ids);
    }

    /**
     * 删除用户飞机信息
     * 
     * @param id 用户飞机主键
     * @return 结果
     */
    @Override
    public int deleteUserTelegramById(Long id)
    {
        return userTelegramMapper.deleteUserTelegramById(id);
    }
}
