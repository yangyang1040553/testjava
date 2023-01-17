package com.ruoyi.hashUser.service;

import java.util.List;
import com.ruoyi.hashUser.domain.WalletVipConfig;

/**
 * VIP类型配置Service接口
 * 
 * @author xxk
 * @date 2023-01-06
 */
public interface IWalletVipConfigService 
{
    /**
     * 查询VIP类型配置
     * 
     * @param id VIP类型配置主键
     * @return VIP类型配置
     */
    public WalletVipConfig selectWalletVipConfigById(Long id);

    /**
     * 查询VIP类型配置列表
     * 
     * @param walletVipConfig VIP类型配置
     * @return VIP类型配置集合
     */
    public List<WalletVipConfig> selectWalletVipConfigList(WalletVipConfig walletVipConfig);

    /**
     * 新增VIP类型配置
     * 
     * @param walletVipConfig VIP类型配置
     * @return 结果
     */
    public int insertWalletVipConfig(WalletVipConfig walletVipConfig);

    /**
     * 修改VIP类型配置
     * 
     * @param walletVipConfig VIP类型配置
     * @return 结果
     */
    public int updateWalletVipConfig(WalletVipConfig walletVipConfig);

    /**
     * 批量删除VIP类型配置
     * 
     * @param ids 需要删除的VIP类型配置主键集合
     * @return 结果
     */
    public int deleteWalletVipConfigByIds(Long[] ids);

    /**
     * 删除VIP类型配置信息
     * 
     * @param id VIP类型配置主键
     * @return 结果
     */
    public int deleteWalletVipConfigById(Long id);
}
