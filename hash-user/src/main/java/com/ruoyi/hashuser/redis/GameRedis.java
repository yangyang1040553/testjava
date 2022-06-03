package com.ruoyi.hashuser.redis;


import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    /***
     * 删除游戏全局配置缓存
     */
    public void deleteGameGlobalConfig() {
        redisCache.deleteObject(RedisKey.game_global_config);
    }

    /***
     * 获取在线人数列表
     * @return
     */
    public List<String> getOnlineList() {
        final Set<String> cacheSet = redisCache.getCacheSet(RedisKey.game_player_online);
        return new ArrayList<>(cacheSet);
    }

    /***
     * 判断玩家是否在线
     * @param userId
     * @return
     */
    public boolean userIsOnline(String userId) {
        return redisCache.getCacheSetExist(RedisKey.game_player_online, userId);
    }
}
