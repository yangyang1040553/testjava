package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 版本更新对象 t_user_version
 * 
 * @author xxk
 * @date 2022-06-27
 */
public class UserVersion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 下载地址 */
    @Excel(name = "下载地址")
    private String downloadUrl;

    /** 平台-IOS 安卓 */
    @Excel(name = "平台-IOS 安卓")
    private String platfrom;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 更新至版本号 */
    @Excel(name = "更新至版本号")
    private String upToVersion;

    /** 是否强更 0否 1是 */
    @Excel(name = "是否强更 0否 1是")
    private int force;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDownloadUrl(String downloadUrl) 
    {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() 
    {
        return downloadUrl;
    }
    public void setPlatfrom(String platfrom) 
    {
        this.platfrom = platfrom;
    }

    public String getPlatfrom() 
    {
        return platfrom;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setUpToVersion(String upToVersion) 
    {
        this.upToVersion = upToVersion;
    }

    public String getUpToVersion() 
    {
        return upToVersion;
    }
    public void setForce(int force)
    {
        this.force = force;
    }

    public int getForce()
    {
        return force;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("downloadUrl", getDownloadUrl())
            .append("platfrom", getPlatfrom())
            .append("version", getVersion())
            .append("upToVersion", getUpToVersion())
            .append("force", getForce())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
