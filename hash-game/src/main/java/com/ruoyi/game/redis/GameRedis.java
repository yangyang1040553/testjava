package com.ruoyi.game.redis;


import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRedis {

    @Autowired
    RedisCache redisCache;


    /***
     * 删除全部的配置缓存
     */
    public void deleteGameConfigList() {
        redisCache.deleteObject(RedisKey.game_config);
    }

    /***
     * 删除游戏菜单
     */
    public void deleteGameMenu() {
        redisCache.deleteObject(RedisKey.game_menu);
    }
}
