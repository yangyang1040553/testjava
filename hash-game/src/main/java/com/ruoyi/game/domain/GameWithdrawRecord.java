package com.ruoyi.game.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 佣金提现记录对象 t_game_withdraw_record
 *
 * @author xxk
 * @date 2022-05-19
 */
public class GameWithdrawRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Excel(name = "id")
    private String id;

    /**
     * 玩家id
     */
    @Excel(name = "玩家id")
    private String userId;

    /**
     * 提现金额
     */
    @Excel(name = "提现金额")
    private Double withdrawAmount;

    /**
     * 钱包类型
     */
    @Excel(name = "钱包类型")
    private String walletType;

    /**
     * 提现后剩余金额
     */
    @Excel(name = "提现后剩余金额")
    private Double afterAmount;


    @Excel(name = "提现后剩余金额")
    private String nickName;



    /**
     * 提现状态 1成功 2转入钱包异常
     */
    @Excel(name = "提现状态 1成功 2转入钱包异常")
    private Long status;



    @Excel(name = "邀请码")
    private String invitation_code;

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = Global.getWalletAmountToReal(withdrawAmount);
    }

    public Double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setAfterAmount(Long afterAmount) {
        this.afterAmount = Global.getWalletAmountToReal(afterAmount);
    }

    public Double getAfterAmount() {
        return afterAmount;
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
                .append("userId", getUserId())
                .append("withdrawAmount", getWithdrawAmount())
                .append("walletType", getWalletType())
                .append("afterAmount", getAfterAmount())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}
