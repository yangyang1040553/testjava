package com.ruoyi.wallet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 钱包全局配置对象 t_wallet_global_config
 * 
 * @author xxk
 * @date 2022-05-24
 */
public class WalletGlobalConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private String id;

    /** 商户号 */
    @Excel(name = "商户号")
    private String merchantNo;

    /** 公钥 */
    @Excel(name = "公钥")
    private String publicKey;

    /** 私钥 */
    @Excel(name = "私钥")
    private String privateKey;

    /** trx转usdt比例 */
    @Excel(name = "trx转usdt比例")
    private String trxTransUsdtScale;

    /** usdt转trx比例 */
    @Excel(name = "usdt转trx比例")
    private String usdtTransTrxScale;

    /** 矿工费比例 */
    @Excel(name = "矿工费比例")
    private Double minerScala;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMerchantNo(String merchantNo) 
    {
        this.merchantNo = merchantNo;
    }

    public String getMerchantNo() 
    {
        return merchantNo;
    }
    public void setPublicKey(String publicKey) 
    {
        this.publicKey = publicKey;
    }

    public String getPublicKey() 
    {
        return publicKey;
    }
    public void setPrivateKey(String privateKey) 
    {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() 
    {
        return privateKey;
    }
    public void setTrxTransUsdtScale(String trxTransUsdtScale) 
    {
        this.trxTransUsdtScale = trxTransUsdtScale;
    }

    public String getTrxTransUsdtScale() 
    {
        return trxTransUsdtScale;
    }
    public void setUsdtTransTrxScale(String usdtTransTrxScale) 
    {
        this.usdtTransTrxScale = usdtTransTrxScale;
    }

    public String getUsdtTransTrxScale() 
    {
        return usdtTransTrxScale;
    }
    public void setMinerScala(Double minerScala)
    {
        this.minerScala = minerScala;
    }

    public Double getMinerScala()
    {
        return minerScala;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("merchantNo", getMerchantNo())
            .append("publicKey", getPublicKey())
            .append("privateKey", getPrivateKey())
            .append("trxTransUsdtScale", getTrxTransUsdtScale())
            .append("usdtTransTrxScale", getUsdtTransTrxScale())
            .append("minerScala", getMinerScala())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
