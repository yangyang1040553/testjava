package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 群组列表对象 t_user_telegram_group
 * 
 * @author xxk
 * @date 2022-07-10
 */
public class UserTelegramGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 群组id */
    @Excel(name = "群组id")
    private String groupId;

    /** tg唯一id */
    @Excel(name = "tg唯一id")
    private String createTgId;

    /** 群组名称 */
    @Excel(name = "群组名称")
    private String name;

    /** 群组链接 */
    @Excel(name = "群组链接")
    private String tgUrl;

    public void setGroupId(String groupId) 
    {
        this.groupId = groupId;
    }

    public String getGroupId() 
    {
        return groupId;
    }
    public void setCreateTgId(String createTgId) 
    {
        this.createTgId = createTgId;
    }

    public String getCreateTgId() 
    {
        return createTgId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTgUrl(String tgUrl) 
    {
        this.tgUrl = tgUrl;
    }

    public String getTgUrl() 
    {
        return tgUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("groupId", getGroupId())
            .append("createTgId", getCreateTgId())
            .append("name", getName())
            .append("tgUrl", getTgUrl())
            .append("createTime", getCreateTime())
            .toString();
    }
}
