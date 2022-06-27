package com.ruoyi.operation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.GameOperationActivityRecordMapper;
import com.ruoyi.operation.domain.GameOperationActivityRecord;
import com.ruoyi.operation.service.IGameOperationActivityRecordService;

/**
 * 运营活动奖励记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-27
 */
@Service
public class GameOperationActivityRecordServiceImpl implements IGameOperationActivityRecordService 
{
    @Autowired
    private GameOperationActivityRecordMapper gameOperationActivityRecordMapper;

    /**
     * 查询运营活动奖励记录
     * 
     * @param id 运营活动奖励记录主键
     * @return 运营活动奖励记录
     */
    @Override
    public GameOperationActivityRecord selectGameOperationActivityRecordById(String id)
    {
        return gameOperationActivityRecordMapper.selectGameOperationActivityRecordById(id);
    }

    /**
     * 查询运营活动奖励记录列表
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 运营活动奖励记录
     */
    @Override
    public List<GameOperationActivityRecord> selectGameOperationActivityRecordList(GameOperationActivityRecord gameOperationActivityRecord)
    {
        return gameOperationActivityRecordMapper.selectGameOperationActivityRecordList(gameOperationActivityRecord);
    }

    /**
     * 新增运营活动奖励记录
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 结果
     */
    @Override
    public int insertGameOperationActivityRecord(GameOperationActivityRecord gameOperationActivityRecord)
    {
        gameOperationActivityRecord.setCreateTime(DateUtils.getNowDate());
        return gameOperationActivityRecordMapper.insertGameOperationActivityRecord(gameOperationActivityRecord);
    }

    /**
     * 修改运营活动奖励记录
     * 
     * @param gameOperationActivityRecord 运营活动奖励记录
     * @return 结果
     */
    @Override
    public int updateGameOperationActivityRecord(GameOperationActivityRecord gameOperationActivityRecord)
    {
        return gameOperationActivityRecordMapper.updateGameOperationActivityRecord(gameOperationActivityRecord);
    }

    /**
     * 批量删除运营活动奖励记录
     * 
     * @param ids 需要删除的运营活动奖励记录主键
     * @return 结果
     */
    @Override
    public int deleteGameOperationActivityRecordByIds(String[] ids)
    {
        return gameOperationActivityRecordMapper.deleteGameOperationActivityRecordByIds(ids);
    }

    /**
     * 删除运营活动奖励记录信息
     * 
     * @param id 运营活动奖励记录主键
     * @return 结果
     */
    @Override
    public int deleteGameOperationActivityRecordById(String id)
    {
        return gameOperationActivityRecordMapper.deleteGameOperationActivityRecordById(id);
    }
}
