package com.ruoyi.hashUser.mapper;

import java.util.List;
import com.ruoyi.hashUser.domain.PayChannel;

/**
 * 支付通道配置Mapper接口
 * 
 * @author xxk
 * @date 2023-01-05
 */
public interface PayChannelMapper 
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
     * 删除支付通道配置
     * 
     * @param id 支付通道配置主键
     * @return 结果
     */
    public int deletePayChannelById(String id);

    /**
     * 批量删除支付通道配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePayChannelByIds(String[] ids);
}
