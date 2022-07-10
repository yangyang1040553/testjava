package com.ruoyi.hashuser.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户的活动对象 t_user_activity
 *
 * @author xxk
 * @date 2022-05-11
 */
public class HashUserActivity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    private String id;

    /**
     * 活动名称
     */
    @Excel(name = "活动名称")
    private String name;

    /**
     * banner图的链接
     */
    @Excel(name = "banner图的链接")
    private String bannerUrl;

    /**
     * 落地页URL地址
     */
    @Excel(name = "落地页URL地址")
    private String landingPageUrl;

    /**
     * 是否开启 0关闭 1开启
     */
    @Excel(name = "是否开启 0关闭 1开启")
    private Long open;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    private String sort;

    private String prop;

    private String operationId;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setLandingPageUrl(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    public void setOpen(Long open) {
        this.open = open;
    }

    public Long getOpen() {
        return open;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("bannerUrl", getBannerUrl())
                .append("landingPageUrl", getLandingPageUrl())
                .append("open", getOpen())
                .append("finishTime", getFinishTime())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
