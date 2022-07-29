package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.PayTypeMapper;
import com.ruoyi.wallet.domain.PayType;
import com.ruoyi.wallet.service.IPayTypeService;

/**
 * 支付类型配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-29
 */
@Service
public class PayTypeServiceImpl implements IPayTypeService 
{
    @Autowired
    private PayTypeMapper payTypeMapper;

    /**
     * 查询支付类型配置
     * 
     * @param id 支付类型配置主键
     * @return 支付类型配置
     */
    @Override
    public PayType selectPayTypeById(String id)
    {
        return payTypeMapper.selectPayTypeById(id);
    }

    /**
     * 查询支付类型配置列表
     * 
     * @param payType 支付类型配置
     * @return 支付类型配置
     */
    @Override
    public List<PayType> selectPayTypeList(PayType payType)
    {
        return payTypeMapper.selectPayTypeList(payType);
    }

    /**
     * 新增支付类型配置
     * 
     * @param payType 支付类型配置
     * @return 结果
     */
    @Override
    public int insertPayType(PayType payType)
    {
        payType.setCreateTime(DateUtils.getNowDate());
        return payTypeMapper.insertPayType(payType);
    }

    /**
     * 修改支付类型配置
     * 
     * @param payType 支付类型配置
     * @return 结果
     */
    @Override
    public int updatePayType(PayType payType)
    {
        payType.setUpdateTime(DateUtils.getNowDate());
        return payTypeMapper.updatePayType(payType);
    }

    /**
     * 批量删除支付类型配置
     * 
     * @param ids 需要删除的支付类型配置主键
     * @return 结果
     */
    @Override
    public int deletePayTypeByIds(String[] ids)
    {
        return payTypeMapper.deletePayTypeByIds(ids);
    }

    /**
     * 删除支付类型配置信息
     * 
     * @param id 支付类型配置主键
     * @return 结果
     */
    @Override
    public int deletePayTypeById(String id)
    {
        return payTypeMapper.deletePayTypeById(id);
    }
}
