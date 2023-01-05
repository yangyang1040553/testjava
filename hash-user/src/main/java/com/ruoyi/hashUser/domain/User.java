package com.ruoyi.hashUser.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 t_user
 * 
 * @author xxk
 * @date 2023-01-05
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 账号 */
    @Excel(name = "账号")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 设备码 */
    @Excel(name = "设备码")
    private String deviceId;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickName;

    /** 来源类型 */
    @Excel(name = "来源类型")
    private Long originType;

    /** 来源id */
    @Excel(name = "来源id")
    private String originId;

    /** 账号绑定时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "账号绑定时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bindTime;

    /** 登录ip */
    @Excel(name = "登录ip")
    private String loginIp;

    /** 注册ip */
    @Excel(name = "注册ip")
    private String regIp;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private Long userType;

    /** 状态 0正常 1冻结 */
    @Excel(name = "状态 0正常 1冻结")
    private Long userStatus;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    /** vip过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "vip过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vipExpireTime;

    /** 是否是会员 */
    @Excel(name = "是否是会员")
    private Long isVip;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setOriginType(Long originType) 
    {
        this.originType = originType;
    }

    public Long getOriginType() 
    {
        return originType;
    }
    public void setOriginId(String originId) 
    {
        this.originId = originId;
    }

    public String getOriginId() 
    {
        return originId;
    }
    public void setBindTime(Date bindTime) 
    {
        this.bindTime = bindTime;
    }

    public Date getBindTime() 
    {
        return bindTime;
    }
    public void setLoginIp(String loginIp) 
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp() 
    {
        return loginIp;
    }
    public void setRegIp(String regIp) 
    {
        this.regIp = regIp;
    }

    public String getRegIp() 
    {
        return regIp;
    }
    public void setUserType(Long userType) 
    {
        this.userType = userType;
    }

    public Long getUserType() 
    {
        return userType;
    }
    public void setUserStatus(Long userStatus) 
    {
        this.userStatus = userStatus;
    }

    public Long getUserStatus() 
    {
        return userStatus;
    }
    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }
    public void setVipExpireTime(Date vipExpireTime) 
    {
        this.vipExpireTime = vipExpireTime;
    }

    public Date getVipExpireTime() 
    {
        return vipExpireTime;
    }
    public void setIsVip(Long isVip) 
    {
        this.isVip = isVip;
    }

    public Long getIsVip() 
    {
        return isVip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("phoneNumber", getPhoneNumber())
            .append("email", getEmail())
            .append("deviceId", getDeviceId())
            .append("nickName", getNickName())
            .append("originType", getOriginType())
            .append("originId", getOriginId())
            .append("bindTime", getBindTime())
            .append("loginIp", getLoginIp())
            .append("regIp", getRegIp())
            .append("userType", getUserType())
            .append("userStatus", getUserStatus())
            .append("lastLoginTime", getLastLoginTime())
            .append("createTime", getCreateTime())
            .append("vipExpireTime", getVipExpireTime())
            .append("isVip", getIsVip())
            .toString();
    }
}
