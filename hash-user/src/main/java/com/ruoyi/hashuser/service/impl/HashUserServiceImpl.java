package com.ruoyi.hashuser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.HashUserMapper;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.service.IHashUserService;

/**
 * 用户Service业务层处理
 *
 * @author xxk
 * @date 2022-05-08
 */
@Service
public class HashUserServiceImpl implements IHashUserService {
    @Autowired
    private HashUserMapper hashUserMapper;

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public HashUser selectHashUserById(String id) {
        return hashUserMapper.selectHashUserById(id);
    }

    @Override
    public HashUser selectHashUserDetail(String id) {
        return hashUserMapper.selectHashUserDetail(id);
    }

    /**
     * 查询用户列表
     *
     * @param hashUser 用户
     * @return 用户
     */
    @Override
    public List<HashUser> selectHashUserList(HashUser hashUser) {
        return hashUserMapper.selectHashUserList(hashUser);
    }

    /**
     * 新增用户
     *
     * @param hashUser 用户
     * @return 结果
     */
    @Override
    public int insertHashUser(HashUser hashUser) {
        return hashUserMapper.insertHashUser(hashUser);
    }

    /**
     * 修改用户
     *
     * @param hashUser 用户
     * @return 结果
     */
    @Override
    public int updateHashUser(HashUser hashUser) {
        return hashUserMapper.updateHashUser(hashUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteHashUserByIds(String[] ids) {
        return hashUserMapper.deleteHashUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteHashUserById(String id) {
        return hashUserMapper.deleteHashUserById(id);
    }
}
