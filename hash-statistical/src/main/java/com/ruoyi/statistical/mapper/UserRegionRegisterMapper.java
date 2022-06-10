package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.UserRegionRegister;

/**
 * 用户区域注册次数Mapper接口
 * 
 * @author xxk
 * @date 2022-06-10
 */
public interface UserRegionRegisterMapper 
{
    /**
     * 查询用户区域注册次数
     * 
     * @param region 用户区域注册次数主键
     * @return 用户区域注册次数
     */
    public UserRegionRegister selectUserRegionRegisterByRegion(String region);

    /**
     * 查询用户区域注册次数列表
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 用户区域注册次数集合
     */
    public List<UserRegionRegister> selectUserRegionRegisterList(UserRegionRegister userRegionRegister);

    /**
     * 新增用户区域注册次数
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 结果
     */
    public int insertUserRegionRegister(UserRegionRegister userRegionRegister);

    /**
     * 修改用户区域注册次数
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 结果
     */
    public int updateUserRegionRegister(UserRegionRegister userRegionRegister);

    /**
     * 删除用户区域注册次数
     * 
     * @param region 用户区域注册次数主键
     * @return 结果
     */
    public int deleteUserRegionRegisterByRegion(String region);

    /**
     * 批量删除用户区域注册次数
     * 
     * @param regions 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserRegionRegisterByRegions(String[] regions);
}
