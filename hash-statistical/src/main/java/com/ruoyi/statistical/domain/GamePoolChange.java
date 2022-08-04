package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏奖金池变化对象 t_game_pool_change
 * 
 * @author xxk
 * @date 2022-08-04
 */
public class GamePoolChange extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** usdt金额 */
    @Excel(name = "usdt金额")
    private String usdtAmount;

    /** trx金额 */
    @Excel(name = "trx金额")
    private String trxAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsdtAmount(String usdtAmount) 
    {
        this.usdtAmount = usdtAmount;
    }

    public String getUsdtAmount() 
    {
        return usdtAmount;
    }
    public void setTrxAmount(String trxAmount) 
    {
        this.trxAmount = trxAmount;
    }

    public String getTrxAmount() 
    {
        return trxAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usdtAmount", getUsdtAmount())
            .append("trxAmount", getTrxAmount())
            .append("createTime", getCreateTime())
            .toString();
    }
}
