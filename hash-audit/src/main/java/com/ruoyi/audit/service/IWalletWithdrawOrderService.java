package com.ruoyi.audit.service;

import java.util.List;
import com.ruoyi.audit.domain.WalletWithdrawOrder;

/**
 * 提现审核Service接口
 * 
 * @author xxk
 * @date 2022-06-02
 */
public interface IWalletWithdrawOrderService 
{
    /**
     * 查询提现审核
     * 
     * @param id 提现审核主键
     * @return 提现审核
     */
    public WalletWithdrawOrder selectWalletWithdrawOrderById(String id);

    /**
     * 查询提现审核列表
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 提现审核集合
     */
    public List<WalletWithdrawOrder> selectWalletWithdrawOrderList(WalletWithdrawOrder walletWithdrawOrder);

    /**
     * 新增提现审核
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    public int insertWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder);

    /**
     * 修改提现审核
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    public int updateWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder);

    /**
     * 批量删除提现审核
     * 
     * @param ids 需要删除的提现审核主键集合
     * @return 结果
     */
    public int deleteWalletWithdrawOrderByIds(String[] ids);

    /**
     * 删除提现审核信息
     * 
     * @param id 提现审核主键
     * @return 结果
     */
    public int deleteWalletWithdrawOrderById(String id);

    List<WalletWithdrawOrder> selectCurrDay();
}
