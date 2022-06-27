package com.ruoyi.operation.service;

import java.util.List;
import com.ruoyi.operation.domain.GameOperationActivityRecord;

/**
 * 运营活动奖励记录Service接口
 * 
 * @author xxk
 * @date 2022-06-27
 */
public interface IGameOperationActivityRecordService 
{
    /**
     * 查询运营活动奖励记录
     * 
     * @param id 运营活动奖励记录主键
     * @return 运营活动奖励记录
     */
    public GameOperationActivityRecord selectGameOperationActivityRecordById(String id);

    /**
     * 查询运营活动奖励记录列表
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 运营活动奖励记录集合
     */
    public List<GameOperationActivityRecord> selectGameOperationActivityRecordList(GameOperationActivityRecord gameOperationActivityRecord);

    /**
     * 新增运营活动奖励记录
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 结果
     */
    public int insertGameOperationActivityRecord(GameOperationActivityRecord gameOperationActivityRecord);

    /**
     * 修改运营活动奖励记录
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 结果
     */
    public int updateGameOperationActivityRecord(GameOperationActivityRecord gameOperationActivityRecord);

    /**
     * 批量删除运营活动奖励记录
     * 
     * @param ids 需要删除的运营活动奖励记录主键集合
     * @return 结果
     */
    public int deleteGameOperationActivityRecordByIds(String[] ids);

    /**
     * 删除运营活动奖励记录信息
     * 
     * @param id 运营活动奖励记录主键
     * @return 结果
     */
    public int deleteGameOperationActivityRecordById(String id);
}
