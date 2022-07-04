package com.ruoyi.wallet.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 转换订单对象 t_wallet_transaction_order
 *
 * @author xxk
 * @date 2022-05-26
 */
public class WalletTransactionOrder extends BaseEntity {
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
     * 源钱包类型USDT TRX
     */
    @Excel(name = "源钱包类型USDT TRX")
    private String sourceWalletType;

    /**
     * 转入钱包类型USDT TRX
     */
    @Excel(name = "转入钱包类型USDT TRX")
    private String toWalletType;

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
     * 源金额
     */
    @Excel(name = "源金额")
    private Double sourceAmount;

    /**
     * 转入金额
     */
    @Excel(name = "转入金额")
    private Double toAmount;

    /**
     * 矿工费
     */
    @Excel(name = "矿工费")
    private Double minerAmount;

    /**
     * 转入状态
     */
    @Excel(name = "转入状态")
    private Long status;

    /**
     * 邀请码
     */
    @Excel(name = "邀请码")
    private String invitationCode;


    /**
     * 邀请码
     */
    @Excel(name = "昵称")
    private String nickName;


    @Excel(name = "说明")
    private String note;

    public String getNote() {
        return note;
    }


    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setSourceWalletType(String sourceWalletType) {
        this.sourceWalletType = sourceWalletType;
    }

    public String getSourceWalletType() {
        return sourceWalletType;
    }

    public void setToWalletType(String toWalletType) {
        this.toWalletType = toWalletType;
    }

    public String getToWalletType() {
        return toWalletType;
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

    public void setSourceAmount(Double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public Double getSourceAmount() {
        return Global.getWalletAmountToReal(sourceAmount);
    }

    public void setToAmount(Double toAmount) {
        this.toAmount = toAmount;
    }

    public Double getToAmount() {
        return Global.getWalletAmountToReal(toAmount);
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
                .append("sourceWalletType", getSourceWalletType())
                .append("toWalletType", getToWalletType())
                .append("paymentAddress", getPaymentAddress())
                .append("collectionAddress", getCollectionAddress())
                .append("sourceAmount", getSourceAmount())
                .append("toAmount", getToAmount())
                .append("minerAmount", getMinerAmount())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
