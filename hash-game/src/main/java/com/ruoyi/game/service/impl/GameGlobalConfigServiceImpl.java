package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameGlobalConfigMapper;
import com.ruoyi.game.domain.GameGlobalConfig;
import com.ruoyi.game.service.IGameGlobalConfigService;

/**
 * 游戏共用配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-24
 */
@Service
public class GameGlobalConfigServiceImpl implements IGameGlobalConfigService 
{
    @Autowired
    private GameGlobalConfigMapper gameGlobalConfigMapper;

    /**
     * 查询游戏共用配置
     * 
     * @param id 游戏共用配置主键
     * @return 游戏共用配置
     */
    @Override
    public GameGlobalConfig selectGameGlobalConfigById(String id)
    {
        return gameGlobalConfigMapper.selectGameGlobalConfigById(id);
    }

    /**
     * 查询游戏共用配置列表
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 游戏共用配置
     */
    @Override
    public List<GameGlobalConfig> selectGameGlobalConfigList(GameGlobalConfig gameGlobalConfig)
    {
        return gameGlobalConfigMapper.selectGameGlobalConfigList(gameGlobalConfig);
    }

    /**
     * 新增游戏共用配置
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 结果
     */
    @Override
    public int insertGameGlobalConfig(GameGlobalConfig gameGlobalConfig)
    {
        gameGlobalConfig.setCreateTime(DateUtils.getNowDate());
        return gameGlobalConfigMapper.insertGameGlobalConfig(gameGlobalConfig);
    }

    /**
     * 修改游戏共用配置
     * 
     * @param gameGlobalConfig 游戏共用配置
     * @return 结果
     */
    @Override
    public int updateGameGlobalConfig(GameGlobalConfig gameGlobalConfig)
    {
        gameGlobalConfig.setUpdateTime(DateUtils.getNowDate());
        return gameGlobalConfigMapper.updateGameGlobalConfig(gameGlobalConfig);
    }

    /**
     * 批量删除游戏共用配置
     * 
     * @param ids 需要删除的游戏共用配置主键
     * @return 结果
     */
    @Override
    public int deleteGameGlobalConfigByIds(String[] ids)
    {
        return gameGlobalConfigMapper.deleteGameGlobalConfigByIds(ids);
    }

    /**
     * 删除游戏共用配置信息
     * 
     * @param id 游戏共用配置主键
     * @return 结果
     */
    @Override
    public int deleteGameGlobalConfigById(String id)
    {
        return gameGlobalConfigMapper.deleteGameGlobalConfigById(id);
    }
}
