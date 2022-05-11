package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserActivity;

/**
 * 用户的活动Mapper接口
 * 
 * @author xxk
 * @date 2022-05-11
 */
public interface HashUserActivityMapper 
{
    /**
     * 查询用户的活动
     * 
     * @param id 用户的活动主键
     * @return 用户的活动
     */
    public HashUserActivity selectHashUserActivityById(Long id);

    /**
     * 查询用户的活动列表
     * 
     * @param hashUserActivity 用户的活动
     * @return 用户的活动集合
     */
    public List<HashUserActivity> selectHashUserActivityList(HashUserActivity hashUserActivity);

    /**
     * 新增用户的活动
     * 
     * @param hashUserActivity 用户的活动
     * @return 结果
     */
    public int insertHashUserActivity(HashUserActivity hashUserActivity);

    /**
     * 修改用户的活动
     * 
     * @param hashUserActivity 用户的活动
     * @return 结果
     */
    public int updateHashUserActivity(HashUserActivity hashUserActivity);

    /**
     * 删除用户的活动
     * 
     * @param id 用户的活动主键
     * @return 结果
     */
    public int deleteHashUserActivityById(Long id);

    /**
     * 批量删除用户的活动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHashUserActivityByIds(Long[] ids);
}
