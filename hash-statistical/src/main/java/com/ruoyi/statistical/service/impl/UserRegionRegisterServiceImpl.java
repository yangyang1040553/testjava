package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.UserRegionRegisterMapper;
import com.ruoyi.statistical.domain.UserRegionRegister;
import com.ruoyi.statistical.service.IUserRegionRegisterService;

/**
 * 用户区域注册次数Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-10
 */
@Service
public class UserRegionRegisterServiceImpl implements IUserRegionRegisterService 
{
    @Autowired
    private UserRegionRegisterMapper userRegionRegisterMapper;

    /**
     * 查询用户区域注册次数
     * 
     * @param region 用户区域注册次数主键
     * @return 用户区域注册次数
     */
    @Override
    public UserRegionRegister selectUserRegionRegisterByRegion(String region)
    {
        return userRegionRegisterMapper.selectUserRegionRegisterByRegion(region);
    }

    /**
     * 查询用户区域注册次数列表
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 用户区域注册次数
     */
    @Override
    public List<UserRegionRegister> selectUserRegionRegisterList(UserRegionRegister userRegionRegister)
    {
        return userRegionRegisterMapper.selectUserRegionRegisterList(userRegionRegister);
    }

    /**
     * 新增用户区域注册次数
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 结果
     */
    @Override
    public int insertUserRegionRegister(UserRegionRegister userRegionRegister)
    {
        return userRegionRegisterMapper.insertUserRegionRegister(userRegionRegister);
    }

    /**
     * 修改用户区域注册次数
     * 
     * @param userRegionRegister 用户区域注册次数
     * @return 结果
     */
    @Override
    public int updateUserRegionRegister(UserRegionRegister userRegionRegister)
    {
        return userRegionRegisterMapper.updateUserRegionRegister(userRegionRegister);
    }

    /**
     * 批量删除用户区域注册次数
     * 
     * @param regions 需要删除的用户区域注册次数主键
     * @return 结果
     */
    @Override
    public int deleteUserRegionRegisterByRegions(String[] regions)
    {
        return userRegionRegisterMapper.deleteUserRegionRegisterByRegions(regions);
    }

    /**
     * 删除用户区域注册次数信息
     * 
     * @param region 用户区域注册次数主键
     * @return 结果
     */
    @Override
    public int deleteUserRegionRegisterByRegion(String region)
    {
        return userRegionRegisterMapper.deleteUserRegionRegisterByRegion(region);
    }
}
