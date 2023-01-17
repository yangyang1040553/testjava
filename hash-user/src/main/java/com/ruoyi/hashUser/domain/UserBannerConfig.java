package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Banner图对象 t_user_banner_config
 * 
 * @author xxk
 * @date 2023-01-07
 */
public class UserBannerConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String bannerUrl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long isSkip;

    /** 跳转的链接 */
    @Excel(name = "跳转的链接")
    private String skipUrl;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBannerUrl(String bannerUrl) 
    {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() 
    {
        return bannerUrl;
    }
    public void setIsSkip(Long isSkip) 
    {
        this.isSkip = isSkip;
    }

    public Long getIsSkip() 
    {
        return isSkip;
    }
    public void setSkipUrl(String skipUrl) 
    {
        this.skipUrl = skipUrl;
    }

    public String getSkipUrl() 
    {
        return skipUrl;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bannerUrl", getBannerUrl())
            .append("isSkip", getIsSkip())
            .append("skipUrl", getSkipUrl())
            .append("weight", getWeight())
            .toString();
    }
}
