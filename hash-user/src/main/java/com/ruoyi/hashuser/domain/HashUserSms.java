package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户短信功能对象 t_user_sms
 * 
 * @author xxk
 * @date 2022-05-12
 */
public class HashUserSms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    private String id;

    /** 玩家id */
    @Excel(name = "玩家id")
    private String userId;

    /** 国际区号 */
    @Excel(name = "国际区号")
    private String areaCode;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 是否成功0失败1成功 */
    @Excel(name = "是否成功0失败1成功")
    private Long ok;

    /** 返回数据 */
    @Excel(name = "返回数据")
    private String responseData;

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
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setOk(Long ok) 
    {
        this.ok = ok;
    }

    public Long getOk() 
    {
        return ok;
    }
    public void setResponseData(String responseData) 
    {
        this.responseData = responseData;
    }

    public String getResponseData() 
    {
        return responseData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("areaCode", getAreaCode())
            .append("phone", getPhone())
            .append("ok", getOk())
            .append("responseData", getResponseData())
            .append("createTime", getCreateTime())
            .toString();
    }
}
