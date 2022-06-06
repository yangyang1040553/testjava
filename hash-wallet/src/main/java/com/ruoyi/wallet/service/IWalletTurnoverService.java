package com.ruoyi.wallet.service;

import java.util.List;
import com.ruoyi.wallet.domain.WalletTurnover;

/**
 * 钱包流水记录Service接口
 * 
 * @author xxk
 * @date 2022-06-06
 */
public interface IWalletTurnoverService 
{
    /**
     * 查询钱包流水记录
     * 
     * @param id 钱包流水记录主键
     * @return 钱包流水记录
     */
    public WalletTurnover selectWalletTurnoverById(String id);

    /**
     * 查询钱包流水记录列表
     * 
     * @param walletTurnover 钱包流水记录
     * @return 钱包流水记录集合
     */
    public List<WalletTurnover> selectWalletTurnoverList(WalletTurnover walletTurnover);

    /**
     * 新增钱包流水记录
     * 
     * @param walletTurnover 钱包流水记录
     * @return 结果
     */
    public int insertWalletTurnover(WalletTurnover walletTurnover);

    /**
     * 修改钱包流水记录
     * 
     * @param walletTurnover 钱包流水记录
     * @return 结果
     */
    public int updateWalletTurnover(WalletTurnover walletTurnover);

    /**
     * 批量删除钱包流水记录
     * 
     * @param ids 需要删除的钱包流水记录主键集合
     * @return 结果
     */
    public int deleteWalletTurnoverByIds(String[] ids);

    /**
     * 删除钱包流水记录信息
     * 
     * @param id 钱包流水记录主键
     * @return 结果
     */
    public int deleteWalletTurnoverById(String id);
}
