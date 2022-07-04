package com.ruoyi.statistical.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.constant.Global;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 留存分析对象 keep
 *
 * @author xxk
 * @date 2022-05-27
 */
public class Index extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String register_count;
    private String recharge_count;
    private String bet_count;
    private String bet_persion_count;
    private Double curr_trx_win_amount;
    private String curr_trx_win_rate;
    private Double curr_usdt_win_amount;
    private String curr_usdt_win_rate;
    private Double pre_trx_win_amount;
    private String pre_trx_win_rate;
    private Double pre_usdt_win_amount;
    private String pre_usdt_win_rate;

    private Double usdt_win_amount;
    private Double trx_win_amount;
    private String game_id;

    private Double minTrx;
    private Double minUsdt;
    private Double maxTrx;
    private Double maxUsdt;
    private String minTrxGameId;
    private String minUsdtGameId;
    private String maxTrxGameId;
    private String maxUsdtGameId;


    public Double getMinTrx() {
        return Global.getWalletAmountToReal(minTrx);
    }

    public void setMinTrx(Double minTrx) {
        this.minTrx = minTrx;
    }

    public Double getMinUsdt() {
        return Global.getWalletAmountToReal(minUsdt);
    }

    public void setMinUsdt(Double minUsdt) {
        this.minUsdt = minUsdt;
    }

    public Double getMaxTrx() {
        return Global.getWalletAmountToReal(maxTrx);
    }

    public void setMaxTrx(Double maxTrx) {
        this.maxTrx = maxTrx;
    }

    public Double getMaxUsdt() {
        return Global.getWalletAmountToReal(maxUsdt);
    }

    public void setMaxUsdt(Double maxUsdt) {
        this.maxUsdt = maxUsdt;
    }

    public String getMinTrxGameId() {
        return minTrxGameId;
    }

    public void setMinTrxGameId(String minTrxGameId) {
        this.minTrxGameId = minTrxGameId;
    }

    public String getMinUsdtGameId() {
        return minUsdtGameId;
    }

    public void setMinUsdtGameId(String minUsdtGameId) {
        this.minUsdtGameId = minUsdtGameId;
    }

    public String getMaxTrxGameId() {
        return maxTrxGameId;
    }

    public void setMaxTrxGameId(String maxTrxGameId) {
        this.maxTrxGameId = maxTrxGameId;
    }

    public String getMaxUsdtGameId() {
        return maxUsdtGameId;
    }

    public void setMaxUsdtGameId(String maxUsdtGameId) {
        this.maxUsdtGameId = maxUsdtGameId;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public Double getUsdt_win_amount() {
        return usdt_win_amount;
    }

    public void setUsdt_win_amount(Double usdt_win_amount) {
        this.usdt_win_amount = usdt_win_amount;
    }

    public Double getTrx_win_amount() {
        return trx_win_amount;
    }

    public void setTrx_win_amount(Double trx_win_amount) {
        this.trx_win_amount = trx_win_amount;
    }

    public String getRegister_count() {
        return register_count;
    }

    public void setRegister_count(String register_count) {
        this.register_count = register_count;
    }

    public String getRecharge_count() {
        return recharge_count;
    }

    public void setRecharge_count(String recharge_count) {
        this.recharge_count = recharge_count;
    }

    public String getBet_count() {
        return bet_count;
    }

    public void setBet_count(String bet_count) {
        this.bet_count = bet_count;
    }

    public String getBet_persion_count() {
        return bet_persion_count;
    }

    public void setBet_persion_count(String bet_persion_count) {
        this.bet_persion_count = bet_persion_count;
    }

    public Double getCurr_trx_win_amount() {
        return Global.getWalletAmountToReal(curr_trx_win_amount);
    }

    public void setCurr_trx_win_amount(Double curr_trx_win_amount) {
        this.curr_trx_win_amount = curr_trx_win_amount;
    }

    public String getCurr_trx_win_rate() {
        return curr_trx_win_rate;
    }

    public void setCurr_trx_win_rate(String curr_trx_win_rate) {
        this.curr_trx_win_rate = curr_trx_win_rate;
    }

    public Double getCurr_usdt_win_amount() {
        return Global.getWalletAmountToReal(curr_usdt_win_amount);
    }

    public void setCurr_usdt_win_amount(Double curr_usdt_win_amount) {
        this.curr_usdt_win_amount = curr_usdt_win_amount;
    }

    public String getCurr_usdt_win_rate() {
        return curr_usdt_win_rate;
    }

    public void setCurr_usdt_win_rate(String curr_usdt_win_rate) {
        this.curr_usdt_win_rate = curr_usdt_win_rate;
    }

    public Double getPre_trx_win_amount() {
        return Global.getWalletAmountToReal(pre_trx_win_amount);
    }

    public void setPre_trx_win_amount(Double pre_trx_win_amount) {
        this.pre_trx_win_amount = pre_trx_win_amount;
    }

    public String getPre_trx_win_rate() {
        return pre_trx_win_rate;
    }

    public void setPre_trx_win_rate(String pre_trx_win_rate) {
        this.pre_trx_win_rate = pre_trx_win_rate;
    }

    public Double getPre_usdt_win_amount() {
        return Global.getWalletAmountToReal(pre_usdt_win_amount);
    }

    public void setPre_usdt_win_amount(Double pre_usdt_win_amount) {
        this.pre_usdt_win_amount = pre_usdt_win_amount;
    }

    public String getPre_usdt_win_rate() {
        return pre_usdt_win_rate;
    }

    public void setPre_usdt_win_rate(String pre_usdt_win_rate) {
        this.pre_usdt_win_rate = pre_usdt_win_rate;
    }
}
