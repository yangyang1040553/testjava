package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameWithdrawRecordMapper;
import com.ruoyi.game.domain.GameWithdrawRecord;
import com.ruoyi.game.service.IGameWithdrawRecordService;

/**
 * 佣金提现记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-19
 */
@Service
public class GameWithdrawRecordServiceImpl implements IGameWithdrawRecordService 
{
    @Autowired
    private GameWithdrawRecordMapper gameWithdrawRecordMapper;

    /**
     * 查询佣金提现记录
     * 
     * @param id 佣金提现记录主键
     * @return 佣金提现记录
     */
    @Override
    public GameWithdrawRecord selectGameWithdrawRecordById(String id)
    {
        return gameWithdrawRecordMapper.selectGameWithdrawRecordById(id);
    }

    /**
     * 查询佣金提现记录列表
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 佣金提现记录
     */
    @Override
    public List<GameWithdrawRecord> selectGameWithdrawRecordList(GameWithdrawRecord gameWithdrawRecord)
    {
        return gameWithdrawRecordMapper.selectGameWithdrawRecordList(gameWithdrawRecord);
    }

    /**
     * 新增佣金提现记录
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 结果
     */
    @Override
    public int insertGameWithdrawRecord(GameWithdrawRecord gameWithdrawRecord)
    {
        gameWithdrawRecord.setCreateTime(DateUtils.getNowDate());
        return gameWithdrawRecordMapper.insertGameWithdrawRecord(gameWithdrawRecord);
    }

    /**
     * 修改佣金提现记录
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 结果
     */
    @Override
    public int updateGameWithdrawRecord(GameWithdrawRecord gameWithdrawRecord)
    {
        return gameWithdrawRecordMapper.updateGameWithdrawRecord(gameWithdrawRecord);
    }

    /**
     * 批量删除佣金提现记录
     * 
     * @param ids 需要删除的佣金提现记录主键
     * @return 结果
     */
    @Override
    public int deleteGameWithdrawRecordByIds(String[] ids)
    {
        return gameWithdrawRecordMapper.deleteGameWithdrawRecordByIds(ids);
    }

    /**
     * 删除佣金提现记录信息
     * 
     * @param id 佣金提现记录主键
     * @return 结果
     */
    @Override
    public int deleteGameWithdrawRecordById(String id)
    {
        return gameWithdrawRecordMapper.deleteGameWithdrawRecordById(id);
    }
}
