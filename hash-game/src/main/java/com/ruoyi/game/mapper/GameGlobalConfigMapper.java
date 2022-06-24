package com.ruoyi.game.mapper;

import java.util.List;
import com.ruoyi.game.domain.GameGlobalConfig;

/**
 * 游戏共用配置Mapper接口
 * 
 * @author xxk
 * @date 2022-06-24
 */
public interface GameGlobalConfigMapper 
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
     * 删除游戏共用配置
     * 
     * @param id 游戏共用配置主键
     * @return 结果
     */
    public int deleteGameGlobalConfigById(String id);

    /**
     * 批量删除游戏共用配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameGlobalConfigByIds(String[] ids);
}
