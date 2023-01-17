package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIP类型配置对象 t_wallet_vip_config
 * 
 * @author xxk
 * @date 2023-01-06
 */
public class WalletVipConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Id */
    private Long id;

    /** vip类型 1月卡 2季卡 3年卡 */
    @Excel(name = "vip类型 1月卡 2季卡 3年卡")
    private Long vipType;

    /** 原价 */
    @Excel(name = "原价")
    private Long sourcePrice;

    /** 当前价格 */
    @Excel(name = "当前价格")
    private Long price;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** vip天数 */
    @Excel(name = "vip天数")
    private Long vipDay;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVipType(Long vipType) 
    {
        this.vipType = vipType;
    }

    public Long getVipType() 
    {
        return vipType;
    }
    public void setSourcePrice(Long sourcePrice) 
    {
        this.sourcePrice = sourcePrice;
    }

    public Long getSourcePrice() 
    {
        return sourcePrice;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setVipDay(Long vipDay) 
    {
        this.vipDay = vipDay;
    }

    public Long getVipDay() 
    {
        return vipDay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vipType", getVipType())
            .append("sourcePrice", getSourcePrice())
            .append("price", getPrice())
            .append("name", getName())
            .append("vipDay", getVipDay())
            .toString();
    }
}
