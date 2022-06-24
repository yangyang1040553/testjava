package com.ruoyi.game.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏共用配置对象 t_game_global_config
 * 
 * @author xxk
 * @date 2022-06-24
 */
public class GameGlobalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private String id;

    /** usdt池金额 */
    @Excel(name = "usdt池金额")
    private Long usdtPoolAmount;

    /** trx池金额 */
    @Excel(name = "trx池金额")
    private Long trxPoolAmount;

    /** 结算代理佣金的时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结算代理佣金的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date calcPromoteTime;

    /** usdt佣金提现最低限额 */
    @Excel(name = "usdt佣金提现最低限额")
    private Long brokerageUsdtLimit;

    /** trx佣金提现最低限额 */
    @Excel(name = "trx佣金提现最低限额")
    private Long brokerageTrxLimit;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUsdtPoolAmount(Long usdtPoolAmount) 
    {
        this.usdtPoolAmount = usdtPoolAmount;
    }

    public Long getUsdtPoolAmount() 
    {
        return usdtPoolAmount;
    }
    public void setTrxPoolAmount(Long trxPoolAmount) 
    {
        this.trxPoolAmount = trxPoolAmount;
    }

    public Long getTrxPoolAmount() 
    {
        return trxPoolAmount;
    }
    public void setCalcPromoteTime(Date calcPromoteTime) 
    {
        this.calcPromoteTime = calcPromoteTime;
    }

    public Date getCalcPromoteTime() 
    {
        return calcPromoteTime;
    }
    public void setBrokerageUsdtLimit(Long brokerageUsdtLimit) 
    {
        this.brokerageUsdtLimit = brokerageUsdtLimit;
    }

    public Long getBrokerageUsdtLimit() 
    {
        return brokerageUsdtLimit;
    }
    public void setBrokerageTrxLimit(Long brokerageTrxLimit) 
    {
        this.brokerageTrxLimit = brokerageTrxLimit;
    }

    public Long getBrokerageTrxLimit() 
    {
        return brokerageTrxLimit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usdtPoolAmount", getUsdtPoolAmount())
            .append("trxPoolAmount", getTrxPoolAmount())
            .append("calcPromoteTime", getCalcPromoteTime())
            .append("brokerageUsdtLimit", getBrokerageUsdtLimit())
            .append("brokerageTrxLimit", getBrokerageTrxLimit())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
