package com.ruoyi.hashuser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.HashUserSmsMapper;
import com.ruoyi.hashuser.domain.HashUserSms;
import com.ruoyi.hashuser.service.IHashUserSmsService;

/**
 * 用户短信功能Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-12
 */
@Service
public class HashUserSmsServiceImpl implements IHashUserSmsService 
{
    @Autowired
    private HashUserSmsMapper hashUserSmsMapper;

    /**
     * 查询用户短信功能
     * 
     * @param id 用户短信功能主键
     * @return 用户短信功能
     */
    @Override
    public HashUserSms selectHashUserSmsById(String id)
    {
        return hashUserSmsMapper.selectHashUserSmsById(id);
    }

    /**
     * 查询用户短信功能列表
     * 
     * @param hashUserSms 用户短信功能
     * @return 用户短信功能
     */
    @Override
    public List<HashUserSms> selectHashUserSmsList(HashUserSms hashUserSms)
    {
        return hashUserSmsMapper.selectHashUserSmsList(hashUserSms);
    }

    /**
     * 新增用户短信功能
     * 
     * @param hashUserSms 用户短信功能
     * @return 结果
     */
    @Override
    public int insertHashUserSms(HashUserSms hashUserSms)
    {
        hashUserSms.setCreateTime(DateUtils.getNowDate());
        return hashUserSmsMapper.insertHashUserSms(hashUserSms);
    }

    /**
     * 修改用户短信功能
     * 
     * @param hashUserSms 用户短信功能
     * @return 结果
     */
    @Override
    public int updateHashUserSms(HashUserSms hashUserSms)
    {
        return hashUserSmsMapper.updateHashUserSms(hashUserSms);
    }

    /**
     * 批量删除用户短信功能
     * 
     * @param ids 需要删除的用户短信功能主键
     * @return 结果
     */
    @Override
    public int deleteHashUserSmsByIds(String[] ids)
    {
        return hashUserSmsMapper.deleteHashUserSmsByIds(ids);
    }

    /**
     * 删除用户短信功能信息
     * 
     * @param id 用户短信功能主键
     * @return 结果
     */
    @Override
    public int deleteHashUserSmsById(String id)
    {
        return hashUserSmsMapper.deleteHashUserSmsById(id);
    }
}
