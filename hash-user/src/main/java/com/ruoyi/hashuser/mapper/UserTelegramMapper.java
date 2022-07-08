package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.UserTelegram;

/**
 * 用户飞机Mapper接口
 * 
 * @author xxk
 * @date 2022-07-08
 */
public interface UserTelegramMapper 
{
    /**
     * 查询用户飞机
     * 
     * @param id 用户飞机主键
     * @return 用户飞机
     */
    public UserTelegram selectUserTelegramById(Long id);

    /**
     * 查询用户飞机列表
     * 
     * @param userTelegram 用户飞机
     * @return 用户飞机集合
     */
    public List<UserTelegram> selectUserTelegramList(UserTelegram userTelegram);

    /**
     * 新增用户飞机
     * 
     * @param userTelegram 用户飞机
     * @return 结果
     */
    public int insertUserTelegram(UserTelegram userTelegram);

    /**
     * 修改用户飞机
     * 
     * @param userTelegram 用户飞机
     * @return 结果
     */
    public int updateUserTelegram(UserTelegram userTelegram);

    /**
     * 删除用户飞机
     * 
     * @param id 用户飞机主键
     * @return 结果
     */
    public int deleteUserTelegramById(Long id);

    /**
     * 批量删除用户飞机
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserTelegramByIds(Long[] ids);
}
