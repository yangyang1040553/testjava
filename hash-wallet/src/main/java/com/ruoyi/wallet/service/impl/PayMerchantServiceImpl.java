package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.PayMerchantMapper;
import com.ruoyi.wallet.domain.PayMerchant;
import com.ruoyi.wallet.service.IPayMerchantService;

/**
 * 支付商户配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-29
 */
@Service
public class PayMerchantServiceImpl implements IPayMerchantService 
{
    @Autowired
    private PayMerchantMapper payMerchantMapper;

    /**
     * 查询支付商户配置
     * 
     * @param id 支付商户配置主键
     * @return 支付商户配置
     */
    @Override
    public PayMerchant selectPayMerchantById(String id)
    {
        return payMerchantMapper.selectPayMerchantById(id);
    }

    /**
     * 查询支付商户配置列表
     * 
     * @param payMerchant 支付商户配置
     * @return 支付商户配置
     */
    @Override
    public List<PayMerchant> selectPayMerchantList(PayMerchant payMerchant)
    {
        return payMerchantMapper.selectPayMerchantList(payMerchant);
    }

    /**
     * 新增支付商户配置
     * 
     * @param payMerchant 支付商户配置
     * @return 结果
     */
    @Override
    public int insertPayMerchant(PayMerchant payMerchant)
    {
        payMerchant.setCreateTime(DateUtils.getNowDate());
        return payMerchantMapper.insertPayMerchant(payMerchant);
    }

    /**
     * 修改支付商户配置
     * 
     * @param payMerchant 支付商户配置
     * @return 结果
     */
    @Override
    public int updatePayMerchant(PayMerchant payMerchant)
    {
        payMerchant.setUpdateTime(DateUtils.getNowDate());
        return payMerchantMapper.updatePayMerchant(payMerchant);
    }

    /**
     * 批量删除支付商户配置
     * 
     * @param ids 需要删除的支付商户配置主键
     * @return 结果
     */
    @Override
    public int deletePayMerchantByIds(String[] ids)
    {
        return payMerchantMapper.deletePayMerchantByIds(ids);
    }

    /**
     * 删除支付商户配置信息
     * 
     * @param id 支付商户配置主键
     * @return 结果
     */
    @Override
    public int deletePayMerchantById(String id)
    {
        return payMerchantMapper.deletePayMerchantById(id);
    }
}
