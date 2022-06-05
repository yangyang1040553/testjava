package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GameStatisticalPromoteIncomeMapper;
import com.ruoyi.statistical.domain.GameStatisticalPromoteIncome;
import com.ruoyi.statistical.service.IGameStatisticalPromoteIncomeService;

/**
 * 代理每日收益金额Service业务层处理
 * 
 * @author xxk
 * @date 2022-06-05
 */
@Service
public class GameStatisticalPromoteIncomeServiceImpl implements IGameStatisticalPromoteIncomeService 
{
    @Autowired
    private GameStatisticalPromoteIncomeMapper gameStatisticalPromoteIncomeMapper;

    /**
     * 查询代理每日收益金额
     * 
     * @param id 代理每日收益金额主键
     * @return 代理每日收益金额
     */
    @Override
    public GameStatisticalPromoteIncome selectGameStatisticalPromoteIncomeById(String id)
    {
        return gameStatisticalPromoteIncomeMapper.selectGameStatisticalPromoteIncomeById(id);
    }

    /**
     * 查询代理每日收益金额列表
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 代理每日收益金额
     */
    @Override
    public List<GameStatisticalPromoteIncome> selectGameStatisticalPromoteIncomeList(GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        return gameStatisticalPromoteIncomeMapper.selectGameStatisticalPromoteIncomeList(gameStatisticalPromoteIncome);
    }

    /**
     * 新增代理每日收益金额
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 结果
     */
    @Override
    public int insertGameStatisticalPromoteIncome(GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        return gameStatisticalPromoteIncomeMapper.insertGameStatisticalPromoteIncome(gameStatisticalPromoteIncome);
    }

    /**
     * 修改代理每日收益金额
     * 
     * @param gameStatisticalPromoteIncome 代理每日收益金额
     * @return 结果
     */
    @Override
    public int updateGameStatisticalPromoteIncome(GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        return gameStatisticalPromoteIncomeMapper.updateGameStatisticalPromoteIncome(gameStatisticalPromoteIncome);
    }

    /**
     * 批量删除代理每日收益金额
     * 
     * @param ids 需要删除的代理每日收益金额主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPromoteIncomeByIds(String[] ids)
    {
        return gameStatisticalPromoteIncomeMapper.deleteGameStatisticalPromoteIncomeByIds(ids);
    }

    /**
     * 删除代理每日收益金额信息
     * 
     * @param id 代理每日收益金额主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPromoteIncomeById(String id)
    {
        return gameStatisticalPromoteIncomeMapper.deleteGameStatisticalPromoteIncomeById(id);
    }
}
