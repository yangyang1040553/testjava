package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 钱包日支付统计对象 t_wallet_statistical_pay
 *
 * @author xxk
 * @date 2022-06-24
 */
public class WalletStatisticalPay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id-天为单位2022-02-01
     */
    @Excel(name = "id-天为")
    private String id;

    /**
     * 今日usdt充值金额
     */
    @Excel(name = "今日usdt充值金额")
    private Double usdtAmountRecharge;

    /**
     * 今日trx充值金额
     */
    @Excel(name = "今日trx充值金额")
    private Double trxAmountRecharge;

    /**
     * 今日usdt提现金额
     */
    @Excel(name = "今日usdt提现金额")
    private Double usdtAmountWithdraw;

    /**
     * 今日trx提现金额
     */
    @Excel(name = "今日trx提现金额")
    private Double trxAmountWithdraw;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsdtAmountRecharge(Double usdtAmountRecharge) {
        this.usdtAmountRecharge = usdtAmountRecharge;
    }

    public Double getUsdtAmountRecharge() {
        return Global.getWalletAmountToReal(usdtAmountRecharge);
    }

    public void setTrxAmountRecharge(Double trxAmountRecharge) {
        this.trxAmountRecharge = trxAmountRecharge;
    }

    public Double getTrxAmountRecharge() {
        return Global.getWalletAmountToReal(trxAmountRecharge);
    }

    public void setUsdtAmountWithdraw(Double usdtAmountWithdraw) {
        this.usdtAmountWithdraw = usdtAmountWithdraw;
    }

    public Double getUsdtAmountWithdraw() {
        return Global.getWalletAmountToReal(usdtAmountWithdraw);
    }

    public void setTrxAmountWithdraw(Double trxAmountWithdraw) {
        this.trxAmountWithdraw = trxAmountWithdraw;
    }

    public Double getTrxAmountWithdraw() {
        return Global.getWalletAmountToReal(trxAmountWithdraw);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("usdtAmountRecharge", getUsdtAmountRecharge())
                .append("trxAmountRecharge", getTrxAmountRecharge())
                .append("usdtAmountWithdraw", getUsdtAmountWithdraw())
                .append("trxAmountWithdraw", getTrxAmountWithdraw())
                .toString();
    }
}
