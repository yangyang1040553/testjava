package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 代理每日收益金额对象 t_game_statistical_promote_income
 * 
 * @author xxk
 * @date 2022-06-05
 */
public class GameStatisticalPromoteIncome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id-天为单位 */
    @Excel(name = "id-天为单位")
    private String id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String invitationCode;

    /** usdt收益金额 */
    @Excel(name = "usdt收益金额")
    private Long usdtIncomeAmount;

    /** trx收益金额 */
    @Excel(name = "trx收益金额")
    private Long trxIncomeAmount;

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
    public void setInvitationCode(String invitationCode) 
    {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() 
    {
        return invitationCode;
    }
    public void setUsdtIncomeAmount(Long usdtIncomeAmount) 
    {
        this.usdtIncomeAmount = usdtIncomeAmount;
    }

    public Long getUsdtIncomeAmount() 
    {
        return usdtIncomeAmount;
    }
    public void setTrxIncomeAmount(Long trxIncomeAmount) 
    {
        this.trxIncomeAmount = trxIncomeAmount;
    }

    public Long getTrxIncomeAmount() 
    {
        return trxIncomeAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("invitationCode", getInvitationCode())
            .append("usdtIncomeAmount", getUsdtIncomeAmount())
            .append("trxIncomeAmount", getTrxIncomeAmount())
            .toString();
    }
}
