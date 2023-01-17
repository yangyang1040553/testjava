package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 版本控制对象 t_user_global_config
 * 
 * @author xxk
 * @date 2023-01-18
 */
public class UserGlobalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iosDownloadAddr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String iosVersion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String androidDownloadAddr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String androidVersion;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
            .append("iosDownloadAddr", getIosDownloadAddr())
            .append("iosVersion", getIosVersion())
            .append("androidDownloadAddr", getAndroidDownloadAddr())
            .append("androidVersion", getAndroidVersion())
            .toString();
    }
}
