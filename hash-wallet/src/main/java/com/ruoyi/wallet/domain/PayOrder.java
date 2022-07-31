package com.ruoyi.wallet.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值订单记录对象 t_pay_order
 *
 * @author xxk
 * @date 2022-07-31
 */
public class PayOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String id;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private String userId;

    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String nickName;

    /**
     * 通道ID
     */
    @Excel(name = "通道ID")
    private String channelId;

    /**
     * 商户编号
     */
    @Excel(name = "商户编号")
    private String rechargeMerchantCode;

    /**
     * 目标钱包类型
     */
    @Excel(name = "目标钱包类型")
    private String toWallet;

    /**
     * 转换状态 0=未转换 1=转换中 2=转换失败 3=转换成功
     */
    @Excel(name = "转换状态 0=未转换 1=转换中 2=转换失败 3=转换成功")
    private Long transStatus;

    /**
     * 转换比例
     */
    @Excel(name = "转换比例")
    private Long scale;

    /**
     * 充值金额
     */
    @Excel(name = "充值金额")
    private Double rechargeMoney;

    /**
     * 支付金额
     */
    @Excel(name = "支付金额")
    private Double payMoney;

    /**
     * 0:首充 1:非首充
     */
    private Long isFirstRecharge;

    /**
     * 支付状态 0=未支付 1=已支付 2=已取消
     */
    @Excel(name = " 支付状态 0=未支付 1=已支付 2=已取消")
    private String payStatus;

    /**
     * 订单状态 0=未处理 1=已完成 2=已关闭 3=已取消
     */
    @Excel(name = " 订单状态 0=未处理 1=已完成 2=已关闭 3=已取消")
    private String orderStatus;

    /**
     * 支付类型关联支付类型表
     */
    @Excel(name = " 支付类型关联支付类型表")
    private String payTypeNo;

    /**
     * 通道编码
     */
    @Excel(name = "通道编码")
    private String channelCode;

    /**
     * 渠道编码
     */
    @Excel(name = "渠道编码")
    private String channelNo;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /**
     * 失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invalidTime;

    /**
     * 三方支付流水编号
     */
    @Excel(name = "三方支付流水编号")
    private String thirdOrderNo;

    /**
     * 支付跳转地址
     */
    @Excel(name = "支付跳转地址")
    private String payUrl;

    /**
     * 请求报文
     */
    @Excel(name = "请求报文")
    private String reqMessage;

    /**
     * 回调报文
     */
    @Excel(name = "回调报文")
    private String callbackMessage;

    /**
     * 注册渠道
     */
    @Excel(name = "注册渠道")
    private String regChannel;

    /**
     * 删除标识, 0:已删除, 1:正常
     */
    private String delFlag;

    /**
     * 操作人
     */
    @Excel(name = "操作人")
    private String updateUser;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setRechargeMerchantCode(String rechargeMerchantCode) {
        this.rechargeMerchantCode = rechargeMerchantCode;
    }

    public String getRechargeMerchantCode() {
        return rechargeMerchantCode;
    }

    public void setToWallet(String toWallet) {
        this.toWallet = toWallet;
    }

    public String getToWallet() {
        return toWallet;
    }

    public void setTransStatus(Long transStatus) {
        this.transStatus = transStatus;
    }

    public Long getTransStatus() {
        return transStatus;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public Long getScale() {
        return scale;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Double getRechargeMoney() {
        return Global.getWalletAmountToReal(rechargeMoney);
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Double getPayMoney() {
        return Global.getWalletAmountToReal(payMoney);
    }

    public void setIsFirstRecharge(Long isFirstRecharge) {
        this.isFirstRecharge = isFirstRecharge;
    }

    public Long getIsFirstRecharge() {
        return isFirstRecharge;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setPayTypeNo(String payTypeNo) {
        this.payTypeNo = payTypeNo;
    }

    public String getPayTypeNo() {
        return payTypeNo;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setThirdOrderNo(String thirdOrderNo) {
        this.thirdOrderNo = thirdOrderNo;
    }

    public String getThirdOrderNo() {
        return thirdOrderNo;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage;
    }

    public String getReqMessage() {
        return reqMessage;
    }

    public void setCallbackMessage(String callbackMessage) {
        this.callbackMessage = callbackMessage;
    }

    public String getCallbackMessage() {
        return callbackMessage;
    }

    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }

    public String getRegChannel() {
        return regChannel;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("channelId", getChannelId())
                .append("rechargeMerchantCode", getRechargeMerchantCode())
                .append("toWallet", getToWallet())
                .append("transStatus", getTransStatus())
                .append("scale", getScale())
                .append("rechargeMoney", getRechargeMoney())
                .append("payMoney", getPayMoney())
                .append("isFirstRecharge", getIsFirstRecharge())
                .append("payStatus", getPayStatus())
                .append("orderStatus", getOrderStatus())
                .append("payTypeNo", getPayTypeNo())
                .append("channelCode", getChannelCode())
                .append("channelNo", getChannelNo())
                .append("payTime", getPayTime())
                .append("invalidTime", getInvalidTime())
                .append("thirdOrderNo", getThirdOrderNo())
                .append("remark", getRemark())
                .append("payUrl", getPayUrl())
                .append("reqMessage", getReqMessage())
                .append("callbackMessage", getCallbackMessage())
                .append("regChannel", getRegChannel())
                .append("delFlag", getDelFlag())
                .append("updateUser", getUpdateUser())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
