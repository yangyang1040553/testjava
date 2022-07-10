package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户飞机对象 t_user_telegram
 * 
 * @author xxk
 * @date 2022-07-08
 */
public class UserTelegram extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** tg账户 */
    @Excel(name = "tg账户")
    private String tgAccount;

    /** tg唯一id */
    @Excel(name = "tg唯一id")
    private String tgId;

    /** tg昵称 */
    @Excel(name = "tg昵称")
    private String tgName;

    /** 应用id */
    @Excel(name = "应用id")
    private String tgAppId;

    /** tg类型 master user */
    @Excel(name = "tg类型 master user")
    private String tgType;

    /** tg群主 */
    @Excel(name = "tg群主")
    private String tgGourp;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;


    @Excel(name = "tg_app_key")
    private String tg_app_key;

    @Excel(name = "tg_random_no")
    private String tg_random_no;

    public String getTg_app_key() {
        return tg_app_key;
    }

    public void setTg_app_key(String tg_app_key) {
        this.tg_app_key = tg_app_key;
    }

    public String getTg_random_no() {
        return tg_random_no;
    }

    public void setTg_random_no(String tg_random_no) {
        this.tg_random_no = tg_random_no;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setTgAccount(String tgAccount) 
    {
        this.tgAccount = tgAccount;
    }

    public String getTgAccount() 
    {
        return tgAccount;
    }
    public void setTgId(String tgId) 
    {
        this.tgId = tgId;
    }

    public String getTgId() 
    {
        return tgId;
    }
    public void setTgName(String tgName) 
    {
        this.tgName = tgName;
    }

    public String getTgName() 
    {
        return tgName;
    }
    public void setTgAppId(String tgAppId) 
    {
        this.tgAppId = tgAppId;
    }

    public String getTgAppId() 
    {
        return tgAppId;
    }
    public void setTgType(String tgType) 
    {
        this.tgType = tgType;
    }

    public String getTgType() 
    {
        return tgType;
    }
    public void setTgGourp(String tgGourp) 
    {
        this.tgGourp = tgGourp;
    }

    public String getTgGourp() 
    {
        return tgGourp;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tgAccount", getTgAccount())
            .append("tgId", getTgId())
            .append("tgName", getTgName())
            .append("tgAppId", getTgAppId())
            .append("tgType", getTgType())
            .append("tgGourp", getTgGourp())
            .append("userId", getUserId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
