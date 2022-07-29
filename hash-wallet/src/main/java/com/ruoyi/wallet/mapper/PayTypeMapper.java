package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.PayType;

/**
 * 支付类型配置Mapper接口
 * 
 * @author xxk
 * @date 2022-07-29
 */
public interface PayTypeMapper 
{
    /**
     * 查询支付类型配置
     * 
     * @param id 支付类型配置主键
     * @return 支付类型配置
     */
    public PayType selectPayTypeById(String id);

    /**
     * 查询支付类型配置列表
     * 
     * @param payType 支付类型配置
     * @return 支付类型配置集合
     */
    public List<PayType> selectPayTypeList(PayType payType);

    /**
     * 新增支付类型配置
     * 
     * @param payType 支付类型配置
     * @return 结果
     */
    public int insertPayType(PayType payType);

    /**
     * 修改支付类型配置
     * 
     * @param payType 支付类型配置
     * @return 结果
     */
    public int updatePayType(PayType payType);

    /**
     * 删除支付类型配置
     * 
     * @param id 支付类型配置主键
     * @return 结果
     */
    public int deletePayTypeById(String id);

    /**
     * 批量删除支付类型配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayTypeByIds(String[] ids);
}
