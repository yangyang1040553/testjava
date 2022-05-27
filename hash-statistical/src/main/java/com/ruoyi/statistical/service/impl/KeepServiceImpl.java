package com.ruoyi.statistical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.KeepMapper;
import com.ruoyi.statistical.domain.Keep;
import com.ruoyi.statistical.service.IKeepService;

/**
 * 留存分析Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-27
 */
@Service
public class KeepServiceImpl implements IKeepService 
{
    @Autowired
    private KeepMapper keepMapper;

    /**
     * 查询留存分析
     * 
     * @param registerTime 留存分析主键
     * @return 留存分析
     */
    @Override
    public Keep selectKeepByRegisterTime(String registerTime)
    {
        return keepMapper.selectKeepByRegisterTime(registerTime);
    }

    /**
     * 查询留存分析列表
     * 
     * @param keep 留存分析
     * @return 留存分析
     */
    @Override
    public List<Keep> selectKeepList(Keep keep)
    {
        return keepMapper.selectKeepList(keep);
    }

    /**
     * 新增留存分析
     * 
     * @param keep 留存分析
     * @return 结果
     */
    @Override
    public int insertKeep(Keep keep)
    {
        return keepMapper.insertKeep(keep);
    }

    /**
     * 修改留存分析
     * 
     * @param keep 留存分析
     * @return 结果
     */
    @Override
    public int updateKeep(Keep keep)
    {
        return keepMapper.updateKeep(keep);
    }

    /**
     * 批量删除留存分析
     * 
     * @param registerTimes 需要删除的留存分析主键
     * @return 结果
     */
    @Override
    public int deleteKeepByRegisterTimes(String[] registerTimes)
    {
        return keepMapper.deleteKeepByRegisterTimes(registerTimes);
    }

    /**
     * 删除留存分析信息
     * 
     * @param registerTime 留存分析主键
     * @return 结果
     */
    @Override
    public int deleteKeepByRegisterTime(String registerTime)
    {
        return keepMapper.deleteKeepByRegisterTime(registerTime);
    }
}
