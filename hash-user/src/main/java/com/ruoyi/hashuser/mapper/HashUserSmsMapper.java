package com.ruoyi.hashuser.mapper;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserSms;

/**
 * 用户短信功能Mapper接口
 * 
 * @author xxk
 * @date 2022-05-12
 */
public interface HashUserSmsMapper 
{
    /**
     * 查询用户短信功能
     * 
     * @param id 用户短信功能主键
     * @return 用户短信功能
     */
    public HashUserSms selectHashUserSmsById(String id);

    /**
     * 查询用户短信功能列表
     * 
     * @param hashUserSms 用户短信功能
     * @return 用户短信功能集合
     */
    public List<HashUserSms> selectHashUserSmsList(HashUserSms hashUserSms);

    /**
     * 新增用户短信功能
     * 
     * @param hashUserSms 用户短信功能
     * @return 结果
     */
    public int insertHashUserSms(HashUserSms hashUserSms);

    /**
     * 修改用户短信功能
     * 
     * @param hashUserSms 用户短信功能
     * @return 结果
     */
    public int updateHashUserSms(HashUserSms hashUserSms);

    /**
     * 删除用户短信功能
     * 
     * @param id 用户短信功能主键
     * @return 结果
     */
    public int deleteHashUserSmsById(String id);

    /**
     * 批量删除用户短信功能
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHashUserSmsByIds(String[] ids);
}
