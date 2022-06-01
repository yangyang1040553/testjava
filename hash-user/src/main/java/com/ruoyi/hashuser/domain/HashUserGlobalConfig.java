package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户全局配置对象 t_user_global_config
 *
 * @author xxk
 * @date 2022-06-01
 */
public class HashUserGlobalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private String id;

    /** 最新的主页地址 */
    @Excel(name = "最新的主页地址")
    private String newDomainAddr;

    /** 在线客服地址 */
    @Excel(name = "在线客服地址")
    private String onlineServiceAddr;

    /** 官方群组地址 */
    @Excel(name = "官方群组地址")
    private String groupAddr;

    /** 用户注册协议地址 */
    @Excel(name = "用户注册协议地址")
    private String regProtocolAddr;

    /** 推广链接地址 */
    @Excel(name = "推广链接地址")
    private String promoteAddr;

    /** ios下载地址 */
    @Excel(name = "ios下载地址")
    private String iosDownloadAddr;

    /** ios版本号 */
    @Excel(name = "ios版本号")
    private String iosVersion;

    /** 安卓下载地址 */
    @Excel(name = "安卓下载地址")
    private String androidDownloadAddr;

    /** 安卓版本号 */
    @Excel(name = "安卓版本号")
    private String androidVersion;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setNewDomainAddr(String newDomainAddr)
    {
        this.newDomainAddr = newDomainAddr;
    }

    public String getNewDomainAddr()
    {
        return newDomainAddr;
    }
    public void setOnlineServiceAddr(String onlineServiceAddr)
    {
        this.onlineServiceAddr = onlineServiceAddr;
    }

    public String getOnlineServiceAddr()
    {
        return onlineServiceAddr;
    }
    public void setGroupAddr(String groupAddr)
    {
        this.groupAddr = groupAddr;
    }

    public String getGroupAddr()
    {
        return groupAddr;
    }
    public void setRegProtocolAddr(String regProtocolAddr)
    {
        this.regProtocolAddr = regProtocolAddr;
    }

    public String getRegProtocolAddr()
    {
        return regProtocolAddr;
    }
    public void setPromoteAddr(String promoteAddr)
    {
        this.promoteAddr = promoteAddr;
    }

    public String getPromoteAddr()
    {
        return promoteAddr;
    }
    public void setIosDownloadAddr(String iosDownloadAddr)
    {
        this.iosDownloadAddr = iosDownloadAddr;
    }

    public String getIosDownloadAddr()
    {
        return iosDownloadAddr;
    }
    public void setIosVersion(String iosVersion)
    {
        this.iosVersion = iosVersion;
    }

    public String getIosVersion()
    {
        return iosVersion;
    }
    public void setAndroidDownloadAddr(String androidDownloadAddr)
    {
        this.androidDownloadAddr = androidDownloadAddr;
    }

    public String getAndroidDownloadAddr()
    {
        return androidDownloadAddr;
    }
    public void setAndroidVersion(String androidVersion)
    {
        this.androidVersion = androidVersion;
    }

    public String getAndroidVersion()
    {
        return androidVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("newDomainAddr", getNewDomainAddr())
                .append("onlineServiceAddr", getOnlineServiceAddr())
                .append("groupAddr", getGroupAddr())
                .append("regProtocolAddr", getRegProtocolAddr())
                .append("promoteAddr", getPromoteAddr())
                .append("iosDownloadAddr", getIosDownloadAddr())
                .append("iosVersion", getIosVersion())
                .append("androidDownloadAddr", getAndroidDownloadAddr())
                .append("androidVersion", getAndroidVersion())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
