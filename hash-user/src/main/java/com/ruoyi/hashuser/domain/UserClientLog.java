package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户端日志对象 t_user_client_log
 * 
 * @author xxk
 * @date 2022-07-08
 */
public class UserClientLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private String id;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 日志 */
    @Excel(name = "日志")
    private String logs;

    @Excel(name = "搜索时间")
    private String searchTime;

    private String invitationCode;

    //查询客户端日志时间
    public transient String showClientLogTime;

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public String getShowClientLogTime() {
        return showClientLogTime;
    }

    public void setShowClientLogTime(String showClientLogTime) {
        this.showClientLogTime = showClientLogTime;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

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
    public void setLogs(String logs) 
    {
        this.logs = logs;
    }

    public String getLogs() 
    {
        return logs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("logs", getLogs())
            .append("createTime", getCreateTime())
            .toString();
    }
}
