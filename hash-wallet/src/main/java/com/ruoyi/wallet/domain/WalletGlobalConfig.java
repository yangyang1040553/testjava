package com.ruoyi.wallet.domain;

import com.alibaba.fastjson.JSONObject;
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
public class WalletGlobalConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Excel(name = "id")
    private String id;

    /**
     * 商户号
     */
    @Excel(name = "商户号")
    private String merchantNo;

    /**
     * 公钥
     */
    @Excel(name = "公钥")
    private String publicKey;

    /**
     * 私钥
     */
    @Excel(name = "私钥")
    private String privateKey;

    /**
     * trx转usdt比例
     */
    @Excel(name = "trx转usdt比例")
    private String trxTransUsdtScale;

    private JSONObject trxToUsdt;

    /**
     * usdt转trx比例
     */
    @Excel(name = "usdt转trx比例")
    private String usdtTransTrxScale;

    private JSONObject usdtToTrx;

    /**
     * 矿工费比例
     */
    @Excel(name = "矿工费比例")
    private Double minerScala;


    @Excel(name = "usdt免审核金额")
    private  Double usdt_free_check;
    @Excel(name = "trx免审核金额")
    private  Double trx_free_check;

    @Excel(name = "提现手续费比例")
    private  String tax_scala;

    public String getTax_scala() {
        return tax_scala;
    }

    public void setTax_scala(String tax_scala) {
        this.tax_scala = tax_scala;
    }

    public Double getUsdt_free_check() {
        return usdt_free_check;
    }

    public void setUsdt_free_check(Double usdt_free_check) {
        this.usdt_free_check = usdt_free_check;
    }

    public Double getTrx_free_check() {
        return trx_free_check;
    }

    public void setTrx_free_check(Double trx_free_check) {
        this.trx_free_check = trx_free_check;
    }

    public JSONObject getTrxToUsdt() {
        return JSONObject.parseObject(trxTransUsdtScale);
    }

    public void setTrxToUsdt(JSONObject trxToUsdt) {
        this.trxToUsdt = trxToUsdt;
    }

    public JSONObject getUsdtToTrx() {
        return JSONObject.parseObject(usdtTransTrxScale);
    }

    public void setUsdtToTrx(JSONObject usdtToTrx) {
        this.usdtToTrx = usdtToTrx;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setTrxTransUsdtScale(String trxTransUsdtScale) {
        this.trxTransUsdtScale = trxTransUsdtScale;
    }

    public String getTrxTransUsdtScale() {
        return trxTransUsdtScale;
    }

    public void setUsdtTransTrxScale(String usdtTransTrxScale) {
        this.usdtTransTrxScale = usdtTransTrxScale;
    }

    public String getUsdtTransTrxScale() {
        return usdtTransTrxScale;
    }

    public void setMinerScala(Double minerScala) {
        this.minerScala = minerScala;
    }

    public Double getMinerScala() {
        return minerScala;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
