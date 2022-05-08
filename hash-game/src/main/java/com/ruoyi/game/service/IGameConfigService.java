package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GameConfig;

/**
 * 游戏配置
Service接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface IGameConfigService 
{
    /**
     * 查询游戏配置

     * 
     * @param id 游戏配置
主键
     * @return 游戏配置

     */
    public GameConfig selectGameConfigById(String id);

    /**
     * 查询游戏配置
列表
     * 
     * @param gameConfig 游戏配置

     * @return 游戏配置
集合
     */
    public List<GameConfig> selectGameConfigList(GameConfig gameConfig);

    /**
     * 新增游戏配置

     * 
     * @param gameConfig 游戏配置

     * @return 结果
     */
    public int insertGameConfig(GameConfig gameConfig);

    /**
     * 修改游戏配置

     * 
     * @param gameConfig 游戏配置

     * @return 结果
     */
    public int updateGameConfig(GameConfig gameConfig);

    /**
     * 批量删除游戏配置

     * 
     * @param ids 需要删除的游戏配置
主键集合
     * @return 结果
     */
    public int deleteGameConfigByIds(String[] ids);

    /**
     * 删除游戏配置
信息
     * 
     * @param id 游戏配置
主键
     * @return 结果
     */
    public int deleteGameConfigById(String id);
}
