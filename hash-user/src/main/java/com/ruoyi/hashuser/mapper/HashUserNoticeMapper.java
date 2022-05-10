package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserNotice;

/**
 * 用户公告Mapper接口
 * 
 * @author xxk
 * @date 2022-05-10
 */
public interface HashUserNoticeMapper 
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
     * 删除用户公告
     * 
     * @param id 用户公告主键
     * @return 结果
     */
    public int deleteHashUserNoticeById(String id);

    /**
     * 批量删除用户公告
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHashUserNoticeByIds(String[] ids);
}
