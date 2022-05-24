package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.WalletGlobalConfig;

/**
 * 钱包全局配置Mapper接口
 * 
 * @author xxk
 * @date 2022-05-24
 */
public interface WalletGlobalConfigMapper 
{
    /**
     * 查询钱包全局配置
     * 
     * @param id 钱包全局配置主键
     * @return 钱包全局配置
     */
    public WalletGlobalConfig selectWalletGlobalConfigById(String id);

    /**
     * 查询钱包全局配置列表
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 钱包全局配置集合
     */
    public List<WalletGlobalConfig> selectWalletGlobalConfigList(WalletGlobalConfig walletGlobalConfig);

    /**
     * 新增钱包全局配置
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 结果
     */
    public int insertWalletGlobalConfig(WalletGlobalConfig walletGlobalConfig);

    /**
     * 修改钱包全局配置
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 结果
     */
    public int updateWalletGlobalConfig(WalletGlobalConfig walletGlobalConfig);

    /**
     * 删除钱包全局配置
     * 
     * @param id 钱包全局配置主键
     * @return 结果
     */
    public int deleteWalletGlobalConfigById(String id);

    /**
     * 批量删除钱包全局配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWalletGlobalConfigByIds(String[] ids);
}
