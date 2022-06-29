package com.ruoyi.operation.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运营活动奖励记录对象 t_game_operation_activity_record
 * 
 * @author xxk
 * @date 2022-06-27
 */
public class GameOperationActivityRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 玩家昵称 */
    @Excel(name = "玩家昵称")
    private String nickName;

    /** 钱包类型 */
    @Excel(name = "钱包类型")
    private String walletType;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private Long amount;

    /** 活动类型 */
    @Excel(name = "活动类型")
    private Long aType;

    /** 是否发放0未发放 1已发放 */
    @Excel(name = "是否发放0未发放 1已发放")
    private Long status;

    @Excel(name = "说明")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setWalletType(String walletType) 
    {
        this.walletType = walletType;
    }

    public String getWalletType() 
    {
        return walletType;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Double getAmount()
    {
        return Global.getWalletAmountToReal(amount);
    }
    public void setaType(Long aType) 
    {
        this.aType = aType;
    }

    public Long getaType() 
    {
        return aType;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("walletType", getWalletType())
            .append("amount", getAmount())
            .append("aType", getaType())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
