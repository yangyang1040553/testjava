package com.ruoyi.game.domain;

import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推广记录对象 t_game_player_promote
 *
 * @author xxk
 * @date 2022-05-19
 */
public class GamePlayerPromote extends BaseEntity implements Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * 玩家id
     */
    @Excel(name = "玩家id")
    private String id;

    /**
     * 玩家的邀请码
     */
    @Excel(name = "玩家的邀请码")
    private String invitationCode;

    /**
     * 上级玩家id
     */
    @Excel(name = "上级玩家id")
    private String fatherUserId;

    /**
     * 上级玩家的邀请码
     */
    @Excel(name = "上级玩家的邀请码")
    private String fatherInvitationCode;

    /**
     * usdt总收益
     */
    @Excel(name = "usdt总收益")
    private Double incomeUsdtAmount;

    /**
     * usdt今日收益
     */
    @Excel(name = "usdt今日收益")
    private Double incomeUsdtToday;

    /**
     * usdt昨日收益
     */
    @Excel(name = "usdt昨日收益")
    private Double incomeUsdtYesterday;

    /**
     * usdt直推收益
     */
    @Excel(name = "usdt直推收益")
    private Double incomeUsdtDirectPromote;

    /**
     * trx总收益
     */
    @Excel(name = "trx总收益")
    private Double incomeTrxAmount;

    /**
     * trx今日收益
     */
    @Excel(name = "trx今日收益")
    private Double incomeTrxToday;

    /**
     * trx昨日收益
     */
    @Excel(name = "trx昨日收益")
    private Double incomeTrxYesterday;

    /**
     * trx直推收益
     */
    @Excel(name = "trx直推收益")
    private Double incomeTrxDirectPromote;

    /**
     * 可提现的usdt金额
     */
    @Excel(name = "可提现的usdt金额")
    private Double canWithdrawUsdtAmount;

    /**
     * 可提现的trx金额
     */
    @Excel(name = "可提现的trx金额")
    private Double canWithdrawTrxAmount;

    /**
     * 一级代理人数
     */
    @Excel(name = "一级代理人数")
    private Long level1Person;

    /**
     * 二级代理人数
     */
    @Excel(name = "二级代理人数")
    private Long level2Person;

    /**
     * 三级代理人数
     */
    @Excel(name = "三级代理人数")
    private Long level3Person;

    /**
     * usdt对直接上级的游戏返佣贡献
     */
    @Excel(name = "usdt对直接上级的游戏返佣贡献")
    private Double usdtGameBrokerageToFather;

    /**
     * usdt对直接上级的代理返佣贡献
     */
    @Excel(name = "usdt对直接上级的代理返佣贡献")
    private Double usdtPromoteBrokerageToFather;

    /**
     * trx对直接上级的游戏返佣贡献
     */
    @Excel(name = "trx对直接上级的游戏返佣贡献")
    private Double trxGameBrokerageToFather;

    /**
     * trx对直接上级的代理返佣贡献
     */
    @Excel(name = "trx对直接上级的代理返佣贡献")
    private Double trxPromoteBrokerageToFather;

    public void setId(String id) {
        this.id = id;
    }


    @Excel(name = "邀请奖励人数")
    private String invite_award_person;
    @Excel(name = "团队usdt总输赢")
    private String team_usdt_win_amount;
    @Excel(name = "团队trx总输赢")
    private String team_trx_win_amount;


    public String getInvite_award_person() {
        return invite_award_person;
    }

    public void setInvite_award_person(String invite_award_person) {
        this.invite_award_person = invite_award_person;
    }

    public String getTeam_usdt_win_amount() {
        return team_usdt_win_amount;
    }

    public void setTeam_usdt_win_amount(String team_usdt_win_amount) {
        this.team_usdt_win_amount = team_usdt_win_amount;
    }

    public String getTeam_trx_win_amount() {
        return team_trx_win_amount;
    }

    public void setTeam_trx_win_amount(String team_trx_win_amount) {
        this.team_trx_win_amount = team_trx_win_amount;
    }

    public String getId() {
        return id;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setFatherUserId(String fatherUserId) {
        this.fatherUserId = fatherUserId;
    }

    public String getFatherUserId() {
        return fatherUserId;
    }

    public void setFatherInvitationCode(String fatherInvitationCode) {
        this.fatherInvitationCode = fatherInvitationCode;
    }

    public String getFatherInvitationCode() {
        return fatherInvitationCode;
    }

    public void setIncomeUsdtAmount(Double incomeUsdtAmount) {
        this.incomeUsdtAmount = Global.getWalletAmountToReal(incomeUsdtAmount);
    }

    public Double getIncomeUsdtAmount() {
        return incomeUsdtAmount;
    }

    public void setIncomeUsdtToday(Double incomeUsdtToday) {
        this.incomeUsdtToday = Global.getWalletAmountToReal(incomeUsdtToday);
    }

    public Double getIncomeUsdtToday() {
        return incomeUsdtToday;
    }

    public void setIncomeUsdtYesterday(Double incomeUsdtYesterday) {
        this.incomeUsdtYesterday = Global.getWalletAmountToReal(incomeUsdtYesterday);
    }

    public Double getIncomeUsdtYesterday() {
        return incomeUsdtYesterday;
    }

    public void setIncomeUsdtDirectPromote(Double incomeUsdtDirectPromote) {
        this.incomeUsdtDirectPromote = Global.getWalletAmountToReal(incomeUsdtDirectPromote);
    }

    public Double getIncomeUsdtDirectPromote() {
        return incomeUsdtDirectPromote;
    }

    public void setIncomeTrxAmount(Double incomeTrxAmount) {
        this.incomeTrxAmount = Global.getWalletAmountToReal(incomeTrxAmount);
    }

    public Double getIncomeTrxAmount() {
        return incomeTrxAmount;
    }

    public void setIncomeTrxToday(Double incomeTrxToday) {
        this.incomeTrxToday = Global.getWalletAmountToReal(incomeTrxToday);
    }

    public Double getIncomeTrxToday() {
        return incomeTrxToday;
    }

    public void setIncomeTrxYesterday(Double incomeTrxYesterday) {
        this.incomeTrxYesterday = Global.getWalletAmountToReal(incomeTrxYesterday);
    }

    public Double getIncomeTrxYesterday() {
        return incomeTrxYesterday;
    }

    public void setIncomeTrxDirectPromote(Double incomeTrxDirectPromote) {
        this.incomeTrxDirectPromote = Global.getWalletAmountToReal(incomeTrxDirectPromote);
    }

    public Double getIncomeTrxDirectPromote() {
        return incomeTrxDirectPromote;
    }

    public void setCanWithdrawUsdtAmount(Double canWithdrawUsdtAmount) {
        this.canWithdrawUsdtAmount = Global.getWalletAmountToReal(canWithdrawUsdtAmount);
    }

    public Double getCanWithdrawUsdtAmount() {
        return canWithdrawUsdtAmount;
    }

    public void setCanWithdrawTrxAmount(Double canWithdrawTrxAmount) {
        this.canWithdrawTrxAmount = Global.getWalletAmountToReal(canWithdrawTrxAmount);
    }

    public Double getCanWithdrawTrxAmount() {
        return canWithdrawTrxAmount;
    }

    public void setLevel1Person(Long level1Person) {
        this.level1Person = level1Person;
    }

    public Long getLevel1Person() {
        return level1Person;
    }

    public void setLevel2Person(Long level2Person) {
        this.level2Person = level2Person;
    }

    public Long getLevel2Person() {
        return level2Person;
    }

    public void setLevel3Person(Long level3Person) {
        this.level3Person = level3Person;
    }

    public Long getLevel3Person() {
        return level3Person;
    }

    public void setUsdtGameBrokerageToFather(Double usdtGameBrokerageToFather) {
        this.usdtGameBrokerageToFather = Global.getWalletAmountToReal(usdtGameBrokerageToFather);
    }

    public Double getUsdtGameBrokerageToFather() {
        return usdtGameBrokerageToFather;
    }

    public void setUsdtPromoteBrokerageToFather(Double usdtPromoteBrokerageToFather) {
        this.usdtPromoteBrokerageToFather = Global.getWalletAmountToReal(usdtPromoteBrokerageToFather);
    }

    public Double getUsdtPromoteBrokerageToFather() {
        return usdtPromoteBrokerageToFather;
    }

    public void setTrxGameBrokerageToFather(Double trxGameBrokerageToFather) {
        this.trxGameBrokerageToFather = Global.getWalletAmountToReal(trxGameBrokerageToFather);
    }

    public Double getTrxGameBrokerageToFather() {
        return trxGameBrokerageToFather;
    }

    public void setTrxPromoteBrokerageToFather(Double trxPromoteBrokerageToFather) {
        this.trxPromoteBrokerageToFather = Global.getWalletAmountToReal(trxPromoteBrokerageToFather);
    }

    public Double getTrxPromoteBrokerageToFather() {
        return trxPromoteBrokerageToFather;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("invitationCode", getInvitationCode())
                .append("fatherUserId", getFatherUserId())
                .append("fatherInvitationCode", getFatherInvitationCode())
                .append("incomeUsdtAmount", getIncomeUsdtAmount())
                .append("incomeUsdtToday", getIncomeUsdtToday())
                .append("incomeUsdtYesterday", getIncomeUsdtYesterday())
                .append("incomeUsdtDirectPromote", getIncomeUsdtDirectPromote())
                .append("incomeTrxAmount", getIncomeTrxAmount())
                .append("incomeTrxToday", getIncomeTrxToday())
                .append("incomeTrxYesterday", getIncomeTrxYesterday())
                .append("incomeTrxDirectPromote", getIncomeTrxDirectPromote())
                .append("canWithdrawUsdtAmount", getCanWithdrawUsdtAmount())
                .append("canWithdrawTrxAmount", getCanWithdrawTrxAmount())
                .append("level1Person", getLevel1Person())
                .append("level2Person", getLevel2Person())
                .append("level3Person", getLevel3Person())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("usdtGameBrokerageToFather", getUsdtGameBrokerageToFather())
                .append("usdtPromoteBrokerageToFather", getUsdtPromoteBrokerageToFather())
                .append("trxGameBrokerageToFather", getTrxGameBrokerageToFather())
                .append("trxPromoteBrokerageToFather", getTrxPromoteBrokerageToFather())
                .toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
