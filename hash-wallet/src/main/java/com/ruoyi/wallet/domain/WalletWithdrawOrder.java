package com.ruoyi.wallet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现审核对象 t_wallet_withdraw_order
 * 
 * @author xxk
 * @date 2022-05-31
 */
public class WalletWithdrawOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    @Excel(name = "订单id")
    private String id;

    /** 钱包类型USDT TRX */
    @Excel(name = "钱包类型USDT TRX")
    private String walletType;

    /** 钱包地址 */
    @Excel(name = "钱包地址")
    private String walletAddress;

    /** 提现的金额 */
    @Excel(name = "提现的金额")
    private Double amount;

    /** 提现状态 */
    @Excel(name = "提现状态")
    private Long status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setWalletType(String walletType) 
    {
        this.walletType = walletType;
    }

    public String getWalletType() 
    {
        return walletType;
    }
    public void setWalletAddress(String walletAddress) 
    {
        this.walletAddress = walletAddress;
    }

    public String getWalletAddress() 
    {
        return walletAddress;
    }
    public void setAmount(Double amount) 
    {
        this.amount = amount;
    }

    public Double getAmount() 
    {
        return amount;
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
            .append("walletType", getWalletType())
            .append("walletAddress", getWalletAddress())
            .append("amount", getAmount())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
