package com.ruoyi.wallet.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 钱包流水记录对象 t_wallet_turnover
 *
 * @author xxk
 * @date 2022-06-06
 */
public class WalletTurnover extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @Excel(name = "唯一id")
    private String id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String userId;

    /**
     * 流水类型 1:下注 2:中奖 3:退回 4:佣金提现 5:充值 6:提现 7:转换 8:后台入款 9:后台扣款
     */
    @Excel(name = "流水类型 1:下注 2:中奖 3:退回 4:佣金提现 5:充值 6:提现 7:转换 8:后台入款 9:后台扣款")
    private Long code;

    /**
     * 钱包类型 USDT TRX
     */
    @Excel(name = "钱包类型 USDT TRX")
    private String walletType;

    /**
     * 流水金额
     */
    @Excel(name = "流水金额")
    private Long amount;

    /**
     * 当前金额
     */
    @Excel(name = "当前金额")
    private Long currentAmount;

    /**
     * 之后金额
     */
    @Excel(name = "之后金额")
    private Long afterAmount;

    /**
     * 关联订单
     */
    @Excel(name = "关联订单")
    private String linkedOrder;

    /**
     * 玩家邀请码
     */
    @Excel(name = "玩家邀请码")
    private String invitationCode;

    @Excel(name = "昵称")
    private String nickName;

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

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return Global.getWalletAmountToReal(amount);
    }

    public void setCurrentAmount(Long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getCurrentAmount() {
         return Global.getWalletAmountToReal(currentAmount);
    }

    public void setAfterAmount(Long afterAmount) {
        this.afterAmount = afterAmount;
    }

    public Double getAfterAmount() {
        return Global.getWalletAmountToReal(afterAmount);
    }

    public void setLinkedOrder(String linkedOrder) {
        this.linkedOrder = linkedOrder;
    }

    public String getLinkedOrder() {
        return linkedOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("code", getCode())
                .append("walletType", getWalletType())
                .append("amount", getAmount())
                .append("currentAmount", getCurrentAmount())
                .append("afterAmount", getAfterAmount())
                .append("linkedOrder", getLinkedOrder())
                .append("createTime", getCreateTime())
                .toString();
    }
}
