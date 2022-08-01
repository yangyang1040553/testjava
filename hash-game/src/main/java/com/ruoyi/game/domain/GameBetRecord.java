package com.ruoyi.game.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏投注记录对象 t_game_bet_record
 *
 * @author xxk
 * @date 2022-05-12
 */
public class GameBetRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    private String id;

    /**
     * 游戏配置id
     */
    @Excel(name = "游戏配置id")
    private String configId;

    /**
     * 游戏id
     */
    @Excel(name = "游戏id")
    private Long gameId;

    /**
     * 场次id
     */
    @Excel(name = "场次id")
    private Long sessionId;

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
     * 赔率
     */
    @Excel(name = "赔率")
    private Double odds;

    /**
     * 投注的钱包类型USTD TRX
     */
    @Excel(name = "投注的钱包类型USTD TRX")
    private String betWalletType;

    /**
     * 投注金额
     */
    @Excel(name = "投注金额")
    private Double betAmount;

    /**
     * 投注位置
     */
    @Excel(name = "投注位置")
    private String betPosition;

    /**
     * 中奖金额或退回金额
     */
    @Excel(name = "中奖金额或退回金额")
    private Double awardAmount;

    /**
     * 到账金额
     */
    @Excel(name = "到账金额")
    private Double incomeAmount;

    @Excel(name = "输赢金额")
    private Double winAmount;

    /**
     * 手续费
     */
    @Excel(name = "手续费")
    private Double taxAmount;

    /**
     * hash值
     */
    @Excel(name = "hash值")
    private String hashValue;

    /**
     * 下注结果 1未中奖 2中奖 3和局 4退回
     */
    @Excel(name = "下注结果 1未中奖 2中奖 3和局 4退回")
    private Long betResult;

    /**
     * 到账结果 0：无状态 1：奖金已到账 2：奖金未到账
     */
    @Excel(name = "到账结果 0：无状态 1：奖金已到账 2：奖金未到账")
    private Long rewardStatus;

    /**
     * 赢家 1庄家赢 2玩家赢 3和局
     */
    @Excel(name = "赢家 1庄家赢 2玩家赢 3和局")
    private Long winner;

    /**
     * 本局游戏汇总
     */
    @Excel(name = "本局游戏汇总")
    private String gameCollect;


    @Excel(name = "奖金回调状态")
    private String awardCallback;

    @Excel(name = "说明")
    private String note;


    @Excel(name = "邀请码")
    private String invitation_code;

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public Double getWinAmount() {
        return Global.getWalletAmountToReal(winAmount);
    }

    public void setWinAmount(Double winAmount) {
        this.winAmount = winAmount;
    }

    public String getAwardCallback() {
        return awardCallback;
    }

    public void setAwardCallback(String awardCallback) {
        this.awardCallback = awardCallback;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String sort;
    private String prop;

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = Global.getWalletAmountToReal(incomeAmount);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getConfigId() {
        return configId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSessionId() {
        return sessionId;
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

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Double getOdds() {
        return odds;
    }

    public void setBetWalletType(String betWalletType) {
        this.betWalletType = betWalletType;
    }

    public String getBetWalletType() {
        return betWalletType;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = Global.getWalletAmountToReal(betAmount);
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetPosition(String betPosition) {
        this.betPosition = betPosition;
    }

    public String getBetPosition() {
        return betPosition;
    }

    public void setAwardAmount(Double awardAmount) {
        this.awardAmount = Global.getWalletAmountToReal(awardAmount);
    }

    public Double getAwardAmount() {
        return awardAmount;
    }

    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = Global.getWalletAmountToReal(taxAmount);
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setBetResult(Long betResult) {
        this.betResult = betResult;
    }

    public Long getBetResult() {
        return betResult;
    }

    public void setRewardStatus(Long rewardStatus) {
        this.rewardStatus = rewardStatus;
    }

    public Long getRewardStatus() {
        return rewardStatus;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }

    public Long getWinner() {
        return winner;
    }

    public void setGameCollect(String gameCollect) {
        this.gameCollect = gameCollect;
    }

    public String getGameCollect() {
        return gameCollect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("configId", getConfigId())
                .append("gameId", getGameId())
                .append("sessionId", getSessionId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("odds", getOdds())
                .append("betWalletType", getBetWalletType())
                .append("betAmount", getBetAmount())
                .append("betPosition", getBetPosition())
                .append("awardAmount", getAwardAmount())
                .append("taxAmount", getTaxAmount())
                .append("hashValue", getHashValue())
                .append("betResult", getBetResult())
                .append("rewardStatus", getRewardStatus())
                .append("winner", getWinner())
                .append("gameCollect", getGameCollect())
                .append("createTime", getCreateTime())
                .append("finishTime", getFinishTime())
                .toString();
    }
}
