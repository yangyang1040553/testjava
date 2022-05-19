package com.ruoyi.wallet.mapper;

import java.util.List;
import com.ruoyi.wallet.domain.GameWithdrawRecord;

/**
 * 佣金提现记录Mapper接口
 * 
 * @author xxk
 * @date 2022-05-19
 */
public interface GameWithdrawRecordMapper 
{
    /**
     * 查询佣金提现记录
     * 
     * @param id 佣金提现记录主键
     * @return 佣金提现记录
     */
    public GameWithdrawRecord selectGameWithdrawRecordById(String id);

    /**
     * 查询佣金提现记录列表
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 佣金提现记录集合
     */
    public List<GameWithdrawRecord> selectGameWithdrawRecordList(GameWithdrawRecord gameWithdrawRecord);

    /**
     * 新增佣金提现记录
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 结果
     */
    public int insertGameWithdrawRecord(GameWithdrawRecord gameWithdrawRecord);

    /**
     * 修改佣金提现记录
     * 
     * @param gameWithdrawRecord 佣金提现记录
     * @return 结果
     */
    public int updateGameWithdrawRecord(GameWithdrawRecord gameWithdrawRecord);

    /**
     * 删除佣金提现记录
     * 
     * @param id 佣金提现记录主键
     * @return 结果
     */
    public int deleteGameWithdrawRecordById(String id);

    /**
     * 批量删除佣金提现记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameWithdrawRecordByIds(String[] ids);
}
