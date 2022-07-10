package com.ruoyi.wallet.service;

import java.util.List;
import com.ruoyi.wallet.domain.WalletArtificialOpt;

/**
 * 人工出入款Service接口
 * 
 * @author xxk
 * @date 2022-07-10
 */
public interface IWalletArtificialOptService 
{
    /**
     * 查询人工出入款
     * 
     * @param id 人工出入款主键
     * @return 人工出入款
     */
    public WalletArtificialOpt selectWalletArtificialOptById(String id);

    /**
     * 查询人工出入款列表
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 人工出入款集合
     */
    public List<WalletArtificialOpt> selectWalletArtificialOptList(WalletArtificialOpt walletArtificialOpt);

    /**
     * 新增人工出入款
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 结果
     */
    public int insertWalletArtificialOpt(WalletArtificialOpt walletArtificialOpt);

    /**
     * 修改人工出入款
     * 
     * @param walletArtificialOpt 人工出入款
     * @return 结果
     */
    public int updateWalletArtificialOpt(WalletArtificialOpt walletArtificialOpt);

    /**
     * 批量删除人工出入款
     * 
     * @param ids 需要删除的人工出入款主键集合
     * @return 结果
     */
    public int deleteWalletArtificialOptByIds(String[] ids);

    /**
     * 删除人工出入款信息
     * 
     * @param id 人工出入款主键
     * @return 结果
     */
    public int deleteWalletArtificialOptById(String id);
}
