package com.ruoyi.wallet.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值对象 t_wallet_recharge_order
 *
 * @author xxk
 * @date 2022-06-17
 */
public class WalletRechargeOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String id;

    /**
     * 交易号
     */
    @Excel(name = "交易号")
    private String transactionNo;

    /**
     * 玩家id
     */
    @Excel(name = "玩家id")
    private String userId;

    /**
     * 钱包类型USDT TRX
     */
    @Excel(name = "钱包类型USDT TRX")
    private String walletType;

    /**
     * 付款地址
     */
    @Excel(name = "付款地址")
    private String paymentAddress;

    /**
     * 收款地址
     */
    @Excel(name = "收款地址")
    private String collectionAddress;

    /**
     * 充值的金额
     */
    @Excel(name = "充值的金额")
    private Double amount;

    /**
     * 实际交易金额
     */
    @Excel(name = "实际交易金额")
    private Double payAmount;

    /**
     * 矿工费
     */
    @Excel(name = "矿工费")
    private Double minerAmount;

    /**
     * 充值状态
     */
    @Excel(name = "充值状态")
    private Long status;

    @Excel(name = "用户昵称")
    private String nickName;


    @Excel(name = "邀请码")
    private String invitationCode;

    @Excel(name = "说明")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setCollectionAddress(String collectionAddress) {
        this.collectionAddress = collectionAddress;
    }

    public String getCollectionAddress() {
        return collectionAddress;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return Global.getWalletAmountToReal(amount);
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getPayAmount() {
        return Global.getWalletAmountToReal(payAmount);
    }

    public void setMinerAmount(Double minerAmount) {
        this.minerAmount = minerAmount;
    }

    public Double getMinerAmount() {
        return Global.getWalletAmountToReal(minerAmount);
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("transactionNo", getTransactionNo())
                .append("userId", getUserId())
                .append("walletType", getWalletType())
                .append("paymentAddress", getPaymentAddress())
                .append("collectionAddress", getCollectionAddress())
                .append("amount", getAmount())
                .append("payAmount", getPayAmount())
                .append("minerAmount", getMinerAmount())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
