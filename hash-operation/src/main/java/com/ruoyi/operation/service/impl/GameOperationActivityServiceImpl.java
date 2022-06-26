package com.ruoyi.operation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.GameOperationActivityMapper;
import com.ruoyi.operation.domain.GameOperationActivity;
import com.ruoyi.operation.service.IGameOperationActivityService;

/**
 * 运营活动Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-26
 */
@Service
public class GameOperationActivityServiceImpl implements IGameOperationActivityService 
{
    @Autowired
    private GameOperationActivityMapper gameOperationActivityMapper;

    /**
     * 查询运营活动
     * 
     * @param id 运营活动主键
     * @return 运营活动
     */
    @Override
    public GameOperationActivity selectGameOperationActivityById(Long id)
    {
        return gameOperationActivityMapper.selectGameOperationActivityById(id);
    }

    /**
     * 查询运营活动列表
     * 
     * @param gameOperationActivity 运营活动
     * @return 运营活动
     */
    @Override
    public List<GameOperationActivity> selectGameOperationActivityList(GameOperationActivity gameOperationActivity)
    {
        return gameOperationActivityMapper.selectGameOperationActivityList(gameOperationActivity);
    }

    /**
     * 新增运营活动
     * 
     * @param gameOperationActivity 运营活动
     * @return 结果
     */
    @Override
    public int insertGameOperationActivity(GameOperationActivity gameOperationActivity)
    {
        gameOperationActivity.setCreateTime(DateUtils.getNowDate());
        return gameOperationActivityMapper.insertGameOperationActivity(gameOperationActivity);
    }

    /**
     * 修改运营活动
     * 
     * @param gameOperationActivity 运营活动
     * @return 结果
     */
    @Override
    public int updateGameOperationActivity(GameOperationActivity gameOperationActivity)
    {
        gameOperationActivity.setUpdateTime(DateUtils.getNowDate());
        return gameOperationActivityMapper.updateGameOperationActivity(gameOperationActivity);
    }

    /**
     * 批量删除运营活动
     * 
     * @param ids 需要删除的运营活动主键
     * @return 结果
     */
    @Override
    public int deleteGameOperationActivityByIds(Long[] ids)
    {
        return gameOperationActivityMapper.deleteGameOperationActivityByIds(ids);
    }

    /**
     * 删除运营活动信息
     * 
     * @param id 运营活动主键
     * @return 结果
     */
    @Override
    public int deleteGameOperationActivityById(Long id)
    {
        return gameOperationActivityMapper.deleteGameOperationActivityById(id);
    }
}
