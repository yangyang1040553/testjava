package com.ruoyi.hashUser.service;

import java.util.List;
import com.ruoyi.hashUser.domain.UserAdvertise;

/**
 * 广告管理Service接口
 * 
 * @author xxk
 * @date 2023-01-05
 */
public interface IUserAdvertiseService 
{
    /**
     * 查询广告管理
     * 
     * @param id 广告管理主键
     * @return 广告管理
     */
    public UserAdvertise selectUserAdvertiseById(Long id);

    /**
     * 查询广告管理列表
     * 
     * @param userAdvertise 广告管理
     * @return 广告管理集合
     */
    public List<UserAdvertise> selectUserAdvertiseList(UserAdvertise userAdvertise);

    /**
     * 新增广告管理
     * 
     * @param userAdvertise 广告管理
     * @return 结果
     */
    public int insertUserAdvertise(UserAdvertise userAdvertise);

    /**
     * 修改广告管理
     * 
     * @param userAdvertise 广告管理
     * @return 结果
     */
    public int updateUserAdvertise(UserAdvertise userAdvertise);

    /**
     * 批量删除广告管理
     * 
     * @param ids 需要删除的广告管理主键集合
     * @return 结果
     */
    public int deleteUserAdvertiseByIds(Long[] ids);

    /**
     * 删除广告管理信息
     * 
     * @param id 广告管理主键
     * @return 结果
     */
    public int deleteUserAdvertiseById(Long id);
}
