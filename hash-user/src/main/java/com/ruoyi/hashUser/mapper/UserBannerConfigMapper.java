package com.ruoyi.hashUser.mapper;

import java.util.List;
import com.ruoyi.hashUser.domain.UserBannerConfig;

/**
 * Banner图Mapper接口
 * 
 * @author xxk
 * @date 2023-01-07
 */
public interface UserBannerConfigMapper 
{
    /**
     * 查询Banner图
     * 
     * @param id Banner图主键
     * @return Banner图
     */
    public UserBannerConfig selectUserBannerConfigById(Long id);

    /**
     * 查询Banner图列表
     * 
     * @param userBannerConfig Banner图
     * @return Banner图集合
     */
    public List<UserBannerConfig> selectUserBannerConfigList(UserBannerConfig userBannerConfig);

    /**
     * 新增Banner图
     * 
     * @param userBannerConfig Banner图
     * @return 结果
     */
    public int insertUserBannerConfig(UserBannerConfig userBannerConfig);

    /**
     * 修改Banner图
     * 
     * @param userBannerConfig Banner图
     * @return 结果
     */
    public int updateUserBannerConfig(UserBannerConfig userBannerConfig);

    /**
     * 删除Banner图
     * 
     * @param id Banner图主键
     * @return 结果
     */
    public int deleteUserBannerConfigById(Long id);

    /**
     * 批量删除Banner图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserBannerConfigByIds(Long[] ids);
}
