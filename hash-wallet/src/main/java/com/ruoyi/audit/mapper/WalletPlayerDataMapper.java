package com.ruoyi.audit.mapper;

import java.util.List;
import com.ruoyi.audit.domain.WalletPlayerData;

/**
 * 用户钱包Mapper接口
 * 
 * @author xxk
 * @date 2022-05-08
 */
public interface WalletPlayerDataMapper 
{
    /**
     * 查询用户钱包
     * 
     * @param id 用户钱包主键
     * @return 用户钱包
     */
    public WalletPlayerData selectWalletPlayerDataById(String id);

    /**
     * 查询用户钱包列表
     * 
     * @param walletPlayerData 用户钱包
     * @return 用户钱包集合
     */
    public List<WalletPlayerData> selectWalletPlayerDataList(WalletPlayerData walletPlayerData);

    /**
     * 新增用户钱包
     * 
     * @param walletPlayerData 用户钱包
     * @return 结果
     */
    public int insertWalletPlayerData(WalletPlayerData walletPlayerData);

    /**
     * 修改用户钱包
     * 
     * @param walletPlayerData 用户钱包
     * @return 结果
     */
    public int updateWalletPlayerData(WalletPlayerData walletPlayerData);

    /**
     * 删除用户钱包
     * 
     * @param id 用户钱包主键
     * @return 结果
     */
    public int deleteWalletPlayerDataById(String id);

    /**
     * 批量删除用户钱包
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWalletPlayerDataByIds(String[] ids);
}
