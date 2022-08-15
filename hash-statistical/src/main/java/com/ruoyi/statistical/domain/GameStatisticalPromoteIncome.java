package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理每日收益金额对象 t_game_statistical_promote_income
 *
 * @author xxk
 * @date 2022-06-05
 */
public class GameStatisticalPromoteIncome extends BaseEntity {
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
     * 邀请码
     */
    @Excel(name = "邀请码")
    private String invitationCode;

    /**
     * usdt收益金额
     */
    @Excel(name = "usdt收益金额")
    private Double usdtIncomeAmount;

    /**
     * trx收益金额
     */
    @Excel(name = "trx收益金额")
    private Double trxIncomeAmount;

    private Double usdt_income1_amount;
    private Double usdt_income2_amount;
    private Double usdt_income3_amount;
    private Double trx_income1_amount;
    private Double trx_income2_amount;
    private Double trx_income3_amount;

    public Double getUsdt_income1_amount() {
        return Global.getWalletAmountToReal(usdt_income1_amount);
    }

    public void setUsdt_income1_amount(Double usdt_income1_amount) {
        this.usdt_income1_amount = usdt_income1_amount;
    }

    public Double getUsdt_income2_amount() {
        return Global.getWalletAmountToReal(usdt_income2_amount);
    }

    public void setUsdt_income2_amount(Double usdt_income2_amount) {
        this.usdt_income2_amount = usdt_income2_amount;
    }

    public Double getUsdt_income3_amount() {
        return Global.getWalletAmountToReal(usdt_income3_amount);
    }

    public void setUsdt_income3_amount(Double usdt_income3_amount) {
        this.usdt_income3_amount = usdt_income3_amount;
    }

    public Double getTrx_income1_amount() {
        return Global.getWalletAmountToReal(trx_income1_amount);
    }

    public void setTrx_income1_amount(Double trx_income1_amount) {
        this.trx_income1_amount = trx_income1_amount;
    }

    public Double getTrx_income2_amount() {
        return Global.getWalletAmountToReal(trx_income2_amount);
    }

    public void setTrx_income2_amount(Double trx_income2_amount) {
        this.trx_income2_amount = trx_income2_amount;
    }

    public Double getTrx_income3_amount() {
        return Global.getWalletAmountToReal(trx_income3_amount);
    }

    public void setTrx_income3_amount(Double trx_income3_amount) {
        this.trx_income3_amount = trx_income3_amount;
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

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setUsdtIncomeAmount(Double usdtIncomeAmount) {
        this.usdtIncomeAmount = usdtIncomeAmount;
    }

    public Double getUsdtIncomeAmount() {
        return Global.getWalletAmountToReal(usdtIncomeAmount);
    }

    public void setTrxIncomeAmount(Double trxIncomeAmount) {
        this.trxIncomeAmount = trxIncomeAmount;
    }

    public Double getTrxIncomeAmount() {
        return Global.getWalletAmountToReal(trxIncomeAmount);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("invitationCode", getInvitationCode())
                .append("usdtIncomeAmount", getUsdtIncomeAmount())
                .append("trxIncomeAmount", getTrxIncomeAmount())
                .toString();
    }
}
