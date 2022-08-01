package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏玩家押注位置日统计对象 t_game_statistical_position_player_day
 *
 * @author xxk
 * @date 2022-05-27
 */
public class GameStatisticalPositionPlayerDay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id-天为单位
     */
    @Excel(name = "id-天为单位")
    private String id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String userId;

    /**
     * 游戏id
     */
    @Excel(name = "游戏id")
    private Long gameId;

    /**
     * 押注位置
     */
    @Excel(name = "押注位置")
    private String betPosition;

    /**
     * 今天usdt总押注金额
     */
    @Excel(name = "今天usdt总押注金额")
    private Double usdtBetAmount;

    /**
     * 今天usdt总中奖金额
     */
    @Excel(name = "今天usdt总中奖金额")
    private Double usdtAwardAmount;

    /**
     * 今日trx押注金额
     */
    @Excel(name = "今日trx押注金额")
    private Double trxBetAmount;

    /**
     * 今日trx中奖金额
     */
    @Excel(name = "今日trx中奖金额")
    private Double trxAwardAmount;

    /**
     * 日周月  1、2、3
     */
    @Excel(name = "统计类型")
    private Integer type;


    private String sql;

    private String week;



    /**
     * 统计
     */
    @Excel(name = "统计时间", width = 30)
    private String time;

    @Excel(name = "USDT输赢金额")
    private Double usdtWin;

    @Excel(name = "TRX输赢金额")
    private Double trxWin;

    @Excel(name = "邀请码")
    private String invitation_code;

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public Double getUsdtWin() {
        return Global.getWalletAmountToReal(usdtWin);
    }

    public void setUsdtWin(Double usdtWin) {
        this.usdtWin = usdtWin;
    }

    public Double getTrxWin() {
        return Global.getWalletAmountToReal(trxWin);
    }

    public void setTrxWin(Double trxWin) {
        this.trxWin = trxWin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setBetPosition(String betPosition) {
        this.betPosition = betPosition;
    }

    public String getBetPosition() {
        return betPosition;
    }

    public void setUsdtBetAmount(Double usdtBetAmount) {
        this.usdtBetAmount = usdtBetAmount;
    }

    public Double getUsdtBetAmount() {
        return Global.getWalletAmountToReal(usdtBetAmount);
    }

    public void setUsdtAwardAmount(Double usdtAwardAmount) {
        this.usdtAwardAmount = usdtAwardAmount;
    }

    public Double getUsdtAwardAmount() {
        return Global.getWalletAmountToReal(usdtAwardAmount);
    }

    public void setTrxBetAmount(Double trxBetAmount) {
        this.trxBetAmount = trxBetAmount;
    }

    public Double getTrxBetAmount() {
        return Global.getWalletAmountToReal(trxBetAmount);
    }

    public void setTrxAwardAmount(Double trxAwardAmount) {
        this.trxAwardAmount = trxAwardAmount;
    }

    public Double getTrxAwardAmount() {
        return Global.getWalletAmountToReal(trxAwardAmount);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("gameId", getGameId())
                .append("betPosition", getBetPosition())
                .append("usdtBetAmount", getUsdtBetAmount())
                .append("usdtAwardAmount", getUsdtAwardAmount())
                .append("trxBetAmount", getTrxBetAmount())
                .append("trxAwardAmount", getTrxAwardAmount())
                .toString();
    }
}
