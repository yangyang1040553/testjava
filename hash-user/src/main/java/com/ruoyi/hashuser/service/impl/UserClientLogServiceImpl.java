package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserClientLogMapper;
import com.ruoyi.hashuser.domain.UserClientLog;
import com.ruoyi.hashuser.service.IUserClientLogService;

/**
 * 客户端日志Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-08
 */
@Service
public class UserClientLogServiceImpl implements IUserClientLogService 
{
    @Autowired
    private UserClientLogMapper userClientLogMapper;

    /**
     * 查询客户端日志
     * 
     * @param id 客户端日志主键
     * @return 客户端日志
     */
    @Override
    public UserClientLog selectUserClientLogById(Long id)
    {
        return userClientLogMapper.selectUserClientLogById(id);
    }

    /**
     * 查询客户端日志列表
     * 
     * @param userClientLog 客户端日志
     * @return 客户端日志
     */
    @Override
    public List<UserClientLog> selectUserClientLogList(UserClientLog userClientLog)
    {
        return userClientLogMapper.selectUserClientLogList(userClientLog);
    }

    /**
     * 新增客户端日志
     * 
     * @param userClientLog 客户端日志
     * @return 结果
     */
    @Override
    public int insertUserClientLog(UserClientLog userClientLog)
    {
        userClientLog.setCreateTime(DateUtils.getNowDate());
        return userClientLogMapper.insertUserClientLog(userClientLog);
    }

    /**
     * 修改客户端日志
     * 
     * @param userClientLog 客户端日志
     * @return 结果
     */
    @Override
    public int updateUserClientLog(UserClientLog userClientLog)
    {
        return userClientLogMapper.updateUserClientLog(userClientLog);
    }

    /**
     * 批量删除客户端日志
     * 
     * @param ids 需要删除的客户端日志主键
     * @return 结果
     */
    @Override
    public int deleteUserClientLogByIds(Long[] ids)
    {
        return userClientLogMapper.deleteUserClientLogByIds(ids);
    }

    /**
     * 删除客户端日志信息
     * 
     * @param id 客户端日志主键
     * @return 结果
     */
    @Override
    public int deleteUserClientLogById(Long id)
    {
        return userClientLogMapper.deleteUserClientLogById(id);
    }
}
