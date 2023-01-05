package com.ruoyi.hashUser.mapper;

import java.util.List;
import com.ruoyi.hashUser.domain.UserAdvertise;

/**
 * 用户意见Mapper接口
 * 
 * @author xxk
 * @date 2023-01-05
 */
public interface UserAdvertiseMapper 
{
    /**
     * 查询用户意见
     * 
     * @param id 用户意见主键
     * @return 用户意见
     */
    public UserAdvertise selectUserAdvertiseById(Long id);

    /**
     * 查询用户意见列表
     * 
     * @param userAdvertise 用户意见
     * @return 用户意见集合
     */
    public List<UserAdvertise> selectUserAdvertiseList(UserAdvertise userAdvertise);

    /**
     * 新增用户意见
     * 
     * @param userAdvertise 用户意见
     * @return 结果
     */
    public int insertUserAdvertise(UserAdvertise userAdvertise);

    /**
     * 修改用户意见
     * 
     * @param userAdvertise 用户意见
     * @return 结果
     */
    public int updateUserAdvertise(UserAdvertise userAdvertise);

    /**
     * 删除用户意见
     * 
     * @param id 用户意见主键
     * @return 结果
     */
    public int deleteUserAdvertiseById(Long id);

    /**
     * 批量删除用户意见
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserAdvertiseByIds(Long[] ids);
}
