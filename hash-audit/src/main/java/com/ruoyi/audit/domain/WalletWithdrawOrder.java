package com.ruoyi.audit.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现审核对象 t_wallet_withdraw_order
 *
 * @author xxk
 * @date 2022-06-02
 */
public class WalletWithdrawOrder extends BaseEntity {
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
     * 提现的金额
     */
    @Excel(name = "提现的金额")
    private Double amount;

    /**
     * 矿工费
     */
    @Excel(name = "矿工费")
    private Double minerAmount;

    /**
     * 状态  0：处理中 1：失败  2：拒绝  3：已完成
     */
    @Excel(name = "状态  0：处理中 1：失败  2：拒绝  3：已完成 ")
    private Long status;

    /**
     * 审核状态 0：待审核 1：审核中 2：审核拒绝3：审核完成
     */
    @Excel(name = "审核状态 0：待审核 1：审核中 2：审核拒绝3：审核完成")
    private String checkStatus;

    /**
     * 审核人
     */
    @Excel(name = "审核人")
    private String checkPerson;

    @Excel(name = "到账金额")
    private Double payAmount;
    @Excel(name = "说明")
    private String note;



    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        return amount;
    }

    public void setMinerAmount(Double minerAmount) {
        this.minerAmount = minerAmount;
    }

    public Double getMinerAmount() {
        return minerAmount;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getCheckPerson() {
        return checkPerson;
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
                .append("minerAmount", getMinerAmount())
                .append("status", getStatus())
                .append("checkStatus", getCheckStatus())
                .append("checkPerson", getCheckPerson())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
