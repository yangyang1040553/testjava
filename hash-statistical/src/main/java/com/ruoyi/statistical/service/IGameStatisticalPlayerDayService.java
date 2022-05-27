package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.GameStatisticalPlayerDay;

/**
 * 游戏玩家日统计Service接口
 * 
 * @author xxk
 * @date 2022-05-27
 */
public interface IGameStatisticalPlayerDayService 
{
    /**
     * 查询游戏玩家日统计
     * 
     * @param id 游戏玩家日统计主键
     * @return 游戏玩家日统计
     */
    public GameStatisticalPlayerDay selectGameStatisticalPlayerDayById(String id);

    /**
     * 查询游戏玩家日统计列表
     * 
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 游戏玩家日统计集合
     */
    public List<GameStatisticalPlayerDay> selectGameStatisticalPlayerDayList(GameStatisticalPlayerDay gameStatisticalPlayerDay);

    public List<GameStatisticalPlayerDay> selectDetailChildrenList(GameStatisticalPlayerDay gameStatisticalPlayerDay);

    /**
     * 新增游戏玩家日统计
     * 
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 结果
     */
    public int insertGameStatisticalPlayerDay(GameStatisticalPlayerDay gameStatisticalPlayerDay);

    /**
     * 修改游戏玩家日统计
     * 
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 结果
     */
    public int updateGameStatisticalPlayerDay(GameStatisticalPlayerDay gameStatisticalPlayerDay);

    /**
     * 批量删除游戏玩家日统计
     * 
     * @param ids 需要删除的游戏玩家日统计主键集合
     * @return 结果
     */
    public int deleteGameStatisticalPlayerDayByIds(String[] ids);

    /**
     * 删除游戏玩家日统计信息
     * 
     * @param id 游戏玩家日统计主键
     * @return 结果
     */
    public int deleteGameStatisticalPlayerDayById(String id);
}
