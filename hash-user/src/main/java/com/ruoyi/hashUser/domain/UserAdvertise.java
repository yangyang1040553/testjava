package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告管理对象 t_user_advertise
 * 
 * @author xxk
 * @date 2023-01-18
 */
public class UserAdvertise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 广告名称 */
    @Excel(name = "广告名称")
    private String name;

    /** 广告url */
    @Excel(name = "广告url")
    private String url;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String jumpUrl;

    /**  1 启动页广告   2 播放页广告 */
    @Excel(name = " 1 启动页广告   2 播放页广告")
    private Long position;

    /** 是否开启 */
    @Excel(name = "是否开启")
    private Long enable;

    /** 播放秒数 */
    @Excel(name = "播放秒数")
    private Long seconds;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setJumpUrl(String jumpUrl) 
    {
        this.jumpUrl = jumpUrl;
    }

    public String getJumpUrl() 
    {
        return jumpUrl;
    }
    public void setPosition(Long position) 
    {
        this.position = position;
    }

    public Long getPosition() 
    {
        return position;
    }
    public void setEnable(Long enable) 
    {
        this.enable = enable;
    }

    public Long getEnable() 
    {
        return enable;
    }
    public void setSeconds(Long seconds) 
    {
        this.seconds = seconds;
    }

    public Long getSeconds() 
    {
        return seconds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("url", getUrl())
            .append("jumpUrl", getJumpUrl())
            .append("position", getPosition())
            .append("enable", getEnable())
            .append("seconds", getSeconds())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
