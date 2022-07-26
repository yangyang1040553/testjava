package com.ruoyi.operation.mapper;

import java.util.List;
import com.ruoyi.operation.domain.DkOssList;

/**
 * 对抗存储列Mapper接口
 * 
 * @author xxk
 * @date 2022-07-26
 */
public interface DkOssListMapper 
{
    /**
     * 查询对抗存储列
     * 
     * @param id 对抗存储列主键
     * @return 对抗存储列
     */
    public DkOssList selectDkOssListById(Long id);

    /**
     * 查询对抗存储列列表
     * 
     * @param dkOssList 对抗存储列
     * @return 对抗存储列集合
     */
    public List<DkOssList> selectDkOssListList(DkOssList dkOssList);

    /**
     * 新增对抗存储列
     * 
     * @param dkOssList 对抗存储列
     * @return 结果
     */
    public int insertDkOssList(DkOssList dkOssList);

    /**
     * 修改对抗存储列
     * 
     * @param dkOssList 对抗存储列
     * @return 结果
     */
    public int updateDkOssList(DkOssList dkOssList);

    /**
     * 删除对抗存储列
     * 
     * @param id 对抗存储列主键
     * @return 结果
     */
    public int deleteDkOssListById(Long id);

    /**
     * 批量删除对抗存储列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkOssListByIds(Long[] ids);
}
