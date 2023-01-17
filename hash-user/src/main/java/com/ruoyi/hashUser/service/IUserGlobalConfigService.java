package com.ruoyi.hashUser.service;

import java.util.List;
import com.ruoyi.hashUser.domain.UserGlobalConfig;

/**
 * 版本控制Service接口
 * 
 * @author xxk
 * @date 2023-01-18
 */
public interface IUserGlobalConfigService 
{
    /**
     * 查询版本控制
     * 
     * @param id 版本控制主键
     * @return 版本控制
     */
    public UserGlobalConfig selectUserGlobalConfigById(String id);

    /**
     * 查询版本控制列表
     * 
     * @param userGlobalConfig 版本控制
     * @return 版本控制集合
     */
    public List<UserGlobalConfig> selectUserGlobalConfigList(UserGlobalConfig userGlobalConfig);

    /**
     * 新增版本控制
     * 
     * @param userGlobalConfig 版本控制
     * @return 结果
     */
    public int insertUserGlobalConfig(UserGlobalConfig userGlobalConfig);

    /**
     * 修改版本控制
     * 
     * @param userGlobalConfig 版本控制
     * @return 结果
     */
    public int updateUserGlobalConfig(UserGlobalConfig userGlobalConfig);

    /**
     * 批量删除版本控制
     * 
     * @param ids 需要删除的版本控制主键集合
     * @return 结果
     */
    public int deleteUserGlobalConfigByIds(String[] ids);

    /**
     * 删除版本控制信息
     * 
     * @param id 版本控制主键
     * @return 结果
     */
    public int deleteUserGlobalConfigById(String id);
}
