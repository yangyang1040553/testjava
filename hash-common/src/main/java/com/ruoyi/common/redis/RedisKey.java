package com.ruoyi.common.redis;

/**
 * redisKey
 */
public class RedisKey {

    //=====================1用户相关key=====================
    //用户登录频繁限制
    public final static String user_login_limit = "user_login_limit:";
    //用户的token
    public final static String user_token = "user_token:";
    //用户公告表
    public final static String user_notice = "user_notice:";
    //用户活动表
    public final static String user_activity = "user_activity:";
    //用户对象缓存
    public final static String user_object = "user_object:";
    //用户注册临时对象
    public final static String user_reg_temp = "user_reg_temp:";
    //用户发送的短信
    public final static String user_sms = "user_sms:";
    //用户全局配置
    public final static String user_global_config = "user_global_config:";


    //=====================1用户相关key=====================


    //=====================2游戏相关key=====================
    //游戏配置
    public final static String game_config = "game_config:";

    //玩家订单id
    public final static String game_player_bet_order = "game_player_bet_order:";

    //=====================2游戏相关key=====================

}
