package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.WalletRechargeOrderMapper;
import com.ruoyi.wallet.domain.WalletRechargeOrder;
import com.ruoyi.wallet.service.IWalletRechargeOrderService;

/**
 * 充值Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-17
 */
@Service
public class WalletRechargeOrderServiceImpl implements IWalletRechargeOrderService 
{
    @Autowired
    private WalletRechargeOrderMapper walletRechargeOrderMapper;

    /**
     * 查询充值
     * 
     * @param id 充值主键
     * @return 充值
     */
    @Override
    public WalletRechargeOrder selectWalletRechargeOrderById(String id)
    {
        return walletRechargeOrderMapper.selectWalletRechargeOrderById(id);
    }

    /**
     * 查询充值列表
     * 
     * @param walletRechargeOrder 充值
     * @return 充值
     */
    @Override
    public List<WalletRechargeOrder> selectWalletRechargeOrderList(WalletRechargeOrder walletRechargeOrder)
    {
        return walletRechargeOrderMapper.selectWalletRechargeOrderList(walletRechargeOrder);
    }

    /**
     * 新增充值
     * 
     * @param walletRechargeOrder 充值
     * @return 结果
     */
    @Override
    public int insertWalletRechargeOrder(WalletRechargeOrder walletRechargeOrder)
    {
        walletRechargeOrder.setCreateTime(DateUtils.getNowDate());
        return walletRechargeOrderMapper.insertWalletRechargeOrder(walletRechargeOrder);
    }

    /**
     * 修改充值
     * 
     * @param walletRechargeOrder 充值
     * @return 结果
     */
    @Override
    public int updateWalletRechargeOrder(WalletRechargeOrder walletRechargeOrder)
    {
        walletRechargeOrder.setUpdateTime(DateUtils.getNowDate());
        return walletRechargeOrderMapper.updateWalletRechargeOrder(walletRechargeOrder);
    }

    /**
     * 批量删除充值
     * 
     * @param ids 需要删除的充值主键
     * @return 结果
     */
    @Override
    public int deleteWalletRechargeOrderByIds(String[] ids)
    {
        return walletRechargeOrderMapper.deleteWalletRechargeOrderByIds(ids);
    }

    /**
     * 删除充值信息
     * 
     * @param id 充值主键
     * @return 结果
     */
    @Override
    public int deleteWalletRechargeOrderById(String id)
    {
        return walletRechargeOrderMapper.deleteWalletRechargeOrderById(id);
    }
}
