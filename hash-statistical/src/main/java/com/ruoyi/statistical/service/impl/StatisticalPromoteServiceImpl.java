package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.StatisticalPromoteMapper;
import com.ruoyi.statistical.domain.StatisticalPromote;
import com.ruoyi.statistical.service.IStatisticalPromoteService;

/**
 * VIEWService业务层处理
 * 
 * @author xxk
 * @date 2022-05-28
 */
@Service
public class StatisticalPromoteServiceImpl implements IStatisticalPromoteService 
{
    @Autowired
    private StatisticalPromoteMapper statisticalPromoteMapper;

    /**
     * 查询VIEW
     * 
     * @param id VIEW主键
     * @return VIEW
     */
    @Override
    public StatisticalPromote selectStatisticalPromoteById(String id)
    {
        return statisticalPromoteMapper.selectStatisticalPromoteById(id);
    }

    /**
     * 查询VIEW列表
     * 
     * @param statisticalPromote VIEW
     * @return VIEW
     */
    @Override
    public List<StatisticalPromote> selectStatisticalPromoteList(StatisticalPromote statisticalPromote)
    {
        return statisticalPromoteMapper.selectStatisticalPromoteList(statisticalPromote);
    }

    /**
     * 新增VIEW
     * 
     * @param statisticalPromote VIEW
     * @return 结果
     */
    @Override
    public int insertStatisticalPromote(StatisticalPromote statisticalPromote)
    {
        return statisticalPromoteMapper.insertStatisticalPromote(statisticalPromote);
    }

    /**
     * 修改VIEW
     * 
     * @param statisticalPromote VIEW
     * @return 结果
     */
    @Override
    public int updateStatisticalPromote(StatisticalPromote statisticalPromote)
    {
        return statisticalPromoteMapper.updateStatisticalPromote(statisticalPromote);
    }

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的VIEW主键
     * @return 结果
     */
    @Override
    public int deleteStatisticalPromoteByIds(String[] ids)
    {
        return statisticalPromoteMapper.deleteStatisticalPromoteByIds(ids);
    }

    /**
     * 删除VIEW信息
     * 
     * @param id VIEW主键
     * @return 结果
     */
    @Override
    public int deleteStatisticalPromoteById(String id)
    {
        return statisticalPromoteMapper.deleteStatisticalPromoteById(id);
    }
}
