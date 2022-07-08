package com.ruoyi.hashuser.mapper;

import java.util.List;

import com.ruoyi.hashuser.domain.UserClientLog;

/**
 * 客户端日志Mapper接口
 *
 * @author xxk
 * @date 2022-07-08
 */
public interface UserClientLogMapper {
    /**
     * 查询客户端日志
     *
     * @param id 客户端日志主键
     * @return 客户端日志
     */
    public UserClientLog selectUserClientLogById(Long id);

    /**
     * 查询客户端日志列表
     *
     * @param userClientLog 客户端日志
     * @return 客户端日志集合
     */
    public List<UserClientLog> selectUserClientLogList(UserClientLog userClientLog);

    /**
     * 新增客户端日志
     *
     * @param userClientLog 客户端日志
     * @return 结果
     */
    public int insertUserClientLog(UserClientLog userClientLog);

    /**
     * 修改客户端日志
     *
     * @param userClientLog 客户端日志
     * @return 结果
     */
    public int updateUserClientLog(UserClientLog userClientLog);

    /**
     * 删除客户端日志
     *
     * @param id 客户端日志主键
     * @return 结果
     */
    public int deleteUserClientLogById(Long id);

    /**
     * 批量删除客户端日志
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserClientLogByIds(Long[] ids);
}
