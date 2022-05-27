package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.GameStatisticalPositionPlayerDay;

/**
 * 游戏玩家押注位置日统计Service接口
 * 
 * @author xxk
 * @date 2022-05-27
 */
public interface IGameStatisticalPositionPlayerDayService 
{
    /**
     * 查询游戏玩家押注位置日统计
     * 
     * @param id 游戏玩家押注位置日统计主键
     * @return 游戏玩家押注位置日统计
     */
    public GameStatisticalPositionPlayerDay selectGameStatisticalPositionPlayerDayById(String id);

    /**
     * 查询游戏玩家押注位置日统计列表
     * 
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 游戏玩家押注位置日统计集合
     */
    public List<GameStatisticalPositionPlayerDay> selectGameStatisticalPositionPlayerDayList(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay);

    /**
     * 新增游戏玩家押注位置日统计
     * 
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 结果
     */
    public int insertGameStatisticalPositionPlayerDay(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay);

    /**
     * 修改游戏玩家押注位置日统计
     * 
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 结果
     */
    public int updateGameStatisticalPositionPlayerDay(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay);

    /**
     * 批量删除游戏玩家押注位置日统计
     * 
     * @param ids 需要删除的游戏玩家押注位置日统计主键集合
     * @return 结果
     */
    public int deleteGameStatisticalPositionPlayerDayByIds(String[] ids);

    /**
     * 删除游戏玩家押注位置日统计信息
     * 
     * @param id 游戏玩家押注位置日统计主键
     * @return 结果
     */
    public int deleteGameStatisticalPositionPlayerDayById(String id);
}
