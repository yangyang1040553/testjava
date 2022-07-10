package com.ruoyi.wallet.vo;

/**
 * 用户钱包出入款VO
 *
 * @author xxk
 * @date 2022-05-08
 */

public class WalletInOutMoneyVo {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一id（玩家id）
     */
    private String id;

    /***
     * 钱包类型 usdt trx
     */
    public String walletType;

    /***
     * 金额
     */
    public long amount;

    /***
     * 备注说明
     */
    public String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
