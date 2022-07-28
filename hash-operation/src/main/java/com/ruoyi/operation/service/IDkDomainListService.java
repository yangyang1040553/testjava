package com.ruoyi.operation.service;

import java.util.List;
import com.ruoyi.operation.domain.DkDomainList;

/**
 * 对抗域名列Service接口
 * 
 * @author xxk
 * @date 2022-07-27
 */
public interface IDkDomainListService 
{
    /**
     * 查询对抗域名列
     * 
     * @param id 对抗域名列主键
     * @return 对抗域名列
     */
    public DkDomainList selectDkDomainListById(Long id);

    /**
     * 查询对抗域名列列表
     * 
     * @param dkDomainList 对抗域名列
     * @return 对抗域名列集合
     */
    public List<DkDomainList> selectDkDomainListList(DkDomainList dkDomainList);

    /**
     * 新增对抗域名列
     * 
     * @param dkDomainList 对抗域名列
     * @return 结果
     */
    public int insertDkDomainList(DkDomainList dkDomainList);

    /**
     * 修改对抗域名列
     * 
     * @param dkDomainList 对抗域名列
     * @return 结果
     */
    public int updateDkDomainList(DkDomainList dkDomainList);

    /**
     * 批量删除对抗域名列
     * 
     * @param ids 需要删除的对抗域名列主键集合
     * @return 结果
     */
    public int deleteDkDomainListByIds(Long[] ids);

    /**
     * 删除对抗域名列信息
     * 
     * @param id 对抗域名列主键
     * @return 结果
     */
    public int deleteDkDomainListById(Long id);
}
