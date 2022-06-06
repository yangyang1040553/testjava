package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.WalletTurnoverMapper;
import com.ruoyi.wallet.domain.WalletTurnover;
import com.ruoyi.wallet.service.IWalletTurnoverService;

/**
 * 钱包流水记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-06
 */
@Service
public class WalletTurnoverServiceImpl implements IWalletTurnoverService 
{
    @Autowired
    private WalletTurnoverMapper walletTurnoverMapper;

    /**
     * 查询钱包流水记录
     * 
     * @param id 钱包流水记录主键
     * @return 钱包流水记录
     */
    @Override
    public WalletTurnover selectWalletTurnoverById(String id)
    {
        return walletTurnoverMapper.selectWalletTurnoverById(id);
    }

    /**
     * 查询钱包流水记录列表
     * 
     * @param walletTurnover 钱包流水记录
     * @return 钱包流水记录
     */
    @Override
    public List<WalletTurnover> selectWalletTurnoverList(WalletTurnover walletTurnover)
    {
        return walletTurnoverMapper.selectWalletTurnoverList(walletTurnover);
    }

    /**
     * 新增钱包流水记录
     * 
     * @param walletTurnover 钱包流水记录
     * @return 结果
     */
    @Override
    public int insertWalletTurnover(WalletTurnover walletTurnover)
    {
        walletTurnover.setCreateTime(DateUtils.getNowDate());
        return walletTurnoverMapper.insertWalletTurnover(walletTurnover);
    }

    /**
     * 修改钱包流水记录
     * 
     * @param walletTurnover 钱包流水记录
     * @return 结果
     */
    @Override
    public int updateWalletTurnover(WalletTurnover walletTurnover)
    {
        return walletTurnoverMapper.updateWalletTurnover(walletTurnover);
    }

    /**
     * 批量删除钱包流水记录
     * 
     * @param ids 需要删除的钱包流水记录主键
     * @return 结果
     */
    @Override
    public int deleteWalletTurnoverByIds(String[] ids)
    {
        return walletTurnoverMapper.deleteWalletTurnoverByIds(ids);
    }

    /**
     * 删除钱包流水记录信息
     * 
     * @param id 钱包流水记录主键
     * @return 结果
     */
    @Override
    public int deleteWalletTurnoverById(String id)
    {
        return walletTurnoverMapper.deleteWalletTurnoverById(id);
    }
}
