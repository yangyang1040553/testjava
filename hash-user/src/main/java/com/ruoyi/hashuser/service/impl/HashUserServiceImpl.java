package com.ruoyi.hashuser.service.impl;

import java.util.List;

import com.ruoyi.hashuser.domain.UserPromote;
import com.ruoyi.hashuser.mapper.UserPromoteMapper;
import com.ruoyi.hashuser.redis.GameRedis;
import com.ruoyi.hashuser.redis.UserRedis;
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


    @Autowired
    private UserPromoteMapper userPromoteMapper;

    @Autowired
    private GameRedis gameRedis;

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public HashUser selectHashUserById(String id) {
        UserPromote userPromote = userPromoteMapper.selectUserlPromoteById(id);
        HashUser hashUser = hashUserMapper.selectHashUserById(id);
        HashUser detail = hashUserMapper.selectHashUserDetail(id);
        if (userPromote != null) {
            hashUser.setLevel1Person(userPromote.getLevel1Person());
            hashUser.setLevel2Person(userPromote.getLevel2Person());
            hashUser.setLevel3Person(userPromote.getLevel3Person());
            hashUser.setSumNumber(userPromote.getSumnumber());
        }
        if (detail != null) {
            if (detail.getBetAmount() != null) {
                hashUser.setBetAmount(detail.getBetAmount() * 10000);
            }
            if (detail.getInAmount() != null) {
                hashUser.setInAmount(detail.getInAmount() * 10000);
            }

            if (detail.getOutAmount() != null) {
                hashUser.setOutAmount(detail.getOutAmount() * 10000);
            }
        }


        //1 在线 0 不在线
        hashUser.setOnline(gameRedis.userIsOnline(hashUser.getId()) ? 1L : 0L);

        return hashUser;
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
