package com.ruoyi.hashuser.redis;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRedis {

    @Autowired
    RedisCache redisCache;


    /***
     * 删除玩家token
     * 封禁和踢下线可以调用这个方法
     */
    public void delUserToken(String userId) {
        redisCache.delCacheMapValue(RedisKey.user_token, userId);
    }

    public void delUserGlobalConfig() {
        redisCache.deleteObject(RedisKey.user_global_config);
    }

}
