package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.GamePoolChange;

/**
 * 游戏奖金池变化Mapper接口
 * 
 * @author xxk
 * @date 2022-08-04
 */
public interface GamePoolChangeMapper 
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
     * 删除游戏奖金池变化
     * 
     * @param id 游戏奖金池变化主键
     * @return 结果
     */
    public int deleteGamePoolChangeById(Long id);

    /**
     * 批量删除游戏奖金池变化
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGamePoolChangeByIds(Long[] ids);
}