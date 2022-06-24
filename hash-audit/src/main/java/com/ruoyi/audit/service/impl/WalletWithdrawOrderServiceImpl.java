package com.ruoyi.audit.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.audit.mapper.WalletWithdrawOrderMapper;
import com.ruoyi.audit.domain.WalletWithdrawOrder;
import com.ruoyi.audit.service.IWalletWithdrawOrderService;

/**
 * 提现审核Service业务层处理
 *
 * @author xxk
 * @date 2022-06-02
 */
@Service
public class WalletWithdrawOrderServiceImpl implements IWalletWithdrawOrderService {
    @Autowired
    private WalletWithdrawOrderMapper walletWithdrawOrderMapper;

    //订单已经被领取 不得再次操作
    public static final int ORDER_HAD_CHECK = -200;
    //领取状态
    public static final String CHECK_STATUS = "1";

    /**
     * 查询提现审核
     *
     * @param id 提现审核主键
     * @return 提现审核
     */
    @Override
    public WalletWithdrawOrder selectWalletWithdrawOrderById(String id) {
        return walletWithdrawOrderMapper.selectWalletWithdrawOrderById(id);
    }

    /**
     * 查询提现审核列表
     *
     * @param walletWithdrawOrder 提现审核
     * @return 提现审核
     */
    @Override
    public List<WalletWithdrawOrder> selectWalletWithdrawOrderList(WalletWithdrawOrder walletWithdrawOrder) {
        return walletWithdrawOrderMapper.selectWalletWithdrawOrderList(walletWithdrawOrder);
    }

    /**
     * 新增提现审核
     *
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    @Override
    public int insertWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder) {
        walletWithdrawOrder.setCreateTime(DateUtils.getNowDate());
        return walletWithdrawOrderMapper.insertWalletWithdrawOrder(walletWithdrawOrder);
    }

    /**
     * 修改提现审核
     *
     * @param walletWithdrawOrder 提现审核
     * @return 结果
     */
    @Override
    public int updateWalletWithdrawOrder(WalletWithdrawOrder walletWithdrawOrder) {
        WalletWithdrawOrder order = walletWithdrawOrderMapper.selectWalletWithdrawOrderById(walletWithdrawOrder.getId());
        if (order.getCheckPerson() != null && CHECK_STATUS.equals(walletWithdrawOrder.getCheckStatus())) {
            return ORDER_HAD_CHECK;
        }
        walletWithdrawOrder.setUpdateTime(DateUtils.getNowDate());
        return walletWithdrawOrderMapper.updateWalletWithdrawOrder(walletWithdrawOrder);
    }

    /**
     * 批量删除提现审核
     *
     * @param ids 需要删除的提现审核主键
     * @return 结果
     */
    @Override
    public int deleteWalletWithdrawOrderByIds(String[] ids) {
        return walletWithdrawOrderMapper.deleteWalletWithdrawOrderByIds(ids);
    }

    /**
     * 删除提现审核信息
     *
     * @param id 提现审核主键
     * @return 结果
     */
    @Override
    public int deleteWalletWithdrawOrderById(String id) {
        return walletWithdrawOrderMapper.deleteWalletWithdrawOrderById(id);
    }

    @Override
    public List<WalletWithdrawOrder> selectCurrDay() {
        return walletWithdrawOrderMapper.selectCurrDay();
    }
}
