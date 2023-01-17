package com.ruoyi.hashUser.redis;

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
     * 设置版本更新时间
     */
    public void setVersionTime() {
        redisCache.setCacheMapValue(RedisKey.common_config_update, "2", System.currentTimeMillis());
    }

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

    public void setUserObject(String userID, String item, String value) {
        String key = RedisKey.user_object + userID;
        if (redisCache.hasKey(RedisKey.user_object + userID)) {
            redisCache.setCacheMapValue(RedisKey.user_object + userID, item, value);
        }
    }


    public void delUserObject(String userID) {
        String key = RedisKey.user_object + userID;
        redisCache.deleteObject(key);
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

    /***
     * 删除支付通道
     */
    public void delPayChannels() {
        redisCache.deleteObject(RedisKey.wallet_pay_channels);
    }

    /**
     * 删除Banner缓存
     */
    public void delUserBanner() {
        redisCache.deleteObject(RedisKey.user_banner_config);
    }


    /***
     * 设置用户客户端日志时间
     * @param userId
     * @param time
     */
    public void setUserClientLog(String userId, long time) {
        redisCache.setCacheObject(RedisKey.common_client_log + userId, String.valueOf(time));
    }


    /***
     * 删除广告缓存
     */
    public void delUserAdvertise() {
        redisCache.deleteObject(RedisKey.user_advertise);
    }

}
