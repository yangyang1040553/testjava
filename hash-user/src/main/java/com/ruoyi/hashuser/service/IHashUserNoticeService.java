package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserNotice;

/**
 * 用户公告Service接口
 * 
 * @author xxk
 * @date 2022-05-10
 */
public interface IHashUserNoticeService 
{
    /**
     * 查询用户公告
     * 
     * @param id 用户公告主键
     * @return 用户公告
     */
    public HashUserNotice selectHashUserNoticeById(String id);

    /**
     * 查询用户公告列表
     * 
     * @param hashUserNotice 用户公告
     * @return 用户公告集合
     */
    public List<HashUserNotice> selectHashUserNoticeList(HashUserNotice hashUserNotice);

    /**
     * 新增用户公告
     * 
     * @param hashUserNotice 用户公告
     * @return 结果
     */
    public int insertHashUserNotice(HashUserNotice hashUserNotice);

    /**
     * 修改用户公告
     * 
     * @param hashUserNotice 用户公告
     * @return 结果
     */
    public int updateHashUserNotice(HashUserNotice hashUserNotice);

    /**
     * 批量删除用户公告
     * 
     * @param ids 需要删除的用户公告主键集合
     * @return 结果
     */
    public int deleteHashUserNoticeByIds(String[] ids);

    /**
     * 删除用户公告信息
     * 
     * @param id 用户公告主键
     * @return 结果
     */
    public int deleteHashUserNoticeById(String id);
}
