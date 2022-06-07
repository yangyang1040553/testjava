package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 玩家输赢对象 t_game_statistical_player_win
 *
 * @author xxk
 * @date 2022-06-01
 */
public class GameStatisticalPlayerWin extends BaseEntity {
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
     * 今日usdt押注金额
     */
    @Excel(name = "今日usdt押注金额")
    private Long usdtBetAmount;

    /**
     * 今日usdt中奖金额
     */
    @Excel(name = "今日usdt中奖金额")
    private Long usdtAwardAmount;

    /**
     * 今日usdt输赢金额
     */
    @Excel(name = "今日usdt输赢金额")
    private Long usdtWinAmount;

    /**
     * 今日trx押注金额
     */
    @Excel(name = "今日trx押注金额")
    private Long trxBetAmount;

    /**
     * 今日trx中奖金额
     */
    @Excel(name = "今日trx中奖金额")
    private Long trxAwardAmount;

    /**
     * 今日trx输赢金额
     */
    @Excel(name = "今日trx输赢金额")
    private Long trxWinAmount;


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

    public void setUsdtBetAmount(Long usdtBetAmount) {
        this.usdtBetAmount = usdtBetAmount;
    }

    public Double getUsdtBetAmount() {
        return Global.getWalletAmountToReal(usdtBetAmount);
    }

    public void setUsdtAwardAmount(Long usdtAwardAmount) {
        this.usdtAwardAmount = usdtAwardAmount;
    }

    public Double getUsdtAwardAmount() {
        return Global.getWalletAmountToReal(usdtAwardAmount);
    }

    public void setUsdtWinAmount(Long usdtWinAmount) {
        this.usdtWinAmount = usdtWinAmount;
    }

    public Double getUsdtWinAmount() {
        return Global.getWalletAmountToReal(usdtWinAmount);
    }

    public void setTrxBetAmount(Long trxBetAmount) {
        this.trxBetAmount = trxBetAmount;
    }

    public Double getTrxBetAmount() {
        return Global.getWalletAmountToReal(trxBetAmount);
    }

    public void setTrxAwardAmount(Long trxAwardAmount) {
        this.trxAwardAmount = trxAwardAmount;
    }

    public Double getTrxAwardAmount() {
        return Global.getWalletAmountToReal(trxAwardAmount);
    }

    public void setTrxWinAmount(Long trxWinAmount) {
        this.trxWinAmount = trxWinAmount;
    }

    public Double getTrxWinAmount() {
        return Global.getWalletAmountToReal(trxWinAmount);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("usdtBetAmount", getUsdtBetAmount())
                .append("usdtAwardAmount", getUsdtAwardAmount())
                .append("usdtWinAmount", getUsdtWinAmount())
                .append("trxBetAmount", getTrxBetAmount())
                .append("trxAwardAmount", getTrxAwardAmount())
                .append("trxWinAmount", getTrxWinAmount())
                .toString();
    }
}