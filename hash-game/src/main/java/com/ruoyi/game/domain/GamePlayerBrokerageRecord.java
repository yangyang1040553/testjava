package com.ruoyi.game.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 玩家返佣记录对象 t_game_player_brokerage_record
 * 
 * @author xxk
 * @date 2022-05-16
 */
public class GamePlayerBrokerageRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 玩家id（受益人） */
    @Excel(name = "玩家id", readConverterExp = "受=益人")
    private String userId;

    /** 第几级的佣金 */
    @Excel(name = "第几级的佣金")
    private Integer level;

    /** 钱包类型 */
    @Excel(name = "钱包类型")
    private String walletType;

    /** 下注金额 */
    @Excel(name = "下注金额")
    private Long betAmount;

    /** 反佣类型1游戏2代理 */
    @Excel(name = "反佣类型1游戏2代理")
    private Integer brokerageType;

    /** 反佣金额 */
    @Excel(name = "反佣金额")
    private Long brokerageAmount;

    /** 下级玩家id（产生收益者） */
    @Excel(name = "下级玩家id", readConverterExp = "产=生收益者")
    private String childUserId;

    /** 0成功 1:查询上级异常 */
    @Excel(name = "0成功 1:查询上级异常")
    private Integer status;

    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setWalletType(String walletType) 
    {
        this.walletType = walletType;
    }

    public String getWalletType() 
    {
        return walletType;
    }
    public void setBetAmount(Long betAmount) 
    {
        this.betAmount = betAmount;
    }

    public Long getBetAmount() 
    {
        return betAmount;
    }
    public void setBrokerageType(Integer brokerageType) 
    {
        this.brokerageType = brokerageType;
    }

    public Integer getBrokerageType() 
    {
        return brokerageType;
    }
    public void setBrokerageAmount(Long brokerageAmount) 
    {
        this.brokerageAmount = brokerageAmount;
    }

    public Long getBrokerageAmount() 
    {
        return brokerageAmount;
    }
    public void setChildUserId(String childUserId) 
    {
        this.childUserId = childUserId;
    }

    public String getChildUserId() 
    {
        return childUserId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("level", getLevel())
            .append("walletType", getWalletType())
            .append("betAmount", getBetAmount())
            .append("brokerageType", getBrokerageType())
            .append("brokerageAmount", getBrokerageAmount())
            .append("childUserId", getChildUserId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
