package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.UserVersion;

/**
 * 版本更新Mapper接口
 * 
 * @author xxk
 * @date 2022-06-27
 */
public interface UserVersionMapper 
{
    /**
     * 查询版本更新
     * 
     * @param id 版本更新主键
     * @return 版本更新
     */
    public UserVersion selectUserVersionById(Long id);

    public UserVersion selectUserVersionByVersion(String version);

    /**
     * 查询版本更新列表
     * 
     * @param userVersion 版本更新
     * @return 版本更新集合
     */
    public List<UserVersion> selectUserVersionList(UserVersion userVersion);

    /**
     * 新增版本更新
     * 
     * @param userVersion 版本更新
     * @return 结果
     */
    public int insertUserVersion(UserVersion userVersion);

    /**
     * 修改版本更新
     * 
     * @param userVersion 版本更新
     * @return 结果
     */
    public int updateUserVersion(UserVersion userVersion);

    /**
     * 删除版本更新
     * 
     * @param id 版本更新主键
     * @return 结果
     */
    public int deleteUserVersionById(Long id);

    /**
     * 批量删除版本更新
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserVersionByIds(Long[] ids);
}
