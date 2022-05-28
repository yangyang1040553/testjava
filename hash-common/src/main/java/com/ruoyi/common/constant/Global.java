package com.ruoyi.common.constant;


import javax.servlet.http.HttpServletRequest;

/***
 * 全局配置
 */
public class Global {


    public static final int TYPE_DAY = 1;//日
    public static final int TYPE_WEEK = 2;//周
    public static final int TYPE_MONTH = 3;//月


    public static final int TYPE_SEVEN = 1;//七日
    public static final int TYPE_FIFTEEN = 2;//十五日
    public static final int TYPE_THIRTY = 3;//三十日

    public final static String USER_SECRET_KEY = "HASH-GAME_2022_18888888888888";


    /***
     * 获取玩家id
     */
    public static String getUserId(HttpServletRequest request) {
        final Object userId = request.getAttribute("userId");
        if (userId != null) {
            return userId.toString();
        }
        return null;
    }


    /***
     * 获取币种转换后的金额
     */
    public static long getWalletAmount(long amount) {
        return amount * 10000;
    }

    /**
     * 得到钱包余额的真实值
     *
     * @param amount
     * @return
     */
    public static Double getWalletAmountToReal(Long amount) {
        if (amount != null) {
            return amount * 1.0 / 10000;
        }
        return null;
    }

    /**
     * 得到钱包余额的真实值
     *
     * @param amount
     * @return
     */
    public static Double getWalletAmountToReal(Double amount) {
        if (amount != null) {
            return amount * 1.00 / 10000;
        }
        return null;
    }

    /**
     * 得到钱包余额的真实值
     *
     * @param amount
     * @return
     */
    public static String getWalletAmountStrToReal(long amount) {
        return String.valueOf(amount / 10000);
    }


}
