package com.ruoyi.hashUser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.UserGlobalConfigMapper;
import com.ruoyi.hashUser.domain.UserGlobalConfig;
import com.ruoyi.hashUser.service.IUserGlobalConfigService;

/**
 * 版本控制Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-18
 */
@Service
public class UserGlobalConfigServiceImpl implements IUserGlobalConfigService 
{
    @Autowired
    private UserGlobalConfigMapper userGlobalConfigMapper;

    /**
     * 查询版本控制
     * 
     * @param id 版本控制主键
     * @return 版本控制
     */
    @Override
    public UserGlobalConfig selectUserGlobalConfigById(String id)
    {
        return userGlobalConfigMapper.selectUserGlobalConfigById(id);
    }

    /**
     * 查询版本控制列表
     * 
     * @param userGlobalConfig 版本控制
     * @return 版本控制
     */
    @Override
    public List<UserGlobalConfig> selectUserGlobalConfigList(UserGlobalConfig userGlobalConfig)
    {
        return userGlobalConfigMapper.selectUserGlobalConfigList(userGlobalConfig);
    }

    /**
     * 新增版本控制
     * 
     * @param userGlobalConfig 版本控制
     * @return 结果
     */
    @Override
    public int insertUserGlobalConfig(UserGlobalConfig userGlobalConfig)
    {
        return userGlobalConfigMapper.insertUserGlobalConfig(userGlobalConfig);
    }

    /**
     * 修改版本控制
     * 
     * @param userGlobalConfig 版本控制
     * @return 结果
     */
    @Override
    public int updateUserGlobalConfig(UserGlobalConfig userGlobalConfig)
    {
        return userGlobalConfigMapper.updateUserGlobalConfig(userGlobalConfig);
    }

    /**
     * 批量删除版本控制
     * 
     * @param ids 需要删除的版本控制主键
     * @return 结果
     */
    @Override
    public int deleteUserGlobalConfigByIds(String[] ids)
    {
        return userGlobalConfigMapper.deleteUserGlobalConfigByIds(ids);
    }

    /**
     * 删除版本控制信息
     * 
     * @param id 版本控制主键
     * @return 结果
     */
    @Override
    public int deleteUserGlobalConfigById(String id)
    {
        return userGlobalConfigMapper.deleteUserGlobalConfigById(id);
    }
}
