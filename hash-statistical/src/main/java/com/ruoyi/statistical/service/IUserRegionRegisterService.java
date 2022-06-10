package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.UserRegionRegister;

/**
 * 用户区域注册次数Service接口
 * 
 * @author xxk
 * @date 2022-06-10
 */
public interface IUserRegionRegisterService 
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
     * 批量删除用户区域注册次数
     * 
     * @param regions 需要删除的用户区域注册次数主键集合
     * @return 结果
     */
    public int deleteUserRegionRegisterByRegions(String[] regions);

    /**
     * 删除用户区域注册次数信息
     * 
     * @param region 用户区域注册次数主键
     * @return 结果
     */
    public int deleteUserRegionRegisterByRegion(String region);
}
