package com.ruoyi.hashuser.redis;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRedis {

    @Autowired
    RedisCache redisCache;


    /***
     * 删除玩家token
     * 封禁和踢下线可以调用这个方法
     */
    public void delUserToken(String userId) {
        redisCache.deleteObject(RedisKey.user_token + userId);
//        redisCache.delCacheMapValue(RedisKey.user_token, userId);
    }

    public void delUserTokenAll() {
        redisCache.deleteObject(RedisKey.user_token + "*");
    }

    /***
     * 删除玩家token
     * 封禁和踢下线可以调用这个方法
     */
    public void delUserToken(List<String> userIdList) {
        List<String> dels = new ArrayList<>();
        for (String id : userIdList) {
            dels.add(RedisKey.user_token + id);
        }

        redisCache.deleteObject(dels);
//        redisCache.delCacheMapValue(RedisKey.user_token, userIdList);
    }

    /***
     * 删除全局配置缓存
     */
    public void delUserGlobalConfig() {
        redisCache.deleteObject(RedisKey.user_global_config);
    }


    /**
     * 删除公告缓存
     */
    public void delUserNotice() {
        redisCache.deleteObject(RedisKey.user_notice);
    }

    /**
     * 删除活动缓存
     */
    public void delUserActivity() {
        redisCache.deleteObject(RedisKey.user_activity);
    }

    /**
     * 删除Banner缓存
     */
    public void delUserBanner() {
        redisCache.deleteObject(RedisKey.user_banner_config);
    }

}
