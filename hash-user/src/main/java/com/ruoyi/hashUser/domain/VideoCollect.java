package com.ruoyi.hashUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频收藏对象 t_video_collect
 * 
 * @author xxk
 * @date 2023-01-05
 */
public class VideoCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 视频id */
    @Excel(name = "视频id")
    private String vId;

    /** 标题 */
    @Excel(name = "标题")
    private String vTitle;

    /** 视频图片地址 */
    @Excel(name = "视频图片地址")
    private String vImg;

    /** 持续时长 */
    @Excel(name = "持续时长")
    private String duration;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setvId(String vId) 
    {
        this.vId = vId;
    }

    public String getvId() 
    {
        return vId;
    }
    public void setvTitle(String vTitle) 
    {
        this.vTitle = vTitle;
    }

    public String getvTitle() 
    {
        return vTitle;
    }
    public void setvImg(String vImg) 
    {
        this.vImg = vImg;
    }

    public String getvImg() 
    {
        return vImg;
    }
    public void setDuration(String duration) 
    {
        this.duration = duration;
    }

    public String getDuration() 
    {
        return duration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("vId", getvId())
            .append("vTitle", getvTitle())
            .append("vImg", getvImg())
            .append("duration", getDuration())
            .append("createTime", getCreateTime())
            .toString();
    }
}
