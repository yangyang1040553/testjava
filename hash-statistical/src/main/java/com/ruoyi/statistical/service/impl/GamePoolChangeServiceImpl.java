package com.ruoyi.statistical.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GamePoolChangeMapper;
import com.ruoyi.statistical.domain.GamePoolChange;
import com.ruoyi.statistical.service.IGamePoolChangeService;

/**
 * 游戏奖金池变化Service业务层处理
 * 
 * @author xxk
 * @date 2022-08-04
 */
@Service
public class GamePoolChangeServiceImpl implements IGamePoolChangeService 
{
    @Autowired
    private GamePoolChangeMapper gamePoolChangeMapper;

    /**
     * 查询游戏奖金池变化
     * 
     * @param id 游戏奖金池变化主键
     * @return 游戏奖金池变化
     */
    @Override
    public GamePoolChange selectGamePoolChangeById(Long id)
    {
        return gamePoolChangeMapper.selectGamePoolChangeById(id);
    }

    /**
     * 查询游戏奖金池变化列表
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 游戏奖金池变化
     */
    @Override
    public List<GamePoolChange> selectGamePoolChangeList(GamePoolChange gamePoolChange)
    {
        return gamePoolChangeMapper.selectGamePoolChangeList(gamePoolChange);
    }

    /**
     * 新增游戏奖金池变化
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 结果
     */
    @Override
    public int insertGamePoolChange(GamePoolChange gamePoolChange)
    {
        gamePoolChange.setCreateTime(DateUtils.getNowDate());
        return gamePoolChangeMapper.insertGamePoolChange(gamePoolChange);
    }

    /**
     * 修改游戏奖金池变化
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 结果
     */
    @Override
    public int updateGamePoolChange(GamePoolChange gamePoolChange)
    {
        return gamePoolChangeMapper.updateGamePoolChange(gamePoolChange);
    }

    /**
     * 批量删除游戏奖金池变化
     * 
     * @param ids 需要删除的游戏奖金池变化主键
     * @return 结果
     */
    @Override
    public int deleteGamePoolChangeByIds(Long[] ids)
    {
        return gamePoolChangeMapper.deleteGamePoolChangeByIds(ids);
    }

    /**
     * 删除游戏奖金池变化信息
     * 
     * @param id 游戏奖金池变化主键
     * @return 结果
     */
    @Override
    public int deleteGamePoolChangeById(Long id)
    {
        return gamePoolChangeMapper.deleteGamePoolChangeById(id);
    }
}
