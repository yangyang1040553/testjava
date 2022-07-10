package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.UserTelegramGroup;

/**
 * 群组列表Mapper接口
 * 
 * @author xxk
 * @date 2022-07-10
 */
public interface UserTelegramGroupMapper 
{
    /**
     * 查询群组列表
     * 
     * @param groupId 群组列表主键
     * @return 群组列表
     */
    public UserTelegramGroup selectUserTelegramGroupByGroupId(String groupId);

    /**
     * 查询群组列表列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 群组列表集合
     */
    public List<UserTelegramGroup> selectUserTelegramGroupList(UserTelegramGroup userTelegramGroup);

    /**
     * 新增群组列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 结果
     */
    public int insertUserTelegramGroup(UserTelegramGroup userTelegramGroup);

    /**
     * 修改群组列表
     * 
     * @param userTelegramGroup 群组列表
     * @return 结果
     */
    public int updateUserTelegramGroup(UserTelegramGroup userTelegramGroup);

    /**
     * 删除群组列表
     * 
     * @param groupId 群组列表主键
     * @return 结果
     */
    public int deleteUserTelegramGroupByGroupId(String groupId);

    /**
     * 批量删除群组列表
     * 
     * @param groupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserTelegramGroupByGroupIds(String[] groupIds);
}
