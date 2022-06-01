package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.WalletWithdrawOrderMapper;
import com.ruoyi.wallet.domain.WalletWithdrawOrder;
import com.ruoyi.wallet.service.IWalletWithdrawOrderService;

/**
 * 提现审核Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-31
 */
@Service
public class WalletWithdrawOrderServiceImpl implements IWalletWithdrawOrderService 
{
    @Autowired
    private WalletWithdrawOrderMapper walletWithdrawOrderMapper;

    /**
     * 查询提现审核
     * 
     * @param id 提现审核主键
     * @return 提现审核
     */
    @Override
    public WalletWithdrawOrder selectWalletWithdrawOrderById(String id)
    {
        return walletWithdrawOrderMapper.selectWalletWithdrawOrderById(id);
    }

    /**
     * 查询提现审核列表
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 提现审核
     */
    @Override
    public List<WalletWithdrawOrder> selectWalletWithdrawOrderList(WalletWithdrawOrder walletWithdrawOrder)
    {
        return walletWithdrawOrderMapper.selectWalletWithdrawOrderList(walletWithdrawOrder);
    }

    /**
     * 新增提现审核
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    @Override
    public int insertWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder)
    {
        walletWithdrawOrder.setCreateTime(DateUtils.getNowDate());
        return walletWithdrawOrderMapper.insertWalletWithdrawOrder(walletWithdrawOrder);
    }

    /**
     * 修改提现审核
     * 
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    @Override
    public int updateWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder)
    {
        walletWithdrawOrder.setUpdateTime(DateUtils.getNowDate());
        return walletWithdrawOrderMapper.updateWalletWithdrawOrder(walletWithdrawOrder);
    }

    /**
     * 批量删除提现审核
     * 
     * @param ids 需要删除的提现审核主键
     * @return 结果
     */
    @Override
    public int deleteWalletWithdrawOrderByIds(String[] ids)
    {
        return walletWithdrawOrderMapper.deleteWalletWithdrawOrderByIds(ids);
    }

    /**
     * 删除提现审核信息
     * 
     * @param id 提现审核主键
     * @return 结果
     */
    @Override
    public int deleteWalletWithdrawOrderById(String id)
    {
        return walletWithdrawOrderMapper.deleteWalletWithdrawOrderById(id);
    }
}
