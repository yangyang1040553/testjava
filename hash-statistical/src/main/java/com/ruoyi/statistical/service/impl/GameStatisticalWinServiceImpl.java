package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GameStatisticalWinMapper;
import com.ruoyi.statistical.domain.GameStatisticalWin;
import com.ruoyi.statistical.service.IGameStatisticalWinService;

/**
 * 游戏输赢Service业务层处理
 * 
 * @author xxk
 * @date 2022-08-13
 */
@Service
public class GameStatisticalWinServiceImpl implements IGameStatisticalWinService 
{
    @Autowired
    private GameStatisticalWinMapper gameStatisticalWinMapper;

    /**
     * 查询游戏输赢
     * 
     * @param id 游戏输赢主键
     * @return 游戏输赢
     */
    @Override
    public GameStatisticalWin selectGameStatisticalWinById(String id)
    {
        return gameStatisticalWinMapper.selectGameStatisticalWinById(id);
    }

    /**
     * 查询游戏输赢列表
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 游戏输赢
     */
    @Override
    public List<GameStatisticalWin> selectGameStatisticalWinList(GameStatisticalWin gameStatisticalWin)
    {
        return gameStatisticalWinMapper.selectGameStatisticalWinList(gameStatisticalWin);
    }

    /**
     * 新增游戏输赢
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 结果
     */
    @Override
    public int insertGameStatisticalWin(GameStatisticalWin gameStatisticalWin)
    {
        return gameStatisticalWinMapper.insertGameStatisticalWin(gameStatisticalWin);
    }

    /**
     * 修改游戏输赢
     * 
     * @param gameStatisticalWin 游戏输赢
     * @return 结果
     */
    @Override
    public int updateGameStatisticalWin(GameStatisticalWin gameStatisticalWin)
    {
        return gameStatisticalWinMapper.updateGameStatisticalWin(gameStatisticalWin);
    }

    /**
     * 批量删除游戏输赢
     * 
     * @param ids 需要删除的游戏输赢主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalWinByIds(String[] ids)
    {
        return gameStatisticalWinMapper.deleteGameStatisticalWinByIds(ids);
    }

    /**
     * 删除游戏输赢信息
     * 
     * @param id 游戏输赢主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalWinById(String id)
    {
        return gameStatisticalWinMapper.deleteGameStatisticalWinById(id);
    }
}
