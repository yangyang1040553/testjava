package com.ruoyi.operation.service;

import java.util.List;
import com.ruoyi.operation.domain.GameOperationActivity;

/**
 * 运营活动Service接口
 * 
 * @author xxk
 * @date 2022-06-26
 */
public interface IGameOperationActivityService 
{
    /**
     * 查询运营活动
     * 
     * @param id 运营活动主键
     * @return 运营活动
     */
    public GameOperationActivity selectGameOperationActivityById(Long id);

    /**
     * 查询运营活动列表
     * 
     * @param gameOperationActivity 运营活动
     * @return 运营活动集合
     */
    public List<GameOperationActivity> selectGameOperationActivityList(GameOperationActivity gameOperationActivity);

    /**
     * 新增运营活动
     * 
     * @param gameOperationActivity 运营活动
     * @return 结果
     */
    public int insertGameOperationActivity(GameOperationActivity gameOperationActivity);

    /**
     * 修改运营活动
     * 
     * @param gameOperationActivity 运营活动
     * @return 结果
     */
    public int updateGameOperationActivity(GameOperationActivity gameOperationActivity);

    /**
     * 批量删除运营活动
     * 
     * @param ids 需要删除的运营活动主键集合
     * @return 结果
     */
    public int deleteGameOperationActivityByIds(Long[] ids);

    /**
     * 删除运营活动信息
     * 
     * @param id 运营活动主键
     * @return 结果
     */
    public int deleteGameOperationActivityById(Long id);
}
