package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.GameStatisticalWin;

/**
 * 游戏输赢Service接口
 * 
 * @author xxk
 * @date 2022-08-13
 */
public interface IGameStatisticalWinService 
{
    /**
     * 查询游戏输赢
     * 
     * @param id 游戏输赢主键
     * @return 游戏输赢
     */
    public GameStatisticalWin selectGameStatisticalWinById(String id);

    /**
     * 查询游戏输赢列表
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 游戏输赢集合
     */
    public List<GameStatisticalWin> selectGameStatisticalWinList(GameStatisticalWin gameStatisticalWin);

    /**
     * 新增游戏输赢
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 结果
     */
    public int insertGameStatisticalWin(GameStatisticalWin gameStatisticalWin);

    /**
     * 修改游戏输赢
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 结果
     */
    public int updateGameStatisticalWin(GameStatisticalWin gameStatisticalWin);

    /**
     * 批量删除游戏输赢
     * 
     * @param ids 需要删除的游戏输赢主键集合
     * @return 结果
     */
    public int deleteGameStatisticalWinByIds(String[] ids);

    /**
     * 删除游戏输赢信息
     * 
     * @param id 游戏输赢主键
     * @return 结果
     */
    public int deleteGameStatisticalWinById(String id);
}
