package com.ruoyi.audit.service;

import java.util.List;
import com.ruoyi.audit.domain.WalletGlobalConfig;

/**
 * 钱包全局配置Service接口
 * 
 * @author xxk
 * @date 2022-05-24
 */
public interface IWalletGlobalConfigService 
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
     * 批量删除钱包全局配置
     * 
     * @param ids 需要删除的钱包全局配置主键集合
     * @return 结果
     */
    public int deleteWalletGlobalConfigByIds(String[] ids);

    /**
     * 删除钱包全局配置信息
     * 
     * @param id 钱包全局配置主键
     * @return 结果
     */
    public int deleteWalletGlobalConfigById(String id);
}
