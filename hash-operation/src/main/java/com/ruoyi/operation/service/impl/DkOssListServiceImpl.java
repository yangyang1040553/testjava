package com.ruoyi.operation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.DkOssListMapper;
import com.ruoyi.operation.domain.DkOssList;
import com.ruoyi.operation.service.IDkOssListService;

/**
 * 对抗存储列Service业务层处理
 * 
 * @author xxk
 * @date 2022-07-26
 */
@Service
public class DkOssListServiceImpl implements IDkOssListService 
{
    @Autowired
    private DkOssListMapper dkOssListMapper;

    /**
     * 查询对抗存储列
     * 
     * @param id 对抗存储列主键
     * @return 对抗存储列
     */
    @Override
    public DkOssList selectDkOssListById(Long id)
    {
        return dkOssListMapper.selectDkOssListById(id);
    }

    /**
     * 查询对抗存储列列表
     * 
     * @param dkOssList 对抗存储列
     * @return 对抗存储列
     */
    @Override
    public List<DkOssList> selectDkOssListList(DkOssList dkOssList)
    {
        return dkOssListMapper.selectDkOssListList(dkOssList);
    }

    /**
     * 新增对抗存储列
     * 
     * @param dkOssList 对抗存储列
     * @return 结果
     */
    @Override
    public int insertDkOssList(DkOssList dkOssList)
    {
        dkOssList.setCreateTime(DateUtils.getNowDate());
        return dkOssListMapper.insertDkOssList(dkOssList);
    }

    /**
     * 修改对抗存储列
     * 
     * @param dkOssList 对抗存储列
     * @return 结果
     */
    @Override
    public int updateDkOssList(DkOssList dkOssList)
    {
        dkOssList.setUpdateTime(DateUtils.getNowDate());
        return dkOssListMapper.updateDkOssList(dkOssList);
    }

    /**
     * 批量删除对抗存储列
     * 
     * @param ids 需要删除的对抗存储列主键
     * @return 结果
     */
    @Override
    public int deleteDkOssListByIds(Long[] ids)
    {
        return dkOssListMapper.deleteDkOssListByIds(ids);
    }

    /**
     * 删除对抗存储列信息
     * 
     * @param id 对抗存储列主键
     * @return 结果
     */
    @Override
    public int deleteDkOssListById(Long id)
    {
        return dkOssListMapper.deleteDkOssListById(id);
    }
}
