package com.ruoyi.hashUser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.UserBannerConfigMapper;
import com.ruoyi.hashUser.domain.UserBannerConfig;
import com.ruoyi.hashUser.service.IUserBannerConfigService;

/**
 * Banner图Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-07
 */
@Service
public class UserBannerConfigServiceImpl implements IUserBannerConfigService 
{
    @Autowired
    private UserBannerConfigMapper userBannerConfigMapper;

    /**
     * 查询Banner图
     * 
     * @param id Banner图主键
     * @return Banner图
     */
    @Override
    public UserBannerConfig selectUserBannerConfigById(Long id)
    {
        return userBannerConfigMapper.selectUserBannerConfigById(id);
    }

    /**
     * 查询Banner图列表
     * 
     * @param userBannerConfig Banner图
     * @return Banner图
     */
    @Override
    public List<UserBannerConfig> selectUserBannerConfigList(UserBannerConfig userBannerConfig)
    {
        return userBannerConfigMapper.selectUserBannerConfigList(userBannerConfig);
    }

    /**
     * 新增Banner图
     * 
     * @param userBannerConfig Banner图
     * @return 结果
     */
    @Override
    public int insertUserBannerConfig(UserBannerConfig userBannerConfig)
    {
        return userBannerConfigMapper.insertUserBannerConfig(userBannerConfig);
    }

    /**
     * 修改Banner图
     * 
     * @param userBannerConfig Banner图
     * @return 结果
     */
    @Override
    public int updateUserBannerConfig(UserBannerConfig userBannerConfig)
    {
        return userBannerConfigMapper.updateUserBannerConfig(userBannerConfig);
    }

    /**
     * 批量删除Banner图
     * 
     * @param ids 需要删除的Banner图主键
     * @return 结果
     */
    @Override
    public int deleteUserBannerConfigByIds(Long[] ids)
    {
        return userBannerConfigMapper.deleteUserBannerConfigByIds(ids);
    }

    /**
     * 删除Banner图信息
     * 
     * @param id Banner图主键
     * @return 结果
     */
    @Override
    public int deleteUserBannerConfigById(Long id)
    {
        return userBannerConfigMapper.deleteUserBannerConfigById(id);
    }
}
