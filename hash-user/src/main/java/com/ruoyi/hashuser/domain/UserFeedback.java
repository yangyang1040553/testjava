package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户意见反馈对象 t_user_feedback
 * 
 * @author xxk
 * @date 2022-05-08
 */
public class UserFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 玩家ID */
    @Excel(name = "玩家ID")
    private String userId;

    /** 玩家昵称 */
    @Excel(name = "玩家昵称")
    private String nickName;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .toString();
    }
}
