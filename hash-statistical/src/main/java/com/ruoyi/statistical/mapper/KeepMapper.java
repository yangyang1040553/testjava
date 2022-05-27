package com.ruoyi.statistical.mapper;

import java.util.List;
import com.ruoyi.statistical.domain.Keep;

/**
 * 留存分析Mapper接口
 * 
 * @author xxk
 * @date 2022-05-27
 */
public interface KeepMapper 
{
    /**
     * 查询留存分析
     * 
     * @param registerTime 留存分析主键
     * @return 留存分析
     */
    public Keep selectKeepByRegisterTime(String registerTime);

    /**
     * 查询留存分析列表
     * 
     * @param keep 留存分析
     * @return 留存分析集合
     */
    public List<Keep> selectKeepList(Keep keep);

    /**
     * 新增留存分析
     * 
     * @param keep 留存分析
     * @return 结果
     */
    public int insertKeep(Keep keep);

    /**
     * 修改留存分析
     * 
     * @param keep 留存分析
     * @return 结果
     */
    public int updateKeep(Keep keep);

    /**
     * 删除留存分析
     * 
     * @param registerTime 留存分析主键
     * @return 结果
     */
    public int deleteKeepByRegisterTime(String registerTime);

    /**
     * 批量删除留存分析
     * 
     * @param registerTimes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeepByRegisterTimes(String[] registerTimes);
}
