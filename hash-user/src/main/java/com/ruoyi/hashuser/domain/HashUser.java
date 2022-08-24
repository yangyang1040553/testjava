package com.ruoyi.hashuser.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.Global;
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

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date registerTime;

    /**
     * 账户绑定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "账户绑定时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date bindTime;

    /**
     * 注册ip
     */
    @Excel(name = "注册ip")
    private String registerIp;

    /**
     * 登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date loginTime;

    /**
     * 登录ip
     */
    @Excel(name = "登录ip")
    private String loginIp;

    @Excel(name = "每日充值总金额")
    private Double inAmount;

    @Excel(name = "每日提现总金额")
    private Double outAmount;

    @Excel(name = "每日投注总额")
    private Double betAmount;

    private Integer pageNum;
    private Integer pageSize;


    /**
     * 一级代理人数
     */
    @Excel(name = "一级代理人数")
    private Long level1Person;

    /**
     * 二级代理人数
     */
    @Excel(name = "二级代理人数")
    private Long level2Person;

    /**
     * 三级代理人数
     */
    @Excel(name = "三级代理人数")
    private Long level3Person;


    /**
     * 三级代理人数
     */
    @Excel(name = "用户USDT总额")
    private Double usdtAmount;
    /**
     * 三级代理人数
     */
    @Excel(name = "用户TRX总额")
    private Double trxAmount;
    /**
     * 三级代理人数
     */
    @Excel(name = "IP地址")
    private String ipAddr;

    @Excel(name = "代理返佣赔率")
    private Double promoteOdds;

    @Excel(name = "分享代理返佣赔率")
    private Double sharePromoteOdds;


    @Excel(name = "用户备注")
    private String noteName;

    @Excel(name = "飞机ID")
    private String tgId;

    @Excel(name = "飞机账号")
    private String tgAccount;

    @Excel(name = "TRC地址")
    private String hashAddressTrx;

    @Excel(name = "TRC转换地址")
    private String hashTransAddressTrx;

    //查询客户端日志时间
    public transient String showClientLogTime;

    @Excel(name = "USDT远程余额")
    private Double usdt_remote_amount;

    @Excel(name = "TRX远程余额")
    private Double trx_remote_amount;


    @Excel(name = "登录地址")
    private String login_addr;

    private Double trx_in_amount;
    private Double usdt_in_amount;
    private Double trx_out_mount;
    private Double usdt_out_mount;
    private Double usdt_bet_amount;
    private Double trx_bet_amount;

    @Excel(name = "唯一ID")
    private String unique_id;
    @Excel(name = "注册地址")
    private String reg_addr;

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getReg_addr() {
        return reg_addr;
    }

    public void setReg_addr(String reg_addr) {
        this.reg_addr = reg_addr;
    }

    public String getLogin_addr() {
        return login_addr;
    }

    public void setLogin_addr(String login_addr) {
        this.login_addr = login_addr;
    }

    public Double getUsdt_bet_amount() {
        return Global.getWalletAmountToReal(usdt_bet_amount);
    }

    public void setUsdt_bet_amount(Double usdt_bet_amount) {
        this.usdt_bet_amount = usdt_bet_amount;
    }

    public Double getTrx_bet_amount() {
        return Global.getWalletAmountToReal(trx_bet_amount);
    }

    public void setTrx_bet_amount(Double trx_bet_amount) {
        this.trx_bet_amount = trx_bet_amount;
    }

    public Double getTrx_in_amount() {
        return Global.getWalletAmountToReal(trx_in_amount);
    }

    public void setTrx_in_amount(Double trx_in_amount) {
        this.trx_in_amount = trx_in_amount;
    }

    public Double getUsdt_in_amount() {
        return Global.getWalletAmountToReal(usdt_in_amount);
    }

    public void setUsdt_in_amount(Double usdt_in_amount) {
        this.usdt_in_amount = usdt_in_amount;
    }

    public Double getTrx_out_mount() {
        return Global.getWalletAmountToReal(trx_out_mount);
    }

    public void setTrx_out_mount(Double trx_out_mount) {
        this.trx_out_mount = trx_out_mount;
    }

    public Double getUsdt_out_mount() {
        return Global.getWalletAmountToReal(usdt_out_mount);
    }

    public void setUsdt_out_mount(Double usdt_out_mount) {
        this.usdt_out_mount = usdt_out_mount;
    }

    public Double getUsdt_remote_amount() {
        return Global.getWalletAmountToReal(usdt_remote_amount);
    }

    public void setUsdt_remote_amount(Double usdt_remote_amount) {
        this.usdt_remote_amount = usdt_remote_amount;
    }

    public Double getTrx_remote_amount() {
        return Global.getWalletAmountToReal(trx_remote_amount);
    }

    public void setTrx_remote_amount(Double trx_remote_amount) {
        this.trx_remote_amount = trx_remote_amount;
    }

    public String getHashAddressTrx() {
        return hashAddressTrx;
    }

    public void setHashAddressTrx(String hashAddressTrx) {
        this.hashAddressTrx = hashAddressTrx;
    }

    public String getHashTransAddressTrx() {
        return hashTransAddressTrx;
    }

    public void setHashTransAddressTrx(String hashTransAddressTrx) {
        this.hashTransAddressTrx = hashTransAddressTrx;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getTgAccount() {
        return tgAccount;
    }

    public void setTgAccount(String tgAccount) {
        this.tgAccount = tgAccount;
    }

    public Double getPromoteOdds() {
        return promoteOdds;
    }

    public void setPromoteOdds(Double promoteOdds) {
        this.promoteOdds = promoteOdds;
    }

    public Double getSharePromoteOdds() {
        return sharePromoteOdds;
    }

    public void setSharePromoteOdds(Double sharePromoteOdds) {
        this.sharePromoteOdds = sharePromoteOdds;
    }

    public Double getUsdtAmount() {
        return Global.getWalletAmountToReal(usdtAmount);
    }

    public void setUsdtAmount(Double usdtAmount) {
        this.usdtAmount = usdtAmount;
    }

    public Double getTrxAmount() {
        return Global.getWalletAmountToReal(trxAmount);
    }

    public void setTrxAmount(Double trxAmount) {
        this.trxAmount = trxAmount;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    /**
     * $column.columnComment
     */
    @Excel(name = "总代理人数")
    private Long sumNumber;

    public Long getLevel1Person() {
        return level1Person;
    }

    public void setLevel1Person(Long level1Person) {
        this.level1Person = level1Person;
    }

    public Long getLevel2Person() {
        return level2Person;
    }

    public void setLevel2Person(Long level2Person) {
        this.level2Person = level2Person;
    }

    public Long getLevel3Person() {
        return level3Person;
    }

    public void setLevel3Person(Long level3Person) {
        this.level3Person = level3Person;
    }

    public Long getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(Long sumNumber) {
        this.sumNumber = sumNumber;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Double getInAmount() {
        return Global.getWalletAmountToReal(inAmount);
    }

    public void setInAmount(Double inAmount) {
        this.inAmount = inAmount;
    }

    public Double getOutAmount() {
        return Global.getWalletAmountToReal(outAmount);
    }

    public void setOutAmount(Double outAmount) {
        this.outAmount = outAmount;
    }

    public Double getBetAmount() {
        return Global.getWalletAmountToReal(betAmount);
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getShowClientLogTime() {
        return showClientLogTime;
    }

    public void setShowClientLogTime(String showClientLogTime) {
        this.showClientLogTime = showClientLogTime;
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
