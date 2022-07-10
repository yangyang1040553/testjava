package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户首页的banner列对象 t_user_banner_config
 * 
 * @author xxk
 * @date 2022-05-18
 */
public class HashUserBannerConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** banner的url */
    @Excel(name = "banner的url")
    private String bannerUrl;

    /** 是否跳转 0否 1是 */
    @Excel(name = "是否跳转 0否 1是")
    private Long isSkip;

    /** 跳转的链接 */
    @Excel(name = "跳转的链接")
    private String skipUrl;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    private String sort;
    private String prop;


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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
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
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
