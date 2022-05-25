package com.ruoyi.hashuser.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户公告对象 t_user_notice
 * 
 * @author xxk
 * @date 2022-05-10
 */
public class HashUserNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String title;

    /** 公告内容-支付富文本 */
    @Excel(name = "公告内容-支付富文本")
    private String content;

    /** 是否开启 0-关闭 1-开启 */
    @Excel(name = "是否开启 0-关闭 1-开启")
    private Long isOpen;

    /** 公告结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "公告结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    @Excel(name = "是否弹窗 0-否 1-是")
    private  Integer isPop;

    @Excel(name = "权重")
    private  Integer weight;

    public Integer getIsPop() {
        return isPop;
    }

    public void setIsPop(Integer isPop) {
        this.isPop = isPop;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    private String  sort;

    private String  prop;

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

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsOpen(Long isOpen) 
    {
        this.isOpen = isOpen;
    }

    public Long getIsOpen() 
    {
        return isOpen;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("isOpen", getIsOpen())
            .append("finishTime", getFinishTime())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
