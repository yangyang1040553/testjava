package com.ruoyi.wallet.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人工出入款对象 t_wallet_artificial_opt
 *
 * @author xxk
 * @date 2022-07-10
 */
public class WalletArtificialOpt extends BaseEntity {
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
     * 玩家昵称
     */
    @Excel(name = "玩家昵称")
    private String nickName;

    /**
     * 钱包类型
     */
    @Excel(name = "钱包类型")
    private String walletType;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private Double amount;

    /**
     * 是否成功 0否 1是
     */
    @Excel(name = "是否成功 0否 1是")
    private Long isCallback;

    /**
     * 操作人
     */
    @Excel(name = "操作人")
    private String optPerson;

    /**
     * 备注说明
     */
    @Excel(name = "备注说明")
    private String note;

    @Excel(name = "出入款类型 1入款 2出款")
    private String opt_type;

    @Excel(name = "邀请码")
    private String invitation_code;

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public String getOpt_type() {
        return opt_type;
    }

    public void setOpt_type(String opt_type) {
        this.opt_type = opt_type;
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

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return Global.getWalletAmountToReal(amount);
    }

    public void setIsCallback(Long isCallback) {
        this.isCallback = isCallback;
    }

    public Long getIsCallback() {
        return isCallback;
    }

    public void setOptPerson(String optPerson) {
        this.optPerson = optPerson;
    }

    public String getOptPerson() {
        return optPerson;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("walletType", getWalletType())
                .append("amount", getAmount())
                .append("isCallback", getIsCallback())
                .append("optPerson", getOptPerson())
                .append("note", getNote())
                .append("createTime", getCreateTime())
                .toString();
    }
}
