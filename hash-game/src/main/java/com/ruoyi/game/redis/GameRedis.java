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
     * 删除游戏配置缓存
     * @param id
     */
    public void deleteGameConfig(String id) {
        redisCache.delCacheMapValue(RedisKey.game_config, id);
    }

    /***
     * 删除全部的配置缓存
     */
    public void deleteGameConfigList() {
        redisCache.deleteObject(RedisKey.game_config);
    }
}
