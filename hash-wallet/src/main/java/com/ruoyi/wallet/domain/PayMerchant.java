package com.ruoyi.wallet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 支付商户配置对象 t_pay_merchant
 * 
 * @author xxk
 * @date 2022-07-29
 */
public class PayMerchant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 商户名 */
    @Excel(name = "商户名")
    private String merchantName;

    /** 商户号 */
    @Excel(name = "商户号")
    private String merchantCode;

    /** 商户密钥 */
    @Excel(name = "商户密钥")
    private String appKey;

    /** 回调通知地址 */
    @Excel(name = "回调通知地址")
    private String notifyUrl;

    /** 接口请求地址 */
    @Excel(name = "接口请求地址")
    private String apiUrl;

    /** IP白名单地址 */
    @Excel(name = "IP白名单地址")
    private String ipWhiteList;

    /** 超时时间 */
    @Excel(name = "超时时间")
    private Long timeout;

    /** 状态, 1:启用, 2:禁用 */
    @Excel(name = "状态, 1:启用, 2:禁用")
    private Long isEnable;

    @Excel(name = "接口查询地址")
    String query_url;

    @Excel(name = "商户ID")
    String merchant_no;

    public String getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(String merchant_no) {
        this.merchant_no = merchant_no;
    }

    public String getQuery_url() {
        return query_url;
    }

    public void setQuery_url(String query_url) {
        this.query_url = query_url;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMerchantName(String merchantName) 
    {
        this.merchantName = merchantName;
    }

    public String getMerchantName() 
    {
        return merchantName;
    }
    public void setMerchantCode(String merchantCode) 
    {
        this.merchantCode = merchantCode;
    }

    public String getMerchantCode() 
    {
        return merchantCode;
    }
    public void setAppKey(String appKey) 
    {
        this.appKey = appKey;
    }

    public String getAppKey() 
    {
        return appKey;
    }
    public void setNotifyUrl(String notifyUrl) 
    {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() 
    {
        return notifyUrl;
    }
    public void setApiUrl(String apiUrl) 
    {
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() 
    {
        return apiUrl;
    }
    public void setIpWhiteList(String ipWhiteList) 
    {
        this.ipWhiteList = ipWhiteList;
    }

    public String getIpWhiteList() 
    {
        return ipWhiteList;
    }
    public void setTimeout(Long timeout) 
    {
        this.timeout = timeout;
    }

    public Long getTimeout() 
    {
        return timeout;
    }
    public void setIsEnable(Long isEnable) 
    {
        this.isEnable = isEnable;
    }

    public Long getIsEnable() 
    {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("merchantName", getMerchantName())
            .append("merchantCode", getMerchantCode())
            .append("appKey", getAppKey())
            .append("notifyUrl", getNotifyUrl())
            .append("apiUrl", getApiUrl())
            .append("ipWhiteList", getIpWhiteList())
            .append("timeout", getTimeout())
            .append("isEnable", getIsEnable())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
