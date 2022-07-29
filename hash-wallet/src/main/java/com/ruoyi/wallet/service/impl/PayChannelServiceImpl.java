package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.PayChannelMapper;
import com.ruoyi.wallet.domain.PayChannel;
import com.ruoyi.wallet.service.IPayChannelService;

/**
 * 支付通道配置Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-29
 */
@Service
public class PayChannelServiceImpl implements IPayChannelService 
{
    @Autowired
    private PayChannelMapper payChannelMapper;

    /**
     * 查询支付通道配置
     * 
     * @param id 支付通道配置主键
     * @return 支付通道配置
     */
    @Override
    public PayChannel selectPayChannelById(String id)
    {
        return payChannelMapper.selectPayChannelById(id);
    }

    /**
     * 查询支付通道配置列表
     * 
     * @param payChannel 支付通道配置
     * @return 支付通道配置
     */
    @Override
    public List<PayChannel> selectPayChannelList(PayChannel payChannel)
    {
        return payChannelMapper.selectPayChannelList(payChannel);
    }

    /**
     * 新增支付通道配置
     * 
     * @param payChannel 支付通道配置
     * @return 结果
     */
    @Override
    public int insertPayChannel(PayChannel payChannel)
    {
        payChannel.setCreateTime(DateUtils.getNowDate());
        return payChannelMapper.insertPayChannel(payChannel);
    }

    /**
     * 修改支付通道配置
     * 
     * @param payChannel 支付通道配置
     * @return 结果
     */
    @Override
    public int updatePayChannel(PayChannel payChannel)
    {
        payChannel.setUpdateTime(DateUtils.getNowDate());
        return payChannelMapper.updatePayChannel(payChannel);
    }

    /**
     * 批量删除支付通道配置
     * 
     * @param ids 需要删除的支付通道配置主键
     * @return 结果
     */
    @Override
    public int deletePayChannelByIds(String[] ids)
    {
        return payChannelMapper.deletePayChannelByIds(ids);
    }

    /**
     * 删除支付通道配置信息
     * 
     * @param id 支付通道配置主键
     * @return 结果
     */
    @Override
    public int deletePayChannelById(String id)
    {
        return payChannelMapper.deletePayChannelById(id);
    }
}
