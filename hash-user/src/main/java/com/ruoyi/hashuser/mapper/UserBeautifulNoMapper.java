package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.UserBeautifulNo;

/**
 * 用户靓号申请Mapper接口
 * 
 * @author xxk
 * @date 2022-08-29
 */
public interface UserBeautifulNoMapper 
{
    /**
     * 查询用户靓号申请
     * 
     * @param id 用户靓号申请主键
     * @return 用户靓号申请
     */
    public UserBeautifulNo selectUserBeautifulNoById(String id);

    public List<UserBeautifulNo> selectUserBeautifulNoByCode(String code);

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
     * 删除用户靓号申请
     * 
     * @param id 用户靓号申请主键
     * @return 结果
     */
    public int deleteUserBeautifulNoById(String id);

    /**
     * 批量删除用户靓号申请
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserBeautifulNoByIds(String[] ids);
}
