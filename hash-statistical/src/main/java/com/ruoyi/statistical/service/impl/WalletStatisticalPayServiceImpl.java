package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.WalletStatisticalPayMapper;
import com.ruoyi.statistical.domain.WalletStatisticalPay;
import com.ruoyi.statistical.service.IWalletStatisticalPayService;

/**
 * 钱包日支付统计Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-24
 */
@Service
public class WalletStatisticalPayServiceImpl implements IWalletStatisticalPayService 
{
    @Autowired
    private WalletStatisticalPayMapper walletStatisticalPayMapper;

    /**
     * 查询钱包日支付统计
     * 
     * @param id 钱包日支付统计主键
     * @return 钱包日支付统计
     */
    @Override
    public WalletStatisticalPay selectWalletStatisticalPayById(String id)
    {
        return walletStatisticalPayMapper.selectWalletStatisticalPayById(id);
    }

    /**
     * 查询钱包日支付统计列表
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 钱包日支付统计
     */
    @Override
    public List<WalletStatisticalPay> selectWalletStatisticalPayList(WalletStatisticalPay walletStatisticalPay)
    {
        return walletStatisticalPayMapper.selectWalletStatisticalPayList(walletStatisticalPay);
    }

    /**
     * 新增钱包日支付统计
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 结果
     */
    @Override
    public int insertWalletStatisticalPay(WalletStatisticalPay walletStatisticalPay)
    {
        return walletStatisticalPayMapper.insertWalletStatisticalPay(walletStatisticalPay);
    }

    /**
     * 修改钱包日支付统计
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 结果
     */
    @Override
    public int updateWalletStatisticalPay(WalletStatisticalPay walletStatisticalPay)
    {
        return walletStatisticalPayMapper.updateWalletStatisticalPay(walletStatisticalPay);
    }

    /**
     * 批量删除钱包日支付统计
     * 
     * @param ids 需要删除的钱包日支付统计主键
     * @return 结果
     */
    @Override
    public int deleteWalletStatisticalPayByIds(String[] ids)
    {
        return walletStatisticalPayMapper.deleteWalletStatisticalPayByIds(ids);
    }

    /**
     * 删除钱包日支付统计信息
     * 
     * @param id 钱包日支付统计主键
     * @return 结果
     */
    @Override
    public int deleteWalletStatisticalPayById(String id)
    {
        return walletStatisticalPayMapper.deleteWalletStatisticalPayById(id);
    }
}
