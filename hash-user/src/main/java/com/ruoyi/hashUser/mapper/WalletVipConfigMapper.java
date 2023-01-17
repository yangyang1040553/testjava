package com.ruoyi.hashUser.mapper;

import java.util.List;
import com.ruoyi.hashUser.domain.WalletVipConfig;

/**
 * VIP类型配置Mapper接口
 * 
 * @author xxk
 * @date 2023-01-06
 */
public interface WalletVipConfigMapper 
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
     * 删除VIP类型配置
     * 
     * @param id VIP类型配置主键
     * @return 结果
     */
    public int deleteWalletVipConfigById(Long id);

    /**
     * 批量删除VIP类型配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWalletVipConfigByIds(Long[] ids);
}
