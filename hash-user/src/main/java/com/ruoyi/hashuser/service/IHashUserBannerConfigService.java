package com.ruoyi.hashuser.service;

import com.ruoyi.hashuser.domain.HashUserBannerConfig;

import java.util.List;

/**
 * 用户首页的banner列Service接口
 * 
 * @author xxk
 * @date 2022-05-18
 */
public interface IHashUserBannerConfigService 
{
    /**
     * 查询用户首页的banner列
     * 
     * @param id 用户首页的banner列主键
     * @return 用户首页的banner列
     */
    public HashUserBannerConfig selectHashUserBannerConfigById(Long id);

    /**
     * 查询用户首页的banner列列表
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 用户首页的banner列集合
     */
    public List<HashUserBannerConfig> selectHashUserBannerConfigList(HashUserBannerConfig hashUserBannerConfig);

    /**
     * 新增用户首页的banner列
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 结果
     */
    public int insertHashUserBannerConfig(HashUserBannerConfig hashUserBannerConfig);

    /**
     * 修改用户首页的banner列
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 结果
     */
    public int updateHashUserBannerConfig(HashUserBannerConfig hashUserBannerConfig);

    /**
     * 批量删除用户首页的banner列
     * 
     * @param ids 需要删除的用户首页的banner列主键集合
     * @return 结果
     */
    public int deleteHashUserBannerConfigByIds(Long[] ids);

    /**
     * 删除用户首页的banner列信息
     * 
     * @param id 用户首页的banner列主键
     * @return 结果
     */
    public int deleteHashUserBannerConfigById(Long id);
}
