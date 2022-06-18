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
    private Long usdtAmount;

    /**
     * trx余额
     */
    @Excel(name = "trx余额")
    private Long trxAmount;

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
    private Long trxRechargeTotal;
    @Excel(name = "USDT总充值金额")
    private Long usdtRechargeTotal;
    @Excel(name = "TRX总提现金额")
    private Long trxWithdrawTotal;
    @Excel(name = "TRX总提现金额")
    private Long usdtWithdrawTotal;
    @Excel(name = "昵称")
    private String nickName;
    @Excel(name = "邀请码")
    private String invitationCode;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getTrxRechargeTotal() {
        return Global.getWalletAmountToReal(trxRechargeTotal);
    }

    public void setTrxRechargeTotal(Long trxRechargeTotal) {
        this.trxRechargeTotal = trxRechargeTotal;
    }

    public Double getUsdtRechargeTotal() {
        return Global.getWalletAmountToReal(usdtRechargeTotal);
    }

    public void setUsdtRechargeTotal(Long usdtRechargeTotal) {
        this.usdtRechargeTotal = usdtRechargeTotal;
    }

    public Double getTrxWithdrawTotal() {
        return Global.getWalletAmountToReal(trxWithdrawTotal);
    }

    public void setTrxWithdrawTotal(Long trxWithdrawTotal) {
        this.trxWithdrawTotal = trxWithdrawTotal;
    }

    public Double getUsdtWithdrawTotal() {
        return Global.getWalletAmountToReal(usdtWithdrawTotal);
    }

    public void setUsdtWithdrawTotal(Long usdtWithdrawTotal) {
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

    public void setUsdtAmount(Long usdtAmount) {
        this.usdtAmount = usdtAmount;
    }

    public Long getUsdtAmount() {
        return usdtAmount;
    }

    public void setTrxAmount(Long trxAmount) {
        this.trxAmount = trxAmount;
    }

    public Long getTrxAmount() {
        return trxAmount;
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
