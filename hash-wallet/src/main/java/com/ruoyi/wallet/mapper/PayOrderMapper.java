package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.PayOrder;

/**
 * 充值订单记录Mapper接口
 * 
 * @author xxk
 * @date 2022-07-31
 */
public interface PayOrderMapper 
{
    /**
     * 查询充值订单记录
     * 
     * @param id 充值订单记录主键
     * @return 充值订单记录
     */
    public PayOrder selectPayOrderById(String id);

    /**
     * 查询充值订单记录列表
     * 
     * @param payOrder 充值订单记录
     * @return 充值订单记录集合
     */
    public List<PayOrder> selectPayOrderList(PayOrder payOrder);

    /**
     * 新增充值订单记录
     * 
     * @param payOrder 充值订单记录
     * @return 结果
     */
    public int insertPayOrder(PayOrder payOrder);

    /**
     * 修改充值订单记录
     * 
     * @param payOrder 充值订单记录
     * @return 结果
     */
    public int updatePayOrder(PayOrder payOrder);

    /**
     * 删除充值订单记录
     * 
     * @param id 充值订单记录主键
     * @return 结果
     */
    public int deletePayOrderById(String id);

    /**
     * 批量删除充值订单记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayOrderByIds(String[] ids);
}
