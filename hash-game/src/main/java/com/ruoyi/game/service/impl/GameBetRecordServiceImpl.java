package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameBetRecordMapper;
import com.ruoyi.game.domain.GameBetRecord;
import com.ruoyi.game.service.IGameBetRecordService;

/**
 * 游戏投注记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-12
 */
@Service
public class GameBetRecordServiceImpl implements IGameBetRecordService 
{
    @Autowired
    private GameBetRecordMapper gameBetRecordMapper;

    /**
     * 查询游戏投注记录
     * 
     * @param id 游戏投注记录主键
     * @return 游戏投注记录
     */
    @Override
    public GameBetRecord selectGameBetRecordById(String id)
    {
        return gameBetRecordMapper.selectGameBetRecordById(id);
    }

    /**
     * 查询游戏投注记录列表
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 游戏投注记录
     */
    @Override
    public List<GameBetRecord> selectGameBetRecordList(GameBetRecord gameBetRecord)
    {
        return gameBetRecordMapper.selectGameBetRecordList(gameBetRecord);
    }

    /**
     * 新增游戏投注记录
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 结果
     */
    @Override
    public int insertGameBetRecord(GameBetRecord gameBetRecord)
    {
        gameBetRecord.setCreateTime(DateUtils.getNowDate());
        return gameBetRecordMapper.insertGameBetRecord(gameBetRecord);
    }

    /**
     * 修改游戏投注记录
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 结果
     */
    @Override
    public int updateGameBetRecord(GameBetRecord gameBetRecord)
    {
        return gameBetRecordMapper.updateGameBetRecord(gameBetRecord);
    }

    /**
     * 批量删除游戏投注记录
     * 
     * @param ids 需要删除的游戏投注记录主键
     * @return 结果
     */
    @Override
    public int deleteGameBetRecordByIds(String[] ids)
    {
        return gameBetRecordMapper.deleteGameBetRecordByIds(ids);
    }

    /**
     * 删除游戏投注记录信息
     * 
     * @param id 游戏投注记录主键
     * @return 结果
     */
    @Override
    public int deleteGameBetRecordById(String id)
    {
        return gameBetRecordMapper.deleteGameBetRecordById(id);
    }
}
