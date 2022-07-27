package com.ruoyi.statistical.domain;

import com.ruoyi.common.constant.Global;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留存分析对象 keep
 *
 * @author xxk
 * @date 2022-05-27
 */
public class IndexAmount extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String recharge_count;
    private Double usdt_paymount;
    private Double trx_paymount;
    private String recharge_order_count;
    private Double usdt_to_mount;
    private Double trx_to_mount;
    private String transaction_count;
    private String transaction_people_count;
    private Double in_usdt_amount;
    private Double out_usdt_amount;
    private Double usdt_out_amount;
    private Double trx_out_amount;
    private String out_pay_count;
    private String out_pay_people_count;
    private String in_count_by_people;
    private String out_count_by_people;
    private String in_people_count;
    private String out_people_count;

    private Double in_trx_amount;
    private Double out_trx_amount;

    public Double getIn_usdt_amount() {
        return Global.getWalletAmountToReal(in_usdt_amount);
    }

    public void setIn_usdt_amount(Double in_usdt_amount) {
        this.in_usdt_amount = in_usdt_amount;
    }

    public Double getOut_usdt_amount() {
        return Global.getWalletAmountToReal(out_usdt_amount);
    }

    public void setOut_usdt_amount(Double out_usdt_amount) {
        this.out_usdt_amount = out_usdt_amount;
    }

    public Double getIn_trx_amount() {
        return Global.getWalletAmountToReal(in_trx_amount);
    }

    public void setIn_trx_amount(Double in_trx_amount) {
        this.in_trx_amount = in_trx_amount;
    }

    public Double getOut_trx_amount() {
        return Global.getWalletAmountToReal(out_trx_amount);
    }

    public void setOut_trx_amount(Double out_trx_amount) {
        this.out_trx_amount = out_trx_amount;
    }

    public Double getUsdt_paymount() {
        return Global.getWalletAmountToReal(usdt_paymount);
    }

    public void setUsdt_paymount(Double usdt_paymount) {
        this.usdt_paymount = usdt_paymount;
    }

    public Double getTrx_paymount() {
        return Global.getWalletAmountToReal(trx_paymount);
    }

    public void setTrx_paymount(Double trx_paymount) {
        this.trx_paymount = trx_paymount;
    }

    public String getRecharge_order_count() {
        return recharge_order_count;
    }

    public void setRecharge_order_count(String recharge_order_count) {
        this.recharge_order_count = recharge_order_count;
    }

    public Double getUsdt_to_mount() {
        return Global.getWalletAmountToReal(usdt_to_mount);
    }

    public void setUsdt_to_mount(Double usdt_to_mount) {
        this.usdt_to_mount = usdt_to_mount;
    }

    public Double getTrx_to_mount() {
        return Global.getWalletAmountToReal(trx_to_mount);
    }

    public void setTrx_to_mount(Double trx_to_mount) {
        this.trx_to_mount = trx_to_mount;
    }

    public String getTransaction_count() {
        return transaction_count;
    }

    public void setTransaction_count(String transaction_count) {
        this.transaction_count = transaction_count;
    }

    public String getTransaction_people_count() {
        return transaction_people_count;
    }

    public void setTransaction_people_count(String transaction_people_count) {
        this.transaction_people_count = transaction_people_count;
    }

    public Double getUsdt_out_amount() {
        return Global.getWalletAmountToReal(usdt_out_amount);
    }

    public void setUsdt_out_amount(Double usdt_out_amount) {
        this.usdt_out_amount = usdt_out_amount;
    }

    public Double getTrx_out_amount() {
        return Global.getWalletAmountToReal(trx_out_amount);
    }

    public void setTrx_out_amount(Double trx_out_amount) {
        this.trx_out_amount = trx_out_amount;
    }

    public String getOut_pay_count() {
        return out_pay_count;
    }

    public void setOut_pay_count(String out_pay_count) {
        this.out_pay_count = out_pay_count;
    }

    public String getOut_pay_people_count() {
        return out_pay_people_count;
    }

    public void setOut_pay_people_count(String out_pay_people_count) {
        this.out_pay_people_count = out_pay_people_count;
    }

    public String getIn_count_by_people() {
        return in_count_by_people;
    }

    public void setIn_count_by_people(String in_count_by_people) {
        this.in_count_by_people = in_count_by_people;
    }

    public String getOut_count_by_people() {
        return out_count_by_people;
    }

    public void setOut_count_by_people(String out_count_by_people) {
        this.out_count_by_people = out_count_by_people;
    }

    public String getIn_people_count() {
        return in_people_count;
    }

    public void setIn_people_count(String in_people_count) {
        this.in_people_count = in_people_count;
    }

    public String getOut_people_count() {
        return out_people_count;
    }

    public void setOut_people_count(String out_people_count) {
        this.out_people_count = out_people_count;
    }

    public String getRecharge_count() {
        return recharge_count;
    }

    public void setRecharge_count(String recharge_count) {
        this.recharge_count = recharge_count;
    }
}
