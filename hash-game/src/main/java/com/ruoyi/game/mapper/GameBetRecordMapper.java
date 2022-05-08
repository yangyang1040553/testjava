package com.ruoyi.game.mapper;

import java.util.List;
import com.ruoyi.game.domain.GameBetRecord;

/**
 * 游戏投注记录Mapper接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface GameBetRecordMapper 
{
    /**
     * 查询游戏投注记录
     * 
     * @param id 游戏投注记录主键
     * @return 游戏投注记录
     */
    public GameBetRecord selectGameBetRecordById(String id);

    /**
     * 查询游戏投注记录列表
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 游戏投注记录集合
     */
    public List<GameBetRecord> selectGameBetRecordList(GameBetRecord gameBetRecord);

    /**
     * 新增游戏投注记录
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 结果
     */
    public int insertGameBetRecord(GameBetRecord gameBetRecord);

    /**
     * 修改游戏投注记录
     * 
     * @param gameBetRecord 游戏投注记录
     * @return 结果
     */
    public int updateGameBetRecord(GameBetRecord gameBetRecord);

    /**
     * 删除游戏投注记录
     * 
     * @param id 游戏投注记录主键
     * @return 结果
     */
    public int deleteGameBetRecordById(String id);

    /**
     * 批量删除游戏投注记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameBetRecordByIds(String[] ids);
}
