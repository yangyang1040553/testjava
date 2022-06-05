package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.GameStatisticalPromoteIncome;

/**
 * 代理每日收益金额Service接口
 * 
 * @author xxk
 * @date 2022-06-05
 */
public interface IGameStatisticalPromoteIncomeService 
{
    /**
     * 查询代理每日收益金额
     * 
     * @param id 代理每日收益金额主键
     * @return 代理每日收益金额
     */
    public GameStatisticalPromoteIncome selectGameStatisticalPromoteIncomeById(String id);

    /**
     * 查询代理每日收益金额列表
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 代理每日收益金额集合
     */
    public List<GameStatisticalPromoteIncome> selectGameStatisticalPromoteIncomeList(GameStatisticalPromoteIncome gameStatisticalPromoteIncome);

    /**
     * 新增代理每日收益金额
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 结果
     */
    public int insertGameStatisticalPromoteIncome(GameStatisticalPromoteIncome gameStatisticalPromoteIncome);

    /**
     * 修改代理每日收益金额
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 结果
     */
    public int updateGameStatisticalPromoteIncome(GameStatisticalPromoteIncome gameStatisticalPromoteIncome);

    /**
     * 批量删除代理每日收益金额
     * 
     * @param ids 需要删除的代理每日收益金额主键集合
     * @return 结果
     */
    public int deleteGameStatisticalPromoteIncomeByIds(String[] ids);

    /**
     * 删除代理每日收益金额信息
     * 
     * @param id 代理每日收益金额主键
     * @return 结果
     */
    public int deleteGameStatisticalPromoteIncomeById(String id);
}
