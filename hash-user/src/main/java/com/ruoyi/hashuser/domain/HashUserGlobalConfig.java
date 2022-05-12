package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户全局配置对象 t_user_global_config
 * 
 * @author xxk
 * @date 2022-05-12
 */
public class HashUserGlobalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("newDomainAddr", getNewDomainAddr())
            .append("onlineServiceAddr", getOnlineServiceAddr())
            .append("groupAddr", getGroupAddr())
            .append("regProtocolAddr", getRegProtocolAddr())
            .toString();
    }
}
