package com.ruoyi.hashuser.service;

import java.util.List;
import com.ruoyi.hashuser.domain.HashUserSms;

/**
 * 用户短信功能Service接口
 * 
 * @author xxk
 * @date 2022-05-12
 */
public interface IHashUserSmsService 
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
     * 批量删除用户短信功能
     * 
     * @param ids 需要删除的用户短信功能主键集合
     * @return 结果
     */
    public int deleteHashUserSmsByIds(String[] ids);

    /**
     * 删除用户短信功能信息
     * 
     * @param id 用户短信功能主键
     * @return 结果
     */
    public int deleteHashUserSmsById(String id);
}
