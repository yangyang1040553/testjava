package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GameStatisticalPlayerWinMapper;
import com.ruoyi.statistical.domain.GameStatisticalPlayerWin;
import com.ruoyi.statistical.service.IGameStatisticalPlayerWinService;

/**
 * 玩家输赢Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-01
 */
@Service
public class GameStatisticalPlayerWinServiceImpl implements IGameStatisticalPlayerWinService 
{
    @Autowired
    private GameStatisticalPlayerWinMapper gameStatisticalPlayerWinMapper;

    /**
     * 查询玩家输赢
     * 
     * @param id 玩家输赢主键
     * @return 玩家输赢
     */
    @Override
    public GameStatisticalPlayerWin selectGameStatisticalPlayerWinById(String id)
    {
        return gameStatisticalPlayerWinMapper.selectGameStatisticalPlayerWinById(id);
    }

    /**
     * 查询玩家输赢列表
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 玩家输赢
     */
    @Override
    public List<GameStatisticalPlayerWin> selectGameStatisticalPlayerWinList(GameStatisticalPlayerWin gameStatisticalPlayerWin)
    {
        return gameStatisticalPlayerWinMapper.selectGameStatisticalPlayerWinList(gameStatisticalPlayerWin);
    }

    /**
     * 新增玩家输赢
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 结果
     */
    @Override
    public int insertGameStatisticalPlayerWin(GameStatisticalPlayerWin gameStatisticalPlayerWin)
    {
        return gameStatisticalPlayerWinMapper.insertGameStatisticalPlayerWin(gameStatisticalPlayerWin);
    }

    /**
     * 修改玩家输赢
     * 
     * @param gameStatisticalPlayerWin 玩家输赢
     * @return 结果
     */
    @Override
    public int updateGameStatisticalPlayerWin(GameStatisticalPlayerWin gameStatisticalPlayerWin)
    {
        return gameStatisticalPlayerWinMapper.updateGameStatisticalPlayerWin(gameStatisticalPlayerWin);
    }

    /**
     * 批量删除玩家输赢
     * 
     * @param ids 需要删除的玩家输赢主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPlayerWinByIds(String[] ids)
    {
        return gameStatisticalPlayerWinMapper.deleteGameStatisticalPlayerWinByIds(ids);
    }

    /**
     * 删除玩家输赢信息
     * 
     * @param id 玩家输赢主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPlayerWinById(String id)
    {
        return gameStatisticalPlayerWinMapper.deleteGameStatisticalPlayerWinById(id);
    }
}
