package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留存分析对象 keep
 *
 * @author xxk
 * @date 2022-05-27
 */
public class IndexActive extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer usdt_count;
    private Integer trx_count;
    private Integer usdt_people_count;
    private Integer trx_people_count;
    private Double trx_dl_amount;
    private Double usdt_game_amount;
    private Double trx_game_amount;
    private Double usdt_dl_amount;
    private String trx_back_count;
    private Integer usdt_back_count;
    private Integer usdt_back_people_conut;
    private Integer trx_back_people_conut;
    private Integer usdt_back_dl_count;
    private Integer trx_back_dl_count;
    private Integer usdt_dl_back_people_count;
    private Integer trx_dl_back_people_count;
    private String t_id;
    private String t_type;
    private Double t_amount;
    private String u_id;
    private String u_type;
    private Double u_amount;

    private String a_type;
    private String wallet_type;
    private Double amount;

    private Double usdt_active_amount;
    private Double trx_active_amount;

    public Double getUsdt_active_amount() {
        return Global.getWalletAmountToReal(usdt_active_amount);
    }

    public void setUsdt_active_amount(Double usdt_active_amount) {
        this.usdt_active_amount = usdt_active_amount;
    }

    public Double getTrx_active_amount() {
        return Global.getWalletAmountToReal(trx_active_amount);
    }

    public void setTrx_active_amount(Double trx_active_amount) {
        this.trx_active_amount = trx_active_amount;
    }

    public String getA_type() {
        return a_type;
    }

    public void setA_type(String a_type) {
        this.a_type = a_type;
    }

    public String getWallet_type() {
        return wallet_type;
    }

    public void setWallet_type(String wallet_type) {
        this.wallet_type = wallet_type;
    }

    public Double getAmount() {
        return Global.getWalletAmountToReal(amount);
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTrx_game_amount() {
        return Global.getWalletAmountToReal(trx_game_amount);
    }

    public void setTrx_game_amount(Double trx_game_amount) {
        this.trx_game_amount = trx_game_amount;
    }

    public Integer getUsdt_count() {
        return usdt_count;
    }

    public void setUsdt_count(Integer usdt_count) {
        this.usdt_count = usdt_count;
    }

    public Integer getTrx_count() {
        return trx_count;
    }

    public void setTrx_count(Integer trx_count) {
        this.trx_count = trx_count;
    }

    public Integer getUsdt_people_count() {
        return usdt_people_count;
    }

    public void setUsdt_people_count(Integer usdt_people_count) {
        this.usdt_people_count = usdt_people_count;
    }

    public Integer getTrx_people_count() {
        return trx_people_count;
    }

    public void setTrx_people_count(Integer trx_people_count) {
        this.trx_people_count = trx_people_count;
    }

    public Double getTrx_dl_amount() {
        return Global.getWalletAmountToReal(trx_dl_amount);
    }

    public void setTrx_dl_amount(Double trx_dl_amount) {
        this.trx_dl_amount = trx_dl_amount;
    }

    public Double getUsdt_game_amount() {
        return Global.getWalletAmountToReal(usdt_game_amount);
    }

    public void setUsdt_game_amount(Double usdt_game_amount) {
        this.usdt_game_amount = usdt_game_amount;
    }

    public Double getUsdt_dl_amount() {
        return Global.getWalletAmountToReal(usdt_dl_amount);
    }

    public void setUsdt_dl_amount(Double usdt_dl_amount) {
        this.usdt_dl_amount = usdt_dl_amount;
    }

    public String getTrx_back_count() {
        return trx_back_count;
    }

    public void setTrx_back_count(String trx_back_count) {
        this.trx_back_count = trx_back_count;
    }

    public Integer getUsdt_back_count() {
        return usdt_back_count;
    }

    public void setUsdt_back_count(Integer usdt_back_count) {
        this.usdt_back_count = usdt_back_count;
    }

    public Integer getUsdt_back_people_conut() {
        return usdt_back_people_conut;
    }

    public void setUsdt_back_people_conut(Integer usdt_back_people_conut) {
        this.usdt_back_people_conut = usdt_back_people_conut;
    }

    public Integer getTrx_back_people_conut() {
        return trx_back_people_conut;
    }

    public void setTrx_back_people_conut(Integer trx_back_people_conut) {
        this.trx_back_people_conut = trx_back_people_conut;
    }

    public Integer getUsdt_back_dl_count() {
        return usdt_back_dl_count;
    }

    public void setUsdt_back_dl_count(Integer usdt_back_dl_count) {
        this.usdt_back_dl_count = usdt_back_dl_count;
    }

    public Integer getTrx_back_dl_count() {
        return trx_back_dl_count;
    }

    public void setTrx_back_dl_count(Integer trx_back_dl_count) {
        this.trx_back_dl_count = trx_back_dl_count;
    }

    public Integer getUsdt_dl_back_people_count() {
        return usdt_dl_back_people_count;
    }

    public void setUsdt_dl_back_people_count(Integer usdt_dl_back_people_count) {
        this.usdt_dl_back_people_count = usdt_dl_back_people_count;
    }

    public Integer getTrx_dl_back_people_count() {
        return trx_dl_back_people_count;
    }

    public void setTrx_dl_back_people_count(Integer trx_dl_back_people_count) {
        this.trx_dl_back_people_count = trx_dl_back_people_count;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_type() {
        return t_type;
    }

    public void setT_type(String t_type) {
        this.t_type = t_type;
    }

    public Double getT_amount() {
        return Global.getWalletAmountToReal(t_amount);
    }

    public void setT_amount(Double t_amount) {
        this.t_amount = t_amount;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_type() {
        return u_type;
    }

    public void setU_type(String u_type) {
        this.u_type = u_type;
    }

    public Double getU_amount() {
        return Global.getWalletAmountToReal(u_amount);
    }

    public void setU_amount(Double u_amount) {
        this.u_amount = u_amount;
    }


}
