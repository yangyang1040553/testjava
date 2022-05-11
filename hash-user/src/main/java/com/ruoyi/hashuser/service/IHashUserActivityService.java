package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserActivity;

/**
 * 用户的活动Service接口
 * 
 * @author xxk
 * @date 2022-05-11
 */
public interface IHashUserActivityService 
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
     * 批量删除用户的活动
     * 
     * @param ids 需要删除的用户的活动主键集合
     * @return 结果
     */
    public int deleteHashUserActivityByIds(Long[] ids);

    /**
     * 删除用户的活动信息
     * 
     * @param id 用户的活动主键
     * @return 结果
     */
    public int deleteHashUserActivityById(Long id);
}
