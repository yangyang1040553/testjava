package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUser;

/**
 * 用户Mapper接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface HashUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public HashUser selectHashUserById(String id);


    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public HashUser selectHashUserDetail(String id);


    /**
     * 查询用户列表
     * 
     * @param hashUser 用户
     * @return 用户集合
     */
    public List<HashUser> selectHashUserList(HashUser hashUser);


    public List<HashUser> selectHashUserListByIds(String ids);

    /**
     * 新增用户
     * 
     * @param hashUser 用户
     * @return 结果
     */
    public int insertHashUser(HashUser hashUser);

    /**
     * 修改用户
     * 
     * @param hashUser 用户
     * @return 结果
     */
    public int updateHashUser(HashUser hashUser);

    /**
     * 删除用户
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteHashUserById(String id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHashUserByIds(String[] ids);
}
