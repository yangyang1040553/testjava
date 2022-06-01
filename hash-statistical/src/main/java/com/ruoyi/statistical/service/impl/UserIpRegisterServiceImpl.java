package com.ruoyi.statistical.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.mapper.HashUserMapper;
import com.ruoyi.hashuser.redis.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.UserIpRegisterMapper;
import com.ruoyi.statistical.domain.UserIpRegister;
import com.ruoyi.statistical.service.IUserIpRegisterService;

/**
 * 用户ip注册次数Service业务层处理
 *
 * @author xxk
 * @date 2022-05-31
 */
@Service
public class UserIpRegisterServiceImpl implements IUserIpRegisterService {
    @Autowired
    private UserIpRegisterMapper userIpRegisterMapper;


    @Autowired
    private HashUserMapper hashUserMapper;

    @Autowired
    private UserRedis userRedis;

    //  IP 被禁用
    public static final int DISABLE = 1;

    /**
     * 查询用户ip注册次数
     *
     * @param ip 用户ip注册次数主键
     * @return 用户ip注册次数
     */
    @Override
    public UserIpRegister selectUserIpRegisterByIp(String ip) {
        return userIpRegisterMapper.selectUserIpRegisterByIp(ip);
    }

    /**
     * 查询用户ip注册次数列表
     *
     * @param userIpRegister 用户ip注册次数
     * @return 用户ip注册次数
     */
    @Override
    public List<UserIpRegister> selectUserIpRegisterList(UserIpRegister userIpRegister) {
        return userIpRegisterMapper.selectUserIpRegisterList(userIpRegister);
    }

    /**
     * 新增用户ip注册次数
     *
     * @param userIpRegister 用户ip注册次数
     * @return 结果
     */
    @Override
    public int insertUserIpRegister(UserIpRegister userIpRegister) {
        return userIpRegisterMapper.insertUserIpRegister(userIpRegister);
    }

    /**
     * 修改用户ip注册次数
     *
     * @param userIpRegister 用户ip注册次数
     * @return 结果
     */
    @Override
    public int updateUserIpRegister(UserIpRegister userIpRegister) {
        if (userIpRegister.getIsDisable() == DISABLE) {
            HashUser hashUser = new HashUser();
            hashUser.setRegisterIp(userIpRegister.getIp());
            List<HashUser> hashUsers = hashUserMapper.selectHashUserList(hashUser);
            List<String> ids = new ArrayList<>();
            for (HashUser user : hashUsers) {
                ids.add(user.getId());
            }
            userRedis.delUserToken(ids);
        }
        return userIpRegisterMapper.updateUserIpRegister(userIpRegister);
    }

    /**
     * 批量删除用户ip注册次数
     *
     * @param ips 需要删除的用户ip注册次数主键
     * @return 结果
     */
    @Override
    public int deleteUserIpRegisterByIps(String[] ips) {
        return userIpRegisterMapper.deleteUserIpRegisterByIps(ips);
    }

    /**
     * 删除用户ip注册次数信息
     *
     * @param ip 用户ip注册次数主键
     * @return 结果
     */
    @Override
    public int deleteUserIpRegisterByIp(String ip) {
        return userIpRegisterMapper.deleteUserIpRegisterByIp(ip);
    }
}
