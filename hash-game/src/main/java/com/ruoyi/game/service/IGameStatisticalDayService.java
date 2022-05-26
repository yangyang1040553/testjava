package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GameStatisticalDay;

/**
 * 游戏日统计Service接口
 * 
 * @author xxk
 * @date 2022-05-26
 */
public interface IGameStatisticalDayService 
{
    /**
     * 查询游戏日统计
     * 
     * @param id 游戏日统计主键
     * @return 游戏日统计
     */
    public GameStatisticalDay selectGameStatisticalDayById(String id);

    /**
     * 查询游戏日统计列表
     * 
     * @param gameStatisticalDay 游戏日统计
     * @return 游戏日统计集合
     */
    public List<GameStatisticalDay> selectGameStatisticalDayList(GameStatisticalDay gameStatisticalDay);

    /**
     * 新增游戏日统计
     * 
     * @param gameStatisticalDay 游戏日统计
     * @return 结果
     */
    public int insertGameStatisticalDay(GameStatisticalDay gameStatisticalDay);

    /**
     * 修改游戏日统计
     * 
     * @param gameStatisticalDay 游戏日统计
     * @return 结果
     */
    public int updateGameStatisticalDay(GameStatisticalDay gameStatisticalDay);

    /**
     * 批量删除游戏日统计
     * 
     * @param ids 需要删除的游戏日统计主键集合
     * @return 结果
     */
    public int deleteGameStatisticalDayByIds(String[] ids);

    /**
     * 删除游戏日统计信息
     * 
     * @param id 游戏日统计主键
     * @return 结果
     */
    public int deleteGameStatisticalDayById(String id);
}
