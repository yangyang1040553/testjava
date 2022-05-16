package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GamePlayerBrokerageRecord;

/**
 * 玩家返佣记录Service接口
 * 
 * @author xxk
 * @date 2022-05-16
 */
public interface IGamePlayerBrokerageRecordService 
{
    /**
     * 查询玩家返佣记录
     * 
     * @param id 玩家返佣记录主键
     * @return 玩家返佣记录
     */
    public GamePlayerBrokerageRecord selectGamePlayerBrokerageRecordById(String id);

    /**
     * 查询玩家返佣记录列表
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 玩家返佣记录集合
     */
    public List<GamePlayerBrokerageRecord> selectGamePlayerBrokerageRecordList(GamePlayerBrokerageRecord gamePlayerBrokerageRecord);

    /**
     * 新增玩家返佣记录
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 结果
     */
    public int insertGamePlayerBrokerageRecord(GamePlayerBrokerageRecord gamePlayerBrokerageRecord);

    /**
     * 修改玩家返佣记录
     * 
     * @param gamePlayerBrokerageRecord 玩家返佣记录
     * @return 结果
     */
    public int updateGamePlayerBrokerageRecord(GamePlayerBrokerageRecord gamePlayerBrokerageRecord);

    /**
     * 批量删除玩家返佣记录
     * 
     * @param ids 需要删除的玩家返佣记录主键集合
     * @return 结果
     */
    public int deleteGamePlayerBrokerageRecordByIds(String[] ids);

    /**
     * 删除玩家返佣记录信息
     * 
     * @param id 玩家返佣记录主键
     * @return 结果
     */
    public int deleteGamePlayerBrokerageRecordById(String id);
}
