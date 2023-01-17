package com.ruoyi.hashUser.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.WalletVipConfigMapper;
import com.ruoyi.hashUser.domain.WalletVipConfig;
import com.ruoyi.hashUser.service.IWalletVipConfigService;

/**
 * VIP类型配置Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-06
 */
@Service
public class WalletVipConfigServiceImpl implements IWalletVipConfigService 
{
    @Autowired
    private WalletVipConfigMapper walletVipConfigMapper;

    /**
     * 查询VIP类型配置
     * 
     * @param id VIP类型配置主键
     * @return VIP类型配置
     */
    @Override
    public WalletVipConfig selectWalletVipConfigById(Long id)
    {
        return walletVipConfigMapper.selectWalletVipConfigById(id);
    }

    /**
     * 查询VIP类型配置列表
     * 
     * @param walletVipConfig VIP类型配置
     * @return VIP类型配置
     */
    @Override
    public List<WalletVipConfig> selectWalletVipConfigList(WalletVipConfig walletVipConfig)
    {
        return walletVipConfigMapper.selectWalletVipConfigList(walletVipConfig);
    }

    /**
     * 新增VIP类型配置
     * 
     * @param walletVipConfig VIP类型配置
     * @return 结果
     */
    @Override
    public int insertWalletVipConfig(WalletVipConfig walletVipConfig)
    {
        return walletVipConfigMapper.insertWalletVipConfig(walletVipConfig);
    }

    /**
     * 修改VIP类型配置
     * 
     * @param walletVipConfig VIP类型配置
     * @return 结果
     */
    @Override
    public int updateWalletVipConfig(WalletVipConfig walletVipConfig)
    {
        return walletVipConfigMapper.updateWalletVipConfig(walletVipConfig);
    }

    /**
     * 批量删除VIP类型配置
     * 
     * @param ids 需要删除的VIP类型配置主键
     * @return 结果
     */
    @Override
    public int deleteWalletVipConfigByIds(Long[] ids)
    {
        return walletVipConfigMapper.deleteWalletVipConfigByIds(ids);
    }

    /**
     * 删除VIP类型配置信息
     * 
     * @param id VIP类型配置主键
     * @return 结果
     */
    @Override
    public int deleteWalletVipConfigById(Long id)
    {
        return walletVipConfigMapper.deleteWalletVipConfigById(id);
    }
}
