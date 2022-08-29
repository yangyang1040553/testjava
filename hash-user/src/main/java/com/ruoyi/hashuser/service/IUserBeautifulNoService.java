package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.UserBeautifulNo;

/**
 * 用户靓号申请Service接口
 * 
 * @author xxk
 * @date 2022-08-29
 */
public interface IUserBeautifulNoService 
{
    /**
     * 查询用户靓号申请
     * 
     * @param id 用户靓号申请主键
     * @return 用户靓号申请
     */
    public UserBeautifulNo selectUserBeautifulNoById(String id);

    /**
     * 查询用户靓号申请列表
     * 
     * @param userBeautifulNo 用户靓号申请
     * @return 用户靓号申请集合
     */
    public List<UserBeautifulNo> selectUserBeautifulNoList(UserBeautifulNo userBeautifulNo);

    /**
     * 新增用户靓号申请
     * 
     * @param userBeautifulNo 用户靓号申请
     * @return 结果
     */
    public int insertUserBeautifulNo(UserBeautifulNo userBeautifulNo);

    /**
     * 修改用户靓号申请
     * 
     * @param userBeautifulNo 用户靓号申请
     * @return 结果
     */
    public int updateUserBeautifulNo(UserBeautifulNo userBeautifulNo);

    /**
     * 批量删除用户靓号申请
     * 
     * @param ids 需要删除的用户靓号申请主键集合
     * @return 结果
     */
    public int deleteUserBeautifulNoByIds(String[] ids);

    /**
     * 删除用户靓号申请信息
     * 
     * @param id 用户靓号申请主键
     * @return 结果
     */
    public int deleteUserBeautifulNoById(String id);
}
