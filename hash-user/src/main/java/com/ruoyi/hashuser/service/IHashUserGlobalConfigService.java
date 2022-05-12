package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserGlobalConfig;

/**
 * 用户全局配置Service接口
 * 
 * @author xxk
 * @date 2022-05-12
 */
public interface IHashUserGlobalConfigService 
{
    /**
     * 查询用户全局配置
     * 
     * @param id 用户全局配置主键
     * @return 用户全局配置
     */
    public HashUserGlobalConfig selectHashUserGlobalConfigById(String id);

    /**
     * 查询用户全局配置列表
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 用户全局配置集合
     */
    public List<HashUserGlobalConfig> selectHashUserGlobalConfigList(HashUserGlobalConfig hashUserGlobalConfig);

    /**
     * 新增用户全局配置
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 结果
     */
    public int insertHashUserGlobalConfig(HashUserGlobalConfig hashUserGlobalConfig);

    /**
     * 修改用户全局配置
     * 
     * @param hashUserGlobalConfig 用户全局配置
     * @return 结果
     */
    public int updateHashUserGlobalConfig(HashUserGlobalConfig hashUserGlobalConfig);

    /**
     * 批量删除用户全局配置
     * 
     * @param ids 需要删除的用户全局配置主键集合
     * @return 结果
     */
    public int deleteHashUserGlobalConfigByIds(String[] ids);

    /**
     * 删除用户全局配置信息
     * 
     * @param id 用户全局配置主键
     * @return 结果
     */
    public int deleteHashUserGlobalConfigById(String id);
}
