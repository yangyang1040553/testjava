package com.ruoyi.game.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.game.redis.GameRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameConfigMapper;
import com.ruoyi.game.domain.GameConfig;
import com.ruoyi.game.service.IGameConfigService;

/**
 * 游戏配置
 * Service业务层处理
 *
 * @author xxk
 * @date 2022-05-08
 */
@Service
public class GameConfigServiceImpl implements IGameConfigService {
    @Autowired
    private GameConfigMapper gameConfigMapper;


    @Autowired
    private GameRedis gameRedis;

    /**
     * 查询游戏配置
     *
     * @param id 游戏配置
     *           主键
     * @return 游戏配置
     */
    @Override
    public GameConfig selectGameConfigById(String id) {
        return gameConfigMapper.selectGameConfigById(id);
    }

    /**
     * 查询游戏配置
     * 列表
     *
     * @param gameConfig 游戏配置
     * @return 游戏配置
     */
    @Override
    public List<GameConfig> selectGameConfigList(GameConfig gameConfig) {
        return gameConfigMapper.selectGameConfigList(gameConfig);
    }

    /**
     * 新增游戏配置
     *
     * @param gameConfig 游戏配置
     * @return 结果
     */
    @Override
    public int insertGameConfig(GameConfig gameConfig) {
        gameConfig.setCreateTime(DateUtils.getNowDate());
        return gameConfigMapper.insertGameConfig(gameConfig);
    }

    /**
     * 修改游戏配置
     *
     * @param gameConfig 游戏配置
     * @return 结果
     */
    @Override
    public int updateGameConfig(GameConfig gameConfig) {
        gameConfig.setUpdateTime(DateUtils.getNowDate());
        int i = gameConfigMapper.updateGameConfig(gameConfig);
        if (i > 0) {
            gameRedis.deleteGameConfig(gameConfig.getId());
        }
        return i;
    }

    /**
     * 批量删除游戏配置
     *
     * @param ids 需要删除的游戏配置
     *            主键
     * @return 结果
     */
    @Override
    public int deleteGameConfigByIds(String[] ids) {
        int i = gameConfigMapper.deleteGameConfigByIds(ids);
        if (i>0){
            gameRedis.deleteGameConfigList();
        }
        return i;
    }

    /**
     * 删除游戏配置
     * 信息
     *
     * @param id 游戏配置
     *           主键
     * @return 结果
     */
    @Override
    public int deleteGameConfigById(String id) {
        int i = gameConfigMapper.deleteGameConfigById(id);
        if (i > 0) {
            gameRedis.deleteGameConfig(id);
        }
        return i;
    }
}
