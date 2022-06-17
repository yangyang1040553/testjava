package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.WalletRechargeOrder;

/**
 * 充值Mapper接口
 * 
 * @author xxk
 * @date 2022-06-17
 */
public interface WalletRechargeOrderMapper 
{
    /**
     * 查询充值
     * 
     * @param id 充值主键
     * @return 充值
     */
    public WalletRechargeOrder selectWalletRechargeOrderById(String id);

    /**
     * 查询充值列表
     * 
     * @param walletRechargeOrder 充值
     * @return 充值集合
     */
    public List<WalletRechargeOrder> selectWalletRechargeOrderList(WalletRechargeOrder walletRechargeOrder);

    /**
     * 新增充值
     * 
     * @param walletRechargeOrder 充值
     * @return 结果
     */
    public int insertWalletRechargeOrder(WalletRechargeOrder walletRechargeOrder);

    /**
     * 修改充值
     * 
     * @param walletRechargeOrder 充值
     * @return 结果
     */
    public int updateWalletRechargeOrder(WalletRechargeOrder walletRechargeOrder);

    /**
     * 删除充值
     * 
     * @param id 充值主键
     * @return 结果
     */
    public int deleteWalletRechargeOrderById(String id);

    /**
     * 批量删除充值
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWalletRechargeOrderByIds(String[] ids);
}
