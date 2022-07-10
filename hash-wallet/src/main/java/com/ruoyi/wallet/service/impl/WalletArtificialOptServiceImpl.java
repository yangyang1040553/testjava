package com.ruoyi.wallet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wallet.mapper.WalletArtificialOptMapper;
import com.ruoyi.wallet.domain.WalletArtificialOpt;
import com.ruoyi.wallet.service.IWalletArtificialOptService;

/**
 * 人工出入款Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-10
 */
@Service
public class WalletArtificialOptServiceImpl implements IWalletArtificialOptService 
{
    @Autowired
    private WalletArtificialOptMapper walletArtificialOptMapper;

    /**
     * 查询人工出入款
     * 
     * @param id 人工出入款主键
     * @return 人工出入款
     */
    @Override
    public WalletArtificialOpt selectWalletArtificialOptById(String id)
    {
        return walletArtificialOptMapper.selectWalletArtificialOptById(id);
    }

    /**
     * 查询人工出入款列表
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 人工出入款
     */
    @Override
    public List<WalletArtificialOpt> selectWalletArtificialOptList(WalletArtificialOpt walletArtificialOpt)
    {
        return walletArtificialOptMapper.selectWalletArtificialOptList(walletArtificialOpt);
    }

    /**
     * 新增人工出入款
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 结果
     */
    @Override
    public int insertWalletArtificialOpt(WalletArtificialOpt walletArtificialOpt)
    {
        walletArtificialOpt.setCreateTime(DateUtils.getNowDate());
        return walletArtificialOptMapper.insertWalletArtificialOpt(walletArtificialOpt);
    }

    /**
     * 修改人工出入款
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 结果
     */
    @Override
    public int updateWalletArtificialOpt(WalletArtificialOpt walletArtificialOpt)
    {
        return walletArtificialOptMapper.updateWalletArtificialOpt(walletArtificialOpt);
    }

    /**
     * 批量删除人工出入款
     * 
     * @param ids 需要删除的人工出入款主键
     * @return 结果
     */
    @Override
    public int deleteWalletArtificialOptByIds(String[] ids)
    {
        return walletArtificialOptMapper.deleteWalletArtificialOptByIds(ids);
    }

    /**
     * 删除人工出入款信息
     * 
     * @param id 人工出入款主键
     * @return 结果
     */
    @Override
    public int deleteWalletArtificialOptById(String id)
    {
        return walletArtificialOptMapper.deleteWalletArtificialOptById(id);
    }
}
