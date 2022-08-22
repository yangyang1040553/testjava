package com.ruoyi.game.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 哈希查询记录对象 t_game_select_hash
 * 
 * @author xxk
 * @date 2022-08-22
 */
public class GameSelectHash extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private Long id;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 玩家昵称 */
    @Excel(name = "玩家昵称")
    private String nickName;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String invitationCode;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderId;

    /** 哈希值 */
    @Excel(name = "哈希值")
    private String hashValue;

    /** 下注金额 */
    @Excel(name = "下注金额")
    private Double betAmount;

    /** 钱包类型 */
    @Excel(name = "钱包类型")
    private String walletType;

    /** 下注结果 */
    @Excel(name = "下注结果")
    private Long betResult;

    /** 游戏汇总 */
    @Excel(name = "游戏汇总")
    private String gameCollect;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
    public void setInvitationCode(String invitationCode) 
    {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() 
    {
        return invitationCode;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setHashValue(String hashValue) 
    {
        this.hashValue = hashValue;
    }

    public String getHashValue() 
    {
        return hashValue;
    }
    public void setBetAmount(Double betAmount)
    {
        this.betAmount = betAmount;
    }

    public Double getBetAmount()
    {
        return Global.getWalletAmountToReal(betAmount);
    }
    public void setWalletType(String walletType) 
    {
        this.walletType = walletType;
    }

    public String getWalletType() 
    {
        return walletType;
    }
    public void setBetResult(Long betResult) 
    {
        this.betResult = betResult;
    }

    public Long getBetResult() 
    {
        return betResult;
    }
    public void setGameCollect(String gameCollect) 
    {
        this.gameCollect = gameCollect;
    }

    public String getGameCollect() 
    {
        return gameCollect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("invitationCode", getInvitationCode())
            .append("orderId", getOrderId())
            .append("hashValue", getHashValue())
            .append("betAmount", getBetAmount())
            .append("walletType", getWalletType())
            .append("betResult", getBetResult())
            .append("gameCollect", getGameCollect())
            .append("createTime", getCreateTime())
            .toString();
    }
}
