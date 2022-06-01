package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.GameStatisticalPlayerWin;

/**
 * 玩家输赢Mapper接口
 * 
 * @author xxk
 * @date 2022-06-01
 */
public interface GameStatisticalPlayerWinMapper 
{
    /**
     * 查询玩家输赢
     * 
     * @param id 玩家输赢主键
     * @return 玩家输赢
     */
    public GameStatisticalPlayerWin selectGameStatisticalPlayerWinById(String id);

    /**
     * 查询玩家输赢列表
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 玩家输赢集合
     */
    public List<GameStatisticalPlayerWin> selectGameStatisticalPlayerWinList(GameStatisticalPlayerWin gameStatisticalPlayerWin);

    /**
     * 新增玩家输赢
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 结果
     */
    public int insertGameStatisticalPlayerWin(GameStatisticalPlayerWin gameStatisticalPlayerWin);

    /**
     * 修改玩家输赢
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 结果
     */
    public int updateGameStatisticalPlayerWin(GameStatisticalPlayerWin gameStatisticalPlayerWin);

    /**
     * 删除玩家输赢
     * 
     * @param id 玩家输赢主键
     * @return 结果
     */
    public int deleteGameStatisticalPlayerWinById(String id);

    /**
     * 批量删除玩家输赢
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameStatisticalPlayerWinByIds(String[] ids);
}
