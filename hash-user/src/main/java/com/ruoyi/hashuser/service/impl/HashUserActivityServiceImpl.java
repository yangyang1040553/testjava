package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.HashUserActivityMapper;
import com.ruoyi.hashuser.domain.HashUserActivity;
import com.ruoyi.hashuser.service.IHashUserActivityService;

/**
 * 用户的活动Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-11
 */
@Service
public class HashUserActivityServiceImpl implements IHashUserActivityService 
{
    @Autowired
    private HashUserActivityMapper hashUserActivityMapper;

    /**
     * 查询用户的活动
     * 
     * @param id 用户的活动主键
     * @return 用户的活动
     */
    @Override
    public HashUserActivity selectHashUserActivityById(Long id)
    {
        return hashUserActivityMapper.selectHashUserActivityById(id);
    }

    /**
     * 查询用户的活动列表
     * 
     * @param hashUserActivity 用户的活动
     * @return 用户的活动
     */
    @Override
    public List<HashUserActivity> selectHashUserActivityList(HashUserActivity hashUserActivity)
    {
        return hashUserActivityMapper.selectHashUserActivityList(hashUserActivity);
    }

    /**
     * 新增用户的活动
     * 
     * @param hashUserActivity 用户的活动
     * @return 结果
     */
    @Override
    public int insertHashUserActivity(HashUserActivity hashUserActivity)
    {
        hashUserActivity.setCreateTime(DateUtils.getNowDate());
        return hashUserActivityMapper.insertHashUserActivity(hashUserActivity);
    }

    /**
     * 修改用户的活动
     * 
     * @param hashUserActivity 用户的活动
     * @return 结果
     */
    @Override
    public int updateHashUserActivity(HashUserActivity hashUserActivity)
    {
        hashUserActivity.setUpdateTime(DateUtils.getNowDate());
        return hashUserActivityMapper.updateHashUserActivity(hashUserActivity);
    }

    /**
     * 批量删除用户的活动
     * 
     * @param ids 需要删除的用户的活动主键
     * @return 结果
     */
    @Override
    public int deleteHashUserActivityByIds(Long[] ids)
    {
        return hashUserActivityMapper.deleteHashUserActivityByIds(ids);
    }

    /**
     * 删除用户的活动信息
     * 
     * @param id 用户的活动主键
     * @return 结果
     */
    @Override
    public int deleteHashUserActivityById(Long id)
    {
        return hashUserActivityMapper.deleteHashUserActivityById(id);
    }
}
