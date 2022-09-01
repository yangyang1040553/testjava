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
    private Double usdtBetAmount;

    /**
     * 今日usdt中奖金额
     */
    @Excel(name = "今日usdt中奖金额")
    private Double usdtAwardAmount;

    /**
     * 今日usdt输赢金额
     */
    @Excel(name = "今日usdt输赢金额")
    private Double usdtWinAmount;

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
     * 今日trx输赢金额
     */
    @Excel(name = "今日trx输赢金额")
    private Double trxWinAmount;

    private String note_name;

    @Excel(name = "昵称")
    private String nick_name;


    @Excel(name = "邀请码")
    private String invitation_code;

    @Excel(name = "今日usdt手续费")
    private Double usdt_tax_amount;

    @Excel(name = "今日usdt矿工费")
    private Double usdt_miner_fee;

    @Excel(name = "今日trx手续费")
    private Double trx_tax_amount;


    @Excel(name = "usdt今日活动奖励金")
    private Double usdt_activity_amount;
    @Excel(name = "usdt今日后台奖励金")
    private Double usdt_back_amount;
    @Excel(name = "trx今日活动奖励金")
    private Double trx_activity_amount;
    @Excel(name = "trx今日后台奖励金")
    private Double trx_back_amount;


    public Double getUsdt_activity_amount() {
        return Global.getWalletAmountToReal(usdt_activity_amount);
    }

    public void setUsdt_activity_amount(Double usdt_activity_amount) {
        this.usdt_activity_amount = usdt_activity_amount;
    }

    public Double getUsdt_back_amount() {
        return Global.getWalletAmountToReal(usdt_back_amount);
    }

    public void setUsdt_back_amount(Double usdt_back_amount) {
        this.usdt_back_amount = usdt_back_amount;
    }

    public Double getTrx_activity_amount() {
        return Global.getWalletAmountToReal(trx_activity_amount);
    }

    public void setTrx_activity_amount(Double trx_activity_amount) {
        this.trx_activity_amount = trx_activity_amount;
    }

    public Double getTrx_back_amount() {
        return Global.getWalletAmountToReal(trx_back_amount);
    }

    public void setTrx_back_amount(Double trx_back_amount) {
        this.trx_back_amount = trx_back_amount;
    }

    public Double getUsdt_tax_amount() {
        return Global.getWalletAmountToReal(usdt_tax_amount);
    }

    public void setUsdt_tax_amount(Double usdt_tax_amount) {
        this.usdt_tax_amount = usdt_tax_amount;
    }

    public Double getUsdt_miner_fee() {
        return Global.getWalletAmountToReal(usdt_miner_fee);
    }

    public void setUsdt_miner_fee(Double usdt_miner_fee) {
        this.usdt_miner_fee = usdt_miner_fee;
    }

    public Double getTrx_tax_amount() {
        return Global.getWalletAmountToReal(trx_tax_amount);
    }

    public void setTrx_tax_amount(Double trx_tax_amount) {
        this.trx_tax_amount = trx_tax_amount;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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

    public void setUsdtWinAmount(Double usdtWinAmount) {
        this.usdtWinAmount = usdtWinAmount;
    }

    public Double getUsdtWinAmount() {
        return Global.getWalletAmountToReal(usdtWinAmount);
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

    public void setTrxWinAmount(Double trxWinAmount) {
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
