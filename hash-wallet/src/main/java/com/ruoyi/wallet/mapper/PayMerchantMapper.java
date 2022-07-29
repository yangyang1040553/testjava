package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.PayMerchant;

/**
 * 支付商户配置Mapper接口
 * 
 * @author xxk
 * @date 2022-07-29
 */
public interface PayMerchantMapper 
{
    /**
     * 查询支付商户配置
     * 
     * @param id 支付商户配置主键
     * @return 支付商户配置
     */
    public PayMerchant selectPayMerchantById(String id);

    /**
     * 查询支付商户配置列表
     * 
     * @param payMerchant 支付商户配置
     * @return 支付商户配置集合
     */
    public List<PayMerchant> selectPayMerchantList(PayMerchant payMerchant);

    /**
     * 新增支付商户配置
     * 
     * @param payMerchant 支付商户配置
     * @return 结果
     */
    public int insertPayMerchant(PayMerchant payMerchant);

    /**
     * 修改支付商户配置
     * 
     * @param payMerchant 支付商户配置
     * @return 结果
     */
    public int updatePayMerchant(PayMerchant payMerchant);

    /**
     * 删除支付商户配置
     * 
     * @param id 支付商户配置主键
     * @return 结果
     */
    public int deletePayMerchantById(String id);

    /**
     * 批量删除支付商户配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayMerchantByIds(String[] ids);
}
