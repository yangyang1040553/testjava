package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wallet.domain.WalletTransactionOrder;
import com.ruoyi.wallet.mapper.WalletTransactionOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.service.IWalletTransactionOrderService;

/**
 * 转换订单Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-26
 */
@Service
public class WalletTransactionOrderServiceImpl implements IWalletTransactionOrderService 
{
    @Autowired
    private WalletTransactionOrderMapper walletTransactionOrderMapper;

    /**
     * 查询转换订单
     * 
     * @param id 转换订单主键
     * @return 转换订单
     */
    @Override
    public WalletTransactionOrder selectWalletTransactionOrderById(String id)
    {
        return walletTransactionOrderMapper.selectWalletTransactionOrderById(id);
    }

    /**
     * 查询转换订单列表
     * 
     * @param walletTransactionOrder 转换订单
     * @return 转换订单
     */
    @Override
    public List<WalletTransactionOrder> selectWalletTransactionOrderList(WalletTransactionOrder walletTransactionOrder)
    {
        return walletTransactionOrderMapper.selectWalletTransactionOrderList(walletTransactionOrder);
    }

    /**
     * 新增转换订单
     * 
     * @param walletTransactionOrder 转换订单
     * @return 结果
     */
    @Override
    public int insertWalletTransactionOrder(WalletTransactionOrder walletTransactionOrder)
    {
        walletTransactionOrder.setCreateTime(DateUtils.getNowDate());
        return walletTransactionOrderMapper.insertWalletTransactionOrder(walletTransactionOrder);
    }

    /**
     * 修改转换订单
     * 
     * @param walletTransactionOrder 转换订单
     * @return 结果
     */
    @Override
    public int updateWalletTransactionOrder(WalletTransactionOrder walletTransactionOrder)
    {
        walletTransactionOrder.setUpdateTime(DateUtils.getNowDate());
        return walletTransactionOrderMapper.updateWalletTransactionOrder(walletTransactionOrder);
    }

    /**
     * 批量删除转换订单
     * 
     * @param ids 需要删除的转换订单主键
     * @return 结果
     */
    @Override
    public int deleteWalletTransactionOrderByIds(String[] ids)
    {
        return walletTransactionOrderMapper.deleteWalletTransactionOrderByIds(ids);
    }

    /**
     * 删除转换订单信息
     * 
     * @param id 转换订单主键
     * @return 结果
     */
    @Override
    public int deleteWalletTransactionOrderById(String id)
    {
        return walletTransactionOrderMapper.deleteWalletTransactionOrderById(id);
    }
}
