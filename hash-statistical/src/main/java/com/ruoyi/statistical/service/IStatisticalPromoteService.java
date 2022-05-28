package com.ruoyi.statistical.service;

import java.util.List;
import com.ruoyi.statistical.domain.StatisticalPromote;

/**
 * VIEWService接口
 * 
 * @author xxk
 * @date 2022-05-28
 */
public interface IStatisticalPromoteService 
{
    /**
     * 查询VIEW
     * 
     * @param id VIEW主键
     * @return VIEW
     */
    public StatisticalPromote selectStatisticalPromoteById(String id);

    /**
     * 查询VIEW列表
     * 
     * @param statisticalPromote VIEW
     * @return VIEW集合
     */
    public List<StatisticalPromote> selectStatisticalPromoteList(StatisticalPromote statisticalPromote);

    /**
     * 新增VIEW
     * 
     * @param statisticalPromote VIEW
     * @return 结果
     */
    public int insertStatisticalPromote(StatisticalPromote statisticalPromote);

    /**
     * 修改VIEW
     * 
     * @param statisticalPromote VIEW
     * @return 结果
     */
    public int updateStatisticalPromote(StatisticalPromote statisticalPromote);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的VIEW主键集合
     * @return 结果
     */
    public int deleteStatisticalPromoteByIds(String[] ids);

    /**
     * 删除VIEW信息
     * 
     * @param id VIEW主键
     * @return 结果
     */
    public int deleteStatisticalPromoteById(String id);
}
