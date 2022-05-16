package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GamePlayerBrokerageRecordMapper;
import com.ruoyi.game.domain.GamePlayerBrokerageRecord;
import com.ruoyi.game.service.IGamePlayerBrokerageRecordService;

/**
 * 玩家返佣记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-16
 */
@Service
public class GamePlayerBrokerageRecordServiceImpl implements IGamePlayerBrokerageRecordService 
{
    @Autowired
    private GamePlayerBrokerageRecordMapper gamePlayerBrokerageRecordMapper;

    /**
     * 查询玩家返佣记录
     * 
     * @param id 玩家返佣记录主键
     * @return 玩家返佣记录
     */
    @Override
    public GamePlayerBrokerageRecord selectGamePlayerBrokerageRecordById(String id)
    {
        return gamePlayerBrokerageRecordMapper.selectGamePlayerBrokerageRecordById(id);
    }

    /**
     * 查询玩家返佣记录列表
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 玩家返佣记录
     */
    @Override
    public List<GamePlayerBrokerageRecord> selectGamePlayerBrokerageRecordList(GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        return gamePlayerBrokerageRecordMapper.selectGamePlayerBrokerageRecordList(gamePlayerBrokerageRecord);
    }

    /**
     * 新增玩家返佣记录
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 结果
     */
    @Override
    public int insertGamePlayerBrokerageRecord(GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        gamePlayerBrokerageRecord.setCreateTime(DateUtils.getNowDate());
        return gamePlayerBrokerageRecordMapper.insertGamePlayerBrokerageRecord(gamePlayerBrokerageRecord);
    }

    /**
     * 修改玩家返佣记录
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 结果
     */
    @Override
    public int updateGamePlayerBrokerageRecord(GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        return gamePlayerBrokerageRecordMapper.updateGamePlayerBrokerageRecord(gamePlayerBrokerageRecord);
    }

    /**
     * 批量删除玩家返佣记录
     * 
     * @param ids 需要删除的玩家返佣记录主键
     * @return 结果
     */
    @Override
    public int deleteGamePlayerBrokerageRecordByIds(String[] ids)
    {
        return gamePlayerBrokerageRecordMapper.deleteGamePlayerBrokerageRecordByIds(ids);
    }

    /**
     * 删除玩家返佣记录信息
     * 
     * @param id 玩家返佣记录主键
     * @return 结果
     */
    @Override
    public int deleteGamePlayerBrokerageRecordById(String id)
    {
        return gamePlayerBrokerageRecordMapper.deleteGamePlayerBrokerageRecordById(id);
    }
}
