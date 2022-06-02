package com.ruoyi.audit.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.audit.mapper.WalletPlayerDataMapper;
import com.ruoyi.audit.domain.WalletPlayerData;
import com.ruoyi.audit.service.IWalletPlayerDataService;

/**
 * 用户钱包Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-08
 */
@Service
public class WalletPlayerDataServiceImpl implements IWalletPlayerDataService 
{
    @Autowired
    private WalletPlayerDataMapper walletPlayerDataMapper;

    /**
     * 查询用户钱包
     * 
     * @param id 用户钱包主键
     * @return 用户钱包
     */
    @Override
    public WalletPlayerData selectWalletPlayerDataById(String id)
    {
        return walletPlayerDataMapper.selectWalletPlayerDataById(id);
    }

    /**
     * 查询用户钱包列表
     * 
     * @param walletPlayerData 用户钱包
     * @return 用户钱包
     */
    @Override
    public List<WalletPlayerData> selectWalletPlayerDataList(WalletPlayerData walletPlayerData)
    {
        return walletPlayerDataMapper.selectWalletPlayerDataList(walletPlayerData);
    }

    /**
     * 新增用户钱包
     * 
     * @param walletPlayerData 用户钱包
     * @return 结果
     */
    @Override
    public int insertWalletPlayerData(WalletPlayerData walletPlayerData)
    {
        return walletPlayerDataMapper.insertWalletPlayerData(walletPlayerData);
    }

    /**
     * 修改用户钱包
     * 
     * @param walletPlayerData 用户钱包
     * @return 结果
     */
    @Override
    public int updateWalletPlayerData(WalletPlayerData walletPlayerData)
    {
        return walletPlayerDataMapper.updateWalletPlayerData(walletPlayerData);
    }

    /**
     * 批量删除用户钱包
     * 
     * @param ids 需要删除的用户钱包主键
     * @return 结果
     */
    @Override
    public int deleteWalletPlayerDataByIds(String[] ids)
    {
        return walletPlayerDataMapper.deleteWalletPlayerDataByIds(ids);
    }

    /**
     * 删除用户钱包信息
     * 
     * @param id 用户钱包主键
     * @return 结果
     */
    @Override
    public int deleteWalletPlayerDataById(String id)
    {
        return walletPlayerDataMapper.deleteWalletPlayerDataById(id);
    }
}
