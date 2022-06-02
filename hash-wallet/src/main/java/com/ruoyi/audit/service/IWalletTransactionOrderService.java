package com.ruoyi.audit.service;

import java.util.List;
import com.ruoyi.audit.domain.WalletTransactionOrder;

/**
 * 转换订单Service接口
 * 
 * @author xxk
 * @date 2022-05-26
 */
public interface IWalletTransactionOrderService 
{
    /**
     * 查询转换订单
     * 
     * @param id 转换订单主键
     * @return 转换订单
     */
    public WalletTransactionOrder selectWalletTransactionOrderById(String id);

    /**
     * 查询转换订单列表
     * 
     * @param walletTransactionOrder 转换订单
     * @return 转换订单集合
     */
    public List<WalletTransactionOrder> selectWalletTransactionOrderList(WalletTransactionOrder walletTransactionOrder);

    /**
     * 新增转换订单
     * 
     * @param walletTransactionOrder 转换订单
     * @return 结果
     */
    public int insertWalletTransactionOrder(WalletTransactionOrder walletTransactionOrder);

    /**
     * 修改转换订单
     * 
     * @param walletTransactionOrder 转换订单
     * @return 结果
     */
    public int updateWalletTransactionOrder(WalletTransactionOrder walletTransactionOrder);

    /**
     * 批量删除转换订单
     * 
     * @param ids 需要删除的转换订单主键集合
     * @return 结果
     */
    public int deleteWalletTransactionOrderByIds(String[] ids);

    /**
     * 删除转换订单信息
     * 
     * @param id 转换订单主键
     * @return 结果
     */
    public int deleteWalletTransactionOrderById(String id);
}
