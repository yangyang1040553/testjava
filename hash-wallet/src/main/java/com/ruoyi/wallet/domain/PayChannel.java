package com.ruoyi.wallet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 支付通道配置对象 t_pay_channel
 * 
 * @author xxk
 * @date 2022-07-29
 */
public class PayChannel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 通道名称 */
    @Excel(name = "通道名称")
    private String channelName;

    /** 通道编码 */
    @Excel(name = "通道编码")
    private String channelCode;

    /** 商户编号 */
    @Excel(name = "商户编号")
    private String merchantCode;

    /** 支付方式号 */
    @Excel(name = "支付方式号")
    private String payTypeNo;

    /** 渠道编码 */
    @Excel(name = "渠道编码")
    private String channelNo;

    /** 权重 */
    @Excel(name = "权重")
    private Long weight;

    /** 状态  1=启用 2=禁用 */
    @Excel(name = "状态  1=启用 2=禁用")
    private Long isEnable;

    /** 是否固定金额 0.不是 1.是 */
    @Excel(name = "是否固定金额 0.不是 1.是")
    private Long isFix;

    /** 最小单笔限额 */
    @Excel(name = "最小单笔限额")
    private Long minAmount;

    /** 最大单笔限额 */
    @Excel(name = "最大单笔限额")
    private Long maxAmount;

    /** 固定金额 */
    @Excel(name = "固定金额")
    private String fixAmount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setChannelName(String channelName) 
    {
        this.channelName = channelName;
    }

    public String getChannelName() 
    {
        return channelName;
    }
    public void setChannelCode(String channelCode) 
    {
        this.channelCode = channelCode;
    }

    public String getChannelCode() 
    {
        return channelCode;
    }
    public void setMerchantCode(String merchantCode) 
    {
        this.merchantCode = merchantCode;
    }

    public String getMerchantCode() 
    {
        return merchantCode;
    }
    public void setPayTypeNo(String payTypeNo) 
    {
        this.payTypeNo = payTypeNo;
    }

    public String getPayTypeNo() 
    {
        return payTypeNo;
    }
    public void setChannelNo(String channelNo) 
    {
        this.channelNo = channelNo;
    }

    public String getChannelNo() 
    {
        return channelNo;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setIsEnable(Long isEnable) 
    {
        this.isEnable = isEnable;
    }

    public Long getIsEnable() 
    {
        return isEnable;
    }
    public void setIsFix(Long isFix) 
    {
        this.isFix = isFix;
    }

    public Long getIsFix() 
    {
        return isFix;
    }
    public void setMinAmount(Long minAmount) 
    {
        this.minAmount = minAmount;
    }

    public Long getMinAmount() 
    {
        return minAmount;
    }
    public void setMaxAmount(Long maxAmount) 
    {
        this.maxAmount = maxAmount;
    }

    public Long getMaxAmount() 
    {
        return maxAmount;
    }
    public void setFixAmount(String fixAmount) 
    {
        this.fixAmount = fixAmount;
    }

    public String getFixAmount() 
    {
        return fixAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("channelName", getChannelName())
            .append("channelCode", getChannelCode())
            .append("merchantCode", getMerchantCode())
            .append("payTypeNo", getPayTypeNo())
            .append("channelNo", getChannelNo())
            .append("weight", getWeight())
            .append("isEnable", getIsEnable())
            .append("isFix", getIsFix())
            .append("minAmount", getMinAmount())
            .append("maxAmount", getMaxAmount())
            .append("fixAmount", getFixAmount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
