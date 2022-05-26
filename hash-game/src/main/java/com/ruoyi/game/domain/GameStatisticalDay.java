package com.ruoyi.game.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 游戏日统计对象 t_game_statistical_day
 *
 * @author xxk
 * @date 2022-05-26
 */
public class GameStatisticalDay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id-天为单位2022-02-01
     */
    @Excel(name = "id-天为单位2022-02-01")
    private String id;

    /**
     * 游戏id
     */
    @Excel(name = "游戏id")
    private Long gameId;

    /**
     * 统计
     */
    @Excel(name = "统计时间", width = 30)
    private String time;


    /**
     * 游戏名称
     */
    @Excel(name = "游戏名称")
    private String gameName;


    /**
     * 日周月  1、2、3
     */
    @Excel(name = "统计类型")
    private Integer type;


    private String sql;


    @Excel(name = "usdt投注金额")
    private Double usdtBetAmount;
    @Excel(name = "usdt中奖金额")
    private Double usdtAwardAmount;
    @Excel(name = "trx投注金额类型")
    private Double trxBetAmount;
    @Excel(name = "trx中奖金额")
    private Double trxAwardAmount;


    public Double getUsdtBetAmount() {
        return Global.getWalletAmountToReal(usdtBetAmount);
    }

    public void setUsdtBetAmount(Double usdtBetAmount) {
        this.usdtBetAmount = usdtBetAmount;
    }

    public Double getUsdtAwardAmount() {
        return Global.getWalletAmountToReal(usdtAwardAmount);
    }

    public void setUsdtAwardAmount(Double usdtAwardAmount) {
        this.usdtAwardAmount = usdtAwardAmount;
    }

    public Double getTrxBetAmount() {
        return Global.getWalletAmountToReal(trxBetAmount);
    }

    public void setTrxBetAmount(Double trxBetAmount) {
        this.trxBetAmount = trxBetAmount;
    }

    public Double getTrxAwardAmount() {
        return Global.getWalletAmountToReal(trxAwardAmount);
    }

    public void setTrxAwardAmount(Double trxAwardAmount) {
        this.trxAwardAmount = trxAwardAmount;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("gameId", getGameId())
                .toString();
    }
}
