package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏输赢对象 t_game_statistical_win
 * 
 * @author xxk
 * @date 2022-08-13
 */
public class GameStatisticalWin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id-天为单位 */
    @Excel(name = "时间")
    private String id;

    /** 今日usdt押注金额 */
    @Excel(name = "今日usdt押注金额")
    private Double usdtBetAmount;

    /** 今日usdt中奖金额 */
    @Excel(name = "今日usdt中奖金额")
    private Double usdtAwardAmount;

    /** 今日usdt输赢金额 */
    @Excel(name = "今日usdt输赢金额")
    private Double usdtWinAmount;

    /** 今日trx押注金额 */
    @Excel(name = "今日trx押注金额")
    private Double trxBetAmount;

    /** 今日trx中奖金额 */
    @Excel(name = "今日trx中奖金额")
    private Double trxAwardAmount;

    /** 今日trx输赢金额 */
    @Excel(name = "今日trx输赢金额")
    private Double trxWinAmount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

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

    public Double getUsdtWinAmount() {
        return Global.getWalletAmountToReal(usdtWinAmount);
    }

    public void setUsdtWinAmount(Double usdtWinAmount) {
        this.usdtWinAmount = usdtWinAmount;
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

    public Double getTrxWinAmount() {
        return Global.getWalletAmountToReal(trxWinAmount);
    }

    public void setTrxWinAmount(Double trxWinAmount) {
        this.trxWinAmount = trxWinAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usdtBetAmount", getUsdtBetAmount())
            .append("usdtAwardAmount", getUsdtAwardAmount())
            .append("usdtWinAmount", getUsdtWinAmount())
            .append("trxBetAmount", getTrxBetAmount())
            .append("trxAwardAmount", getTrxAwardAmount())
            .append("trxWinAmount", getTrxWinAmount())
            .toString();
    }
}
