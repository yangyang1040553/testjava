package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hashuser.domain.HashUserBannerConfig;
import com.ruoyi.hashuser.mapper.HashUserBannerConfigMapper;
import com.ruoyi.hashuser.service.IHashUserBannerConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户首页的banner列Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-18
 */
@Service
public class HashUserBannerConfigServiceImpl implements IHashUserBannerConfigService
{
    @Autowired
    private HashUserBannerConfigMapper hashUserBannerConfigMapper;

    /**
     * 查询用户首页的banner列
     * 
     * @param id 用户首页的banner列主键
     * @return 用户首页的banner列
     */
    @Override
    public HashUserBannerConfig selectHashUserBannerConfigById(Long id)
    {
        return hashUserBannerConfigMapper.selectHashUserBannerConfigById(id);
    }

    /**
     * 查询用户首页的banner列列表
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 用户首页的banner列
     */
    @Override
    public List<HashUserBannerConfig> selectHashUserBannerConfigList(HashUserBannerConfig hashUserBannerConfig)
    {
        return hashUserBannerConfigMapper.selectHashUserBannerConfigList(hashUserBannerConfig);
    }

    /**
     * 新增用户首页的banner列
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 结果
     */
    @Override
    public int insertHashUserBannerConfig(HashUserBannerConfig hashUserBannerConfig)
    {
        hashUserBannerConfig.setCreateTime(DateUtils.getNowDate());
        return hashUserBannerConfigMapper.insertHashUserBannerConfig(hashUserBannerConfig);
    }

    /**
     * 修改用户首页的banner列
     * 
     * @param hashUserBannerConfig 用户首页的banner列
     * @return 结果
     */
    @Override
    public int updateHashUserBannerConfig(HashUserBannerConfig hashUserBannerConfig)
    {
        hashUserBannerConfig.setUpdateTime(DateUtils.getNowDate());
        return hashUserBannerConfigMapper.updateHashUserBannerConfig(hashUserBannerConfig);
    }

    /**
     * 批量删除用户首页的banner列
     * 
     * @param ids 需要删除的用户首页的banner列主键
     * @return 结果
     */
    @Override
    public int deleteHashUserBannerConfigByIds(Long[] ids)
    {
        return hashUserBannerConfigMapper.deleteHashUserBannerConfigByIds(ids);
    }

    /**
     * 删除用户首页的banner列信息
     * 
     * @param id 用户首页的banner列主键
     * @return 结果
     */
    @Override
    public int deleteHashUserBannerConfigById(Long id)
    {
        return hashUserBannerConfigMapper.deleteHashUserBannerConfigById(id);
    }
}
