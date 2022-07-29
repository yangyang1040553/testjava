package com.ruoyi.wallet.service;

import java.util.List;
import com.ruoyi.wallet.domain.PayChannel;

/**
 * 支付通道配置Service接口
 * 
 * @author xxk
 * @date 2022-07-29
 */
public interface IPayChannelService 
{
    /**
     * 查询支付通道配置
     * 
     * @param id 支付通道配置主键
     * @return 支付通道配置
     */
    public PayChannel selectPayChannelById(String id);

    /**
     * 查询支付通道配置列表
     * 
     * @param payChannel 支付通道配置
     * @return 支付通道配置集合
     */
    public List<PayChannel> selectPayChannelList(PayChannel payChannel);

    /**
     * 新增支付通道配置
     * 
     * @param payChannel 支付通道配置
     * @return 结果
     */
    public int insertPayChannel(PayChannel payChannel);

    /**
     * 修改支付通道配置
     * 
     * @param payChannel 支付通道配置
     * @return 结果
     */
    public int updatePayChannel(PayChannel payChannel);

    /**
     * 批量删除支付通道配置
     * 
     * @param ids 需要删除的支付通道配置主键集合
     * @return 结果
     */
    public int deletePayChannelByIds(String[] ids);

    /**
     * 删除支付通道配置信息
     * 
     * @param id 支付通道配置主键
     * @return 结果
     */
    public int deletePayChannelById(String id);
}
