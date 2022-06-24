package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GameGlobalConfig;

/**
 * 游戏共用配置Service接口
 * 
 * @author xxk
 * @date 2022-06-24
 */
public interface IGameGlobalConfigService 
{
    /**
     * 查询游戏共用配置
     * 
     * @param id 游戏共用配置主键
     * @return 游戏共用配置
     */
    public GameGlobalConfig selectGameGlobalConfigById(String id);

    /**
     * 查询游戏共用配置列表
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 游戏共用配置集合
     */
    public List<GameGlobalConfig> selectGameGlobalConfigList(GameGlobalConfig gameGlobalConfig);

    /**
     * 新增游戏共用配置
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 结果
     */
    public int insertGameGlobalConfig(GameGlobalConfig gameGlobalConfig);

    /**
     * 修改游戏共用配置
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 结果
     */
    public int updateGameGlobalConfig(GameGlobalConfig gameGlobalConfig);

    /**
     * 批量删除游戏共用配置
     * 
     * @param ids 需要删除的游戏共用配置主键集合
     * @return 结果
     */
    public int deleteGameGlobalConfigByIds(String[] ids);

    /**
     * 删除游戏共用配置信息
     * 
     * @param id 游戏共用配置主键
     * @return 结果
     */
    public int deleteGameGlobalConfigById(String id);
}
