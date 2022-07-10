package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserTelegramGroupMapper;
import com.ruoyi.hashuser.domain.UserTelegramGroup;
import com.ruoyi.hashuser.service.IUserTelegramGroupService;

/**
 * 群组列表Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-10
 */
@Service
public class UserTelegramGroupServiceImpl implements IUserTelegramGroupService 
{
    @Autowired
    private UserTelegramGroupMapper userTelegramGroupMapper;

    /**
     * 查询群组列表
     * 
     * @param groupId 群组列表主键
     * @return 群组列表
     */
    @Override
    public UserTelegramGroup selectUserTelegramGroupByGroupId(String groupId)
    {
        return userTelegramGroupMapper.selectUserTelegramGroupByGroupId(groupId);
    }

    /**
     * 查询群组列表列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 群组列表
     */
    @Override
    public List<UserTelegramGroup> selectUserTelegramGroupList(UserTelegramGroup userTelegramGroup)
    {
        return userTelegramGroupMapper.selectUserTelegramGroupList(userTelegramGroup);
    }

    /**
     * 新增群组列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 结果
     */
    @Override
    public int insertUserTelegramGroup(UserTelegramGroup userTelegramGroup)
    {
        userTelegramGroup.setCreateTime(DateUtils.getNowDate());
        return userTelegramGroupMapper.insertUserTelegramGroup(userTelegramGroup);
    }

    /**
     * 修改群组列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 结果
     */
    @Override
    public int updateUserTelegramGroup(UserTelegramGroup userTelegramGroup)
    {
        return userTelegramGroupMapper.updateUserTelegramGroup(userTelegramGroup);
    }

    /**
     * 批量删除群组列表
     * 
     * @param groupIds 需要删除的群组列表主键
     * @return 结果
     */
    @Override
    public int deleteUserTelegramGroupByGroupIds(String[] groupIds)
    {
        return userTelegramGroupMapper.deleteUserTelegramGroupByGroupIds(groupIds);
    }

    /**
     * 删除群组列表信息
     * 
     * @param groupId 群组列表主键
     * @return 结果
     */
    @Override
    public int deleteUserTelegramGroupByGroupId(String groupId)
    {
        return userTelegramGroupMapper.deleteUserTelegramGroupByGroupId(groupId);
    }
}
