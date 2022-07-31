package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.PayOrderMapper;
import com.ruoyi.wallet.domain.PayOrder;
import com.ruoyi.wallet.service.IPayOrderService;

/**
 * 充值订单记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-31
 */
@Service
public class PayOrderServiceImpl implements IPayOrderService 
{
    @Autowired
    private PayOrderMapper payOrderMapper;

    /**
     * 查询充值订单记录
     * 
     * @param id 充值订单记录主键
     * @return 充值订单记录
     */
    @Override
    public PayOrder selectPayOrderById(String id)
    {
        return payOrderMapper.selectPayOrderById(id);
    }

    /**
     * 查询充值订单记录列表
     * 
     * @param payOrder 充值订单记录
     * @return 充值订单记录
     */
    @Override
    public List<PayOrder> selectPayOrderList(PayOrder payOrder)
    {
        return payOrderMapper.selectPayOrderList(payOrder);
    }

    /**
     * 新增充值订单记录
     * 
     * @param payOrder 充值订单记录
     * @return 结果
     */
    @Override
    public int insertPayOrder(PayOrder payOrder)
    {
        payOrder.setCreateTime(DateUtils.getNowDate());
        return payOrderMapper.insertPayOrder(payOrder);
    }

    /**
     * 修改充值订单记录
     * 
     * @param payOrder 充值订单记录
     * @return 结果
     */
    @Override
    public int updatePayOrder(PayOrder payOrder)
    {
        payOrder.setUpdateTime(DateUtils.getNowDate());
        return payOrderMapper.updatePayOrder(payOrder);
    }

    /**
     * 批量删除充值订单记录
     * 
     * @param ids 需要删除的充值订单记录主键
     * @return 结果
     */
    @Override
    public int deletePayOrderByIds(String[] ids)
    {
        return payOrderMapper.deletePayOrderByIds(ids);
    }

    /**
     * 删除充值订单记录信息
     * 
     * @param id 充值订单记录主键
     * @return 结果
     */
    @Override
    public int deletePayOrderById(String id)
    {
        return payOrderMapper.deletePayOrderById(id);
    }
}
