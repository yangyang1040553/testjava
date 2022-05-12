package com.ruoyi.hashuser.service.impl;

import java.util.List;

import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.HashUserGlobalConfigMapper;
import com.ruoyi.hashuser.domain.HashUserGlobalConfig;
import com.ruoyi.hashuser.service.IHashUserGlobalConfigService;

/**
 * 用户全局配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-12
 */
@Service
public class HashUserGlobalConfigServiceImpl implements IHashUserGlobalConfigService 
{
    @Autowired
    private HashUserGlobalConfigMapper hashUserGlobalConfigMapper;

    /**
     * 查询用户全局配置
     * 
     * @param id 用户全局配置主键
     * @return 用户全局配置
     */
    @Override
    public HashUserGlobalConfig selectHashUserGlobalConfigById(String id)
    {
        return hashUserGlobalConfigMapper.selectHashUserGlobalConfigById(id);
    }

    /**
     * 查询用户全局配置列表
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 用户全局配置
     */
    @Override
    public List<HashUserGlobalConfig> selectHashUserGlobalConfigList(HashUserGlobalConfig hashUserGlobalConfig)
    {
        return hashUserGlobalConfigMapper.selectHashUserGlobalConfigList(hashUserGlobalConfig);
    }

    /**
     * 新增用户全局配置
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 结果
     */
    @Override
    public int insertHashUserGlobalConfig(HashUserGlobalConfig hashUserGlobalConfig)
    {
        hashUserGlobalConfig.setId(IdUtils.getID12Str());
        return hashUserGlobalConfigMapper.insertHashUserGlobalConfig(hashUserGlobalConfig);
    }

    /**
     * 修改用户全局配置
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 结果
     */
    @Override
    public int updateHashUserGlobalConfig(HashUserGlobalConfig hashUserGlobalConfig)
    {
        return hashUserGlobalConfigMapper.updateHashUserGlobalConfig(hashUserGlobalConfig);
    }

    /**
     * 批量删除用户全局配置
     * 
     * @param ids 需要删除的用户全局配置主键
     * @return 结果
     */
    @Override
    public int deleteHashUserGlobalConfigByIds(String[] ids)
    {
        return hashUserGlobalConfigMapper.deleteHashUserGlobalConfigByIds(ids);
    }

    /**
     * 删除用户全局配置信息
     * 
     * @param id 用户全局配置主键
     * @return 结果
     */
    @Override
    public int deleteHashUserGlobalConfigById(String id)
    {
        return hashUserGlobalConfigMapper.deleteHashUserGlobalConfigById(id);
    }
}
