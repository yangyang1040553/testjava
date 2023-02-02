package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Banner图对象 t_user_banner_config
 *
 * @author xxk
 * @date 2023-02-02
 */
public class UserBannerConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     * banner的url
     */
    @Excel(name = "banner的url ")
    private String bannerUrl;

    /**
     * 是否跳转 0不跳转 1跳转
     */
    @Excel(name = "是否跳转 0不跳转 1跳转")
    private Long isSkip;

    /**
     * 跳转的url
     */
    @Excel(name = "跳转的url")
    private String skipUrl;

    /**
     * 权重
     */
    @Excel(name = "权重")
    private Long weight;

    /**
     * banner 位置 1.首页 2播放 3搜索 4 个人中心
     */
    @Excel(name = "banner 位置 1.首页 2播放 3搜索 4 个人中心")
    private Long position;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setIsSkip(Long isSkip) {
        this.isSkip = isSkip;
    }

    public Long getIsSkip() {
        return isSkip;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeight() {
        return weight;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Long getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("bannerUrl", getBannerUrl()).append("isSkip", getIsSkip()).append("skipUrl", getSkipUrl()).append("weight", getWeight()).append("position", getPosition()).toString();
    }
}
