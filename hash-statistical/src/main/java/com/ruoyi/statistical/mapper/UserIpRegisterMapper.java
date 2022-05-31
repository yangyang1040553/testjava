package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.UserIpRegister;

/**
 * 用户ip注册次数Mapper接口
 * 
 * @author xxk
 * @date 2022-05-31
 */
public interface UserIpRegisterMapper 
{
    /**
     * 查询用户ip注册次数
     * 
     * @param ip 用户ip注册次数主键
     * @return 用户ip注册次数
     */
    public UserIpRegister selectUserIpRegisterByIp(String ip);

    /**
     * 查询用户ip注册次数列表
     * 
     * @param userIpRegister 用户ip注册次数
     * @return 用户ip注册次数集合
     */
    public List<UserIpRegister> selectUserIpRegisterList(UserIpRegister userIpRegister);

    /**
     * 新增用户ip注册次数
     * 
     * @param userIpRegister 用户ip注册次数
     * @return 结果
     */
    public int insertUserIpRegister(UserIpRegister userIpRegister);

    /**
     * 修改用户ip注册次数
     * 
     * @param userIpRegister 用户ip注册次数
     * @return 结果
     */
    public int updateUserIpRegister(UserIpRegister userIpRegister);

    /**
     * 删除用户ip注册次数
     * 
     * @param ip 用户ip注册次数主键
     * @return 结果
     */
    public int deleteUserIpRegisterByIp(String ip);

    /**
     * 批量删除用户ip注册次数
     * 
     * @param ips 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserIpRegisterByIps(String[] ips);
}
