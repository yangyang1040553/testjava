package com.ruoyi.game.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 游戏投注记录对象 t_game_bet_record
 * 
 * @author xxk
 * @date 2022-05-08
 */
public class GameBetRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 游戏id */
    @Excel(name = "游戏id")
    private Long gameId;

    /** 场次id */
    @Excel(name = "场次id")
    private Long sessionId;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 玩家昵称 */
    @Excel(name = "玩家昵称")
    private String nickName;

    /** 赔率 */
    @Excel(name = "赔率")
    private Long odds;

    /** 投注的钱包类型 */
    @Excel(name = "投注的钱包类型")
    private String betWalletType;

    /** 投注金额 */
    @Excel(name = "投注金额")
    private Long betAmount;

    /** 中奖金额或退回金额 */
    @Excel(name = "中奖金额或退回金额")
    private Long awardAmount;

    /** hash值 */
    @Excel(name = "hash值")
    private String hashValue;

    /** 下注结果 1未中奖 2中奖 3和局 4退回 */
    @Excel(name = "下注结果 1未中奖 2中奖 3和局 4退回")
    private Long betResult;

    /** 中奖结果 */
    @Excel(name = "中奖结果")
    private Long rewardStatus;


    /** 投注时间 */
    @Excel(name = "投注时间")
    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setGameId(Long gameId) 
    {
        this.gameId = gameId;
    }

    public Long getGameId() 
    {
        return gameId;
    }
    public void setSessionId(Long sessionId) 
    {
        this.sessionId = sessionId;
    }

    public Long getSessionId() 
    {
        return sessionId;
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
    public void setOdds(Long odds) 
    {
        this.odds = odds;
    }

    public Long getOdds() 
    {
        return odds;
    }
    public void setBetWalletType(String betWalletType) 
    {
        this.betWalletType = betWalletType;
    }

    public String getBetWalletType() 
    {
        return betWalletType;
    }
    public void setBetAmount(Long betAmount) 
    {
        this.betAmount = betAmount;
    }

    public Long getBetAmount() 
    {
        return betAmount;
    }
    public void setAwardAmount(Long awardAmount) 
    {
        this.awardAmount = awardAmount;
    }

    public Long getAwardAmount() 
    {
        return awardAmount;
    }
    public void setHashValue(String hashValue) 
    {
        this.hashValue = hashValue;
    }

    public String getHashValue() 
    {
        return hashValue;
    }
    public void setBetResult(Long betResult) 
    {
        this.betResult = betResult;
    }

    public Long getBetResult() 
    {
        return betResult;
    }
    public void setRewardStatus(Long rewardStatus) 
    {
        this.rewardStatus = rewardStatus;
    }

    public Long getRewardStatus() 
    {
        return rewardStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gameId", getGameId())
            .append("sessionId", getSessionId())
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("odds", getOdds())
            .append("betWalletType", getBetWalletType())
            .append("betAmount", getBetAmount())
            .append("awardAmount", getAwardAmount())
            .append("hashValue", getHashValue())
            .append("betResult", getBetResult())
            .append("rewardStatus", getRewardStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
