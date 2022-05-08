package com.ruoyi.hashuser.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 t_user
 *
 * @author xxk
 * @date 2022-05-08
 */
public class HashUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户类型
     */
    @Excel(name = "用户类型")
    private Long userType;

    /**
     * 手机区号
     */
    @Excel(name = "手机区号")
    private String areaCode;

    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String account;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;

    /**
     * 设备码
     */
    @Excel(name = "设备码")
    private String deviceCode;

    /**
     * 平台-IOS、android
     */
    @Excel(name = "平台-IOS、android")
    private String platform;

    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String nickName;

    /**
     * 头像
     */
    @Excel(name = "头像")
    private String head;

    /**
     * 用户状态 0正常 1冻结
     */
    @Excel(name = "用户状态 0正常 1冻结 ")
    private Long status;

    /**
     * 是否在线 0离线 1在线
     */
    @Excel(name = "是否在线 0离线 1在线")
    private Long online;

    /**
     * 邀请码
     */
    @Excel(name = "邀请码")
    private String invitationCode;

    /**
     * 上级邀请码(不为空 就建立了绑定关系)
     */
    @Excel(name = "上级邀请码(不为空 就建立了绑定关系)")
    private String fatherInvitationCode;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date registerTime;

    /** 账户绑定时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "账户绑定时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date bindTime;

    /** 注册ip */
    @Excel(name = "注册ip")
    private String registerIp;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date loginTime;

    /** 登录ip */
    @Excel(name = "登录ip")
    private String loginIp;

    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public Long getUserType() {
        return userType;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setOnline(Long online) {
        this.online = online;
    }

    public Long getOnline() {
        return online;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setFatherInvitationCode(String fatherInvitationCode) {
        this.fatherInvitationCode = fatherInvitationCode;
    }

    public String getFatherInvitationCode() {
        return fatherInvitationCode;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginIp() {
        return loginIp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userType", getUserType())
                .append("areaCode", getAreaCode())
                .append("phone", getPhone())
                .append("account", getAccount())
                .append("password", getPassword())
                .append("deviceCode", getDeviceCode())
                .append("platform", getPlatform())
                .append("nickName", getNickName())
                .append("head", getHead())
                .append("status", getStatus())
                .append("online", getOnline())
                .append("invitationCode", getInvitationCode())
                .append("fatherInvitationCode", getFatherInvitationCode())
                .append("registerTime", getRegisterTime())
                .append("bindTime", getBindTime())
                .append("registerIp", getRegisterIp())
                .append("loginTime", getLoginTime())
                .append("loginIp", getLoginIp())
                .toString();
    }
}
