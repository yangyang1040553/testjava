package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.WalletStatisticalPay;

/**
 * 钱包日支付统计Mapper接口
 * 
 * @author xxk
 * @date 2022-06-24
 */
public interface WalletStatisticalPayMapper 
{
    /**
     * 查询钱包日支付统计
     * 
     * @param id 钱包日支付统计主键
     * @return 钱包日支付统计
     */
    public WalletStatisticalPay selectWalletStatisticalPayById(String id);

    /**
     * 查询钱包日支付统计列表
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 钱包日支付统计集合
     */
    public List<WalletStatisticalPay> selectWalletStatisticalPayList(WalletStatisticalPay walletStatisticalPay);

    /**
     * 新增钱包日支付统计
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 结果
     */
    public int insertWalletStatisticalPay(WalletStatisticalPay walletStatisticalPay);

    /**
     * 修改钱包日支付统计
     * 
     * @param walletStatisticalPay 钱包日支付统计
     * @return 结果
     */
    public int updateWalletStatisticalPay(WalletStatisticalPay walletStatisticalPay);

    /**
     * 删除钱包日支付统计
     * 
     * @param id 钱包日支付统计主键
     * @return 结果
     */
    public int deleteWalletStatisticalPayById(String id);

    /**
     * 批量删除钱包日支付统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWalletStatisticalPayByIds(String[] ids);
}
