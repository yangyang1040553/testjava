package com.ruoyi.audit.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.audit.mapper.WalletGlobalConfigMapper;
import com.ruoyi.audit.domain.WalletGlobalConfig;
import com.ruoyi.audit.service.IWalletGlobalConfigService;

/**
 * 钱包全局配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-24
 */
@Service
public class WalletGlobalConfigServiceImpl implements IWalletGlobalConfigService 
{
    @Autowired
    private WalletGlobalConfigMapper walletGlobalConfigMapper;

    /**
     * 查询钱包全局配置
     * 
     * @param id 钱包全局配置主键
     * @return 钱包全局配置
     */
    @Override
    public WalletGlobalConfig selectWalletGlobalConfigById(String id)
    {
        return walletGlobalConfigMapper.selectWalletGlobalConfigById(id);
    }

    /**
     * 查询钱包全局配置列表
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 钱包全局配置
     */
    @Override
    public List<WalletGlobalConfig> selectWalletGlobalConfigList(WalletGlobalConfig walletGlobalConfig)
    {
        return walletGlobalConfigMapper.selectWalletGlobalConfigList(walletGlobalConfig);
    }

    /**
     * 新增钱包全局配置
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 结果
     */
    @Override
    public int insertWalletGlobalConfig(WalletGlobalConfig walletGlobalConfig)
    {
        walletGlobalConfig.setId(IdUtils.getID12Str());
        return walletGlobalConfigMapper.insertWalletGlobalConfig(walletGlobalConfig);
    }

    /**
     * 修改钱包全局配置
     * 
     * @param walletGlobalConfig 钱包全局配置
     * @return 结果
     */
    @Override
    public int updateWalletGlobalConfig(WalletGlobalConfig walletGlobalConfig)
    {
        walletGlobalConfig.setUpdateTime(DateUtils.getNowDate());
        return walletGlobalConfigMapper.updateWalletGlobalConfig(walletGlobalConfig);
    }

    /**
     * 批量删除钱包全局配置
     * 
     * @param ids 需要删除的钱包全局配置主键
     * @return 结果
     */
    @Override
    public int deleteWalletGlobalConfigByIds(String[] ids)
    {
        return walletGlobalConfigMapper.deleteWalletGlobalConfigByIds(ids);
    }

    /**
     * 删除钱包全局配置信息
     * 
     * @param id 钱包全局配置主键
     * @return 结果
     */
    @Override
    public int deleteWalletGlobalConfigById(String id)
    {
        return walletGlobalConfigMapper.deleteWalletGlobalConfigById(id);
    }
}
