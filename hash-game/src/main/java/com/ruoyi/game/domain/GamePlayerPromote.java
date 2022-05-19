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
public class GamePlayerPromote extends BaseEntity {
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
    private Long incomeUsdtAmount;

    /**
     * usdt今日收益
     */
    @Excel(name = "usdt今日收益")
    private Long incomeUsdtToday;

    /**
     * usdt昨日收益
     */
    @Excel(name = "usdt昨日收益")
    private Long incomeUsdtYesterday;

    /**
     * usdt直推收益
     */
    @Excel(name = "usdt直推收益")
    private Long incomeUsdtDirectPromote;

    /**
     * trx总收益
     */
    @Excel(name = "trx总收益")
    private Long incomeTrxAmount;

    /**
     * trx今日收益
     */
    @Excel(name = "trx今日收益")
    private Long incomeTrxToday;

    /**
     * trx昨日收益
     */
    @Excel(name = "trx昨日收益")
    private Long incomeTrxYesterday;

    /**
     * trx直推收益
     */
    @Excel(name = "trx直推收益")
    private Long incomeTrxDirectPromote;

    /**
     * 可提现的usdt金额
     */
    @Excel(name = "可提现的usdt金额")
    private Long canWithdrawUsdtAmount;

    /**
     * 可提现的trx金额
     */
    @Excel(name = "可提现的trx金额")
    private Long canWithdrawTrxAmount;

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
    private Long usdtGameBrokerageToFather;

    /**
     * usdt对直接上级的代理返佣贡献
     */
    @Excel(name = "usdt对直接上级的代理返佣贡献")
    private Long usdtPromoteBrokerageToFather;

    /**
     * trx对直接上级的游戏返佣贡献
     */
    @Excel(name = "trx对直接上级的游戏返佣贡献")
    private Long trxGameBrokerageToFather;

    /**
     * trx对直接上级的代理返佣贡献
     */
    @Excel(name = "trx对直接上级的代理返佣贡献")
    private Long trxPromoteBrokerageToFather;

    public void setId(String id) {
        this.id = id;
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

    public void setIncomeUsdtAmount(Long incomeUsdtAmount) {
        this.incomeUsdtAmount = incomeUsdtAmount;
    }

    public Double getIncomeUsdtAmount() {
        return Global.getWalletAmountToReal(incomeUsdtAmount);
    }

    public void setIncomeUsdtToday(Long incomeUsdtToday) {
        this.incomeUsdtToday = incomeUsdtToday;
    }

    public Double getIncomeUsdtToday() {
        return Global.getWalletAmountToReal(incomeUsdtToday);
    }

    public void setIncomeUsdtYesterday(Long incomeUsdtYesterday) {
        this.incomeUsdtYesterday = incomeUsdtYesterday;
    }

    public Double getIncomeUsdtYesterday() {
        return Global.getWalletAmountToReal(incomeUsdtYesterday);
    }

    public void setIncomeUsdtDirectPromote(Long incomeUsdtDirectPromote) {
        this.incomeUsdtDirectPromote = incomeUsdtDirectPromote;
    }

    public Double getIncomeUsdtDirectPromote() {
        return Global.getWalletAmountToReal(incomeUsdtDirectPromote);
    }

    public void setIncomeTrxAmount(Long incomeTrxAmount) {
        this.incomeTrxAmount = incomeTrxAmount;
    }

    public Double getIncomeTrxAmount() {
        return Global.getWalletAmountToReal(incomeTrxAmount);
    }

    public void setIncomeTrxToday(Long incomeTrxToday) {
        this.incomeTrxToday = incomeTrxToday;
    }

    public Double getIncomeTrxToday() {
        return Global.getWalletAmountToReal(incomeTrxToday);
    }

    public void setIncomeTrxYesterday(Long incomeTrxYesterday) {
        this.incomeTrxYesterday = incomeTrxYesterday;
    }

    public Double getIncomeTrxYesterday() {
        return Global.getWalletAmountToReal(incomeTrxYesterday);
    }

    public void setIncomeTrxDirectPromote(Long incomeTrxDirectPromote) {
        this.incomeTrxDirectPromote = incomeTrxDirectPromote;
    }

    public Double getIncomeTrxDirectPromote() {
        return Global.getWalletAmountToReal(incomeTrxDirectPromote);
    }

    public void setCanWithdrawUsdtAmount(Long canWithdrawUsdtAmount) {
        this.canWithdrawUsdtAmount = canWithdrawUsdtAmount;
    }

    public Double getCanWithdrawUsdtAmount() {
        return Global.getWalletAmountToReal(canWithdrawUsdtAmount);
    }

    public void setCanWithdrawTrxAmount(Long canWithdrawTrxAmount) {
        this.canWithdrawTrxAmount = canWithdrawTrxAmount;
    }

    public Double getCanWithdrawTrxAmount() {
        return Global.getWalletAmountToReal(canWithdrawTrxAmount);
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

    public void setUsdtGameBrokerageToFather(Long usdtGameBrokerageToFather) {
        this.usdtGameBrokerageToFather = usdtGameBrokerageToFather;
    }

    public Double getUsdtGameBrokerageToFather() {
        return Global.getWalletAmountToReal(usdtGameBrokerageToFather);
    }

    public void setUsdtPromoteBrokerageToFather(Long usdtPromoteBrokerageToFather) {
        this.usdtPromoteBrokerageToFather = usdtPromoteBrokerageToFather;
    }

    public Double getUsdtPromoteBrokerageToFather() {
        return Global.getWalletAmountToReal(usdtPromoteBrokerageToFather);
    }

    public void setTrxGameBrokerageToFather(Long trxGameBrokerageToFather) {
        this.trxGameBrokerageToFather = trxGameBrokerageToFather;
    }

    public Double getTrxGameBrokerageToFather() {
        return Global.getWalletAmountToReal(trxGameBrokerageToFather);
    }

    public void setTrxPromoteBrokerageToFather(Long trxPromoteBrokerageToFather) {
        this.trxPromoteBrokerageToFather = trxPromoteBrokerageToFather;
    }

    public Double getTrxPromoteBrokerageToFather() {
        return Global.getWalletAmountToReal(trxPromoteBrokerageToFather);
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
}
