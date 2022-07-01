package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 落地页H5反馈对象 t_user_h5_feedback
 * 
 * @author xxk
 * @date 2022-07-01
 */
public class UserH5Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private Long id;

    /** 反馈问题类型 */
    @Excel(name = "反馈问题类型")
    private String items;

    /** 反馈内容 */
    @Excel(name = "反馈内容")
    private String content;

    /** ip */
    @Excel(name = "ip")
    private String ip;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItems(String items) 
    {
        this.items = items;
    }

    public String getItems() 
    {
        return items;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("items", getItems())
            .append("content", getContent())
            .append("ip", getIp())
            .append("email", getEmail())
            .append("createTime", getCreateTime())
            .toString();
    }
}
