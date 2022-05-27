package com.ruoyi.game.mapper;

import java.util.List;

import com.ruoyi.game.domain.GameStatisticalPositionDay;

/**
 * 游戏押注位置日统计Mapper接口
 *
 * @author xxk
 * @date 2022-05-27
 */
public interface GameStatisticalPositionDayMapper {
    /**
     * 查询游戏押注位置日统计
     *
     * @param id 游戏押注位置日统计主键
     * @return 游戏押注位置日统计
     */
    public GameStatisticalPositionDay selectGameStatisticalPositionDayById(String id);

    /**
     * 查询游戏押注位置日统计列表
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 游戏押注位置日统计集合
     */
    public List<GameStatisticalPositionDay> selectGameStatisticalPositionDayList(GameStatisticalPositionDay gameStatisticalPositionDay);

    /**
     * 新增游戏押注位置日统计
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 结果
     */
    public int insertGameStatisticalPositionDay(GameStatisticalPositionDay gameStatisticalPositionDay);

    /**
     * 修改游戏押注位置日统计
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 结果
     */
    public int updateGameStatisticalPositionDay(GameStatisticalPositionDay gameStatisticalPositionDay);

    /**
     * 删除游戏押注位置日统计
     *
     * @param id 游戏押注位置日统计主键
     * @return 结果
     */
    public int deleteGameStatisticalPositionDayById(String id);

    /**
     * 批量删除游戏押注位置日统计
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameStatisticalPositionDayByIds(String[] ids);
}
