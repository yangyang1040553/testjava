package com.ruoyi.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对抗存储列对象 dk_oss_list
 * 
 * @author xxk
 * @date 2022-07-26
 */
public class DkOssList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 存储类型 1阿里云 2腾讯云 3github */
    @Excel(name = "存储类型 1阿里云 2腾讯云 3github")
    private Long ossType;

    /** 存储桶名称 */
    @Excel(name = "存储桶名称")
    private String bucketName;

    /** 访问ID配置 */
    @Excel(name = "访问ID配置")
    private String accessId;

    /** 访问Key配置 */
    @Excel(name = "访问Key配置")
    private String accessKey;

    /** 上传地址 */
    @Excel(name = "上传地址")
    private String uploadAddr;

    /** 访问地址 */
    @Excel(name = "访问地址")
    private String accessAddr;

    /** 健康状态 0健康 1异常 */
    @Excel(name = "健康状态 0健康 1异常")
    private Long satus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOssType(Long ossType) 
    {
        this.ossType = ossType;
    }

    public Long getOssType() 
    {
        return ossType;
    }
    public void setBucketName(String bucketName) 
    {
        this.bucketName = bucketName;
    }

    public String getBucketName() 
    {
        return bucketName;
    }
    public void setAccessId(String accessId) 
    {
        this.accessId = accessId;
    }

    public String getAccessId() 
    {
        return accessId;
    }
    public void setAccessKey(String accessKey) 
    {
        this.accessKey = accessKey;
    }

    public String getAccessKey() 
    {
        return accessKey;
    }
    public void setUploadAddr(String uploadAddr) 
    {
        this.uploadAddr = uploadAddr;
    }

    public String getUploadAddr() 
    {
        return uploadAddr;
    }
    public void setAccessAddr(String accessAddr) 
    {
        this.accessAddr = accessAddr;
    }

    public String getAccessAddr() 
    {
        return accessAddr;
    }
    public void setSatus(Long satus) 
    {
        this.satus = satus;
    }

    public Long getSatus() 
    {
        return satus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ossType", getOssType())
            .append("bucketName", getBucketName())
            .append("accessId", getAccessId())
            .append("accessKey", getAccessKey())
            .append("uploadAddr", getUploadAddr())
            .append("accessAddr", getAccessAddr())
            .append("satus", getSatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
