package com.ruoyi.audit.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户钱包对象 t_wallet_player_data
 * 
 * @author xxk
 * @date 2022-05-08
 */
public class WalletPlayerData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id（玩家id） */
    private String id;

    /** usdt余额 */
    @Excel(name = "usdt余额")
    private Long usdtAmount;

    /** trx余额 */
    @Excel(name = "trx余额")
    private Long trxAmount;

    /** Usdt的hash地址 */
    @Excel(name = "Usdt的hash地址")
    private String hashAddressUsdt;

    /** Trx的hash地址 */
    @Excel(name = "Trx的hash地址")
    private String hashAddressTrx;

    /** 总充值金额 */
    @Excel(name = "总充值金额")
    private Long rechargeTotal;

    /** 总提现金额 */
    @Excel(name = "总提现金额")
    private Long withdrawTotal;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUsdtAmount(Long usdtAmount) 
    {
        this.usdtAmount = usdtAmount;
    }

    public Long getUsdtAmount() 
    {
        return usdtAmount;
    }
    public void setTrxAmount(Long trxAmount) 
    {
        this.trxAmount = trxAmount;
    }

    public Long getTrxAmount() 
    {
        return trxAmount;
    }
    public void setHashAddressUsdt(String hashAddressUsdt) 
    {
        this.hashAddressUsdt = hashAddressUsdt;
    }

    public String getHashAddressUsdt() 
    {
        return hashAddressUsdt;
    }
    public void setHashAddressTrx(String hashAddressTrx) 
    {
        this.hashAddressTrx = hashAddressTrx;
    }

    public String getHashAddressTrx() 
    {
        return hashAddressTrx;
    }
    public void setRechargeTotal(Long rechargeTotal) 
    {
        this.rechargeTotal = rechargeTotal;
    }

    public Long getRechargeTotal() 
    {
        return rechargeTotal;
    }
    public void setWithdrawTotal(Long withdrawTotal) 
    {
        this.withdrawTotal = withdrawTotal;
    }

    public Long getWithdrawTotal() 
    {
        return withdrawTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usdtAmount", getUsdtAmount())
            .append("trxAmount", getTrxAmount())
            .append("hashAddressUsdt", getHashAddressUsdt())
            .append("hashAddressTrx", getHashAddressTrx())
            .append("rechargeTotal", getRechargeTotal())
            .append("withdrawTotal", getWithdrawTotal())
            .toString();
    }
}
