package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.GamePoolChange;

/**
 * 游戏奖金池变化Service接口
 * 
 * @author xxk
 * @date 2022-08-04
 */
public interface IGamePoolChangeService 
{
    /**
     * 查询游戏奖金池变化
     * 
     * @param id 游戏奖金池变化主键
     * @return 游戏奖金池变化
     */
    public GamePoolChange selectGamePoolChangeById(Long id);

    /**
     * 查询游戏奖金池变化列表
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 游戏奖金池变化集合
     */
    public List<GamePoolChange> selectGamePoolChangeList(GamePoolChange gamePoolChange);

    /**
     * 新增游戏奖金池变化
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 结果
     */
    public int insertGamePoolChange(GamePoolChange gamePoolChange);

    /**
     * 修改游戏奖金池变化
     * 
     * @param gamePoolChange 游戏奖金池变化
     * @return 结果
     */
    public int updateGamePoolChange(GamePoolChange gamePoolChange);

    /**
     * 批量删除游戏奖金池变化
     * 
     * @param ids 需要删除的游戏奖金池变化主键集合
     * @return 结果
     */
    public int deleteGamePoolChangeByIds(Long[] ids);

    /**
     * 删除游戏奖金池变化信息
     * 
     * @param id 游戏奖金池变化主键
     * @return 结果
     */
    public int deleteGamePoolChangeById(Long id);
}
