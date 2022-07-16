package com.ruoyi.wallet.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户钱包对象 t_wallet_player_data
 *
 * @author xxk
 * @date 2022-05-08
 */
public class WalletPlayerData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id（玩家id）
     */
    private String id;

    /**
     * usdt余额
     */
    @Excel(name = "usdt余额")
    private Double usdtAmount;

    /**
     * trx余额
     */
    @Excel(name = "trx余额")
    private Double trxAmount;

    /**
     * Usdt的hash地址
     */
    @Excel(name = "Usdt的hash地址")
    private String hashAddressUsdt;

    /**
     * Trx的hash地址
     */
    @Excel(name = "Trx的hash地址")
    private String hashAddressTrx;

    /**
     * 总充值金额
     */
    @Excel(name = "TRX总充值金额")
    private Double trxRechargeTotal;
    @Excel(name = "USDT总充值金额")
    private Double usdtRechargeTotal;
    @Excel(name = "TRX总提现金额")
    private Double trxWithdrawTotal;
    @Excel(name = "TRX总提现金额")
    private Double usdtWithdrawTotal;
    @Excel(name = "昵称")
    private String nickName;
    @Excel(name = "邀请码")
    private String invitationCode;

    @Excel(name = "usdt远程余额")
    private Double usdtRemoteAmount;
    @Excel(name = "trx远程余额")
    private Double trxRemoteAmount;


    @Excel(name = "trc转换")
    private String hashTransAddressTrx;

    @Excel(name = "备注")
    private String note;


    private String note_name;

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHashTransAddressTrx() {
        return hashTransAddressTrx;
    }

    public void setHashTransAddressTrx(String hashTransAddressTrx) {
        this.hashTransAddressTrx = hashTransAddressTrx;
    }

    public Double getUsdtRemoteAmount() {
        return Global.getWalletAmountToReal(usdtRemoteAmount);
    }

    public void setUsdtRemoteAmount(Double usdtRemoteAmount) {
        this.usdtRemoteAmount = usdtRemoteAmount;
    }

    public Double getTrxRemoteAmount() {
        return Global.getWalletAmountToReal(trxRemoteAmount);
    }

    public void setTrxRemoteAmount(Double trxRemoteAmount) {
        this.trxRemoteAmount = trxRemoteAmount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getTrxRechargeTotal() {
        return Global.getWalletAmountToReal(trxRechargeTotal);
    }

    public void setTrxRechargeTotal(Double trxRechargeTotal) {
        this.trxRechargeTotal = trxRechargeTotal;
    }

    public Double getUsdtRechargeTotal() {
        return Global.getWalletAmountToReal(usdtRechargeTotal);
    }

    public void setUsdtRechargeTotal(Double usdtRechargeTotal) {
        this.usdtRechargeTotal = usdtRechargeTotal;
    }

    public Double getTrxWithdrawTotal() {
        return Global.getWalletAmountToReal(trxWithdrawTotal);
    }

    public void setTrxWithdrawTotal(Double trxWithdrawTotal) {
        this.trxWithdrawTotal = trxWithdrawTotal;
    }

    public Double getUsdtWithdrawTotal() {
        return Global.getWalletAmountToReal(usdtWithdrawTotal);
    }

    public void setUsdtWithdrawTotal(Double usdtWithdrawTotal) {
        this.usdtWithdrawTotal = usdtWithdrawTotal;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsdtAmount(Double usdtAmount) {
        this.usdtAmount = usdtAmount;
    }

    public Double getUsdtAmount() {
        return Global.getWalletAmountToReal(usdtAmount);
    }

    public void setTrxAmount(Double trxAmount) {
        this.trxAmount = trxAmount;
    }

    public Double getTrxAmount() {
        return Global.getWalletAmountToReal(trxAmount);
    }

    public void setHashAddressUsdt(String hashAddressUsdt) {
        this.hashAddressUsdt = hashAddressUsdt;
    }

    public String getHashAddressUsdt() {
        return hashAddressUsdt;
    }

    public void setHashAddressTrx(String hashAddressTrx) {
        this.hashAddressTrx = hashAddressTrx;
    }

    public String getHashAddressTrx() {
        return hashAddressTrx;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("usdtAmount", getUsdtAmount())
                .append("trxAmount", getTrxAmount())
                .append("hashAddressUsdt", getHashAddressUsdt())
                .append("hashAddressTrx", getHashAddressTrx())
                .append("usdtRechargeTotal", getUsdtRechargeTotal())
                .append("trxRechargeTotal", getTrxRechargeTotal())
                .append("usdtWithdrawTotal", getUsdtWithdrawTotal())
                .append("trxWithdrawTotal", getTrxWithdrawTotal())
                .toString();
    }
}
