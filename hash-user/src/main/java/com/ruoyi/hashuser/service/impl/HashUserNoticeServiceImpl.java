package com.ruoyi.hashuser.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.HashUserNoticeMapper;
import com.ruoyi.hashuser.domain.HashUserNotice;
import com.ruoyi.hashuser.service.IHashUserNoticeService;

/**
 * 用户公告Service业务层处理
 *
 * @author xxk
 * @date 2022-05-10
 */
@Service
public class HashUserNoticeServiceImpl implements IHashUserNoticeService {
    @Autowired
    private HashUserNoticeMapper hashUserNoticeMapper;

    /**
     * 查询用户公告
     *
     * @param id 用户公告主键
     * @return 用户公告
     */
    @Override
    public HashUserNotice selectHashUserNoticeById(String id) {
        return hashUserNoticeMapper.selectHashUserNoticeById(id);
    }

    /**
     * 查询用户公告列表
     *
     * @param hashUserNotice 用户公告
     * @return 用户公告
     */
    @Override
    public List<HashUserNotice> selectHashUserNoticeList(HashUserNotice hashUserNotice) {
        return hashUserNoticeMapper.selectHashUserNoticeList(hashUserNotice);
    }

    /**
     * 新增用户公告
     *
     * @param hashUserNotice 用户公告
     * @return 结果
     */
    @Override
    public int insertHashUserNotice(HashUserNotice hashUserNotice) {
        hashUserNotice.setCreateTime(DateUtils.getNowDate());
        hashUserNotice.setId(IdUtils.getID12Str());
        return hashUserNoticeMapper.insertHashUserNotice(hashUserNotice);
    }

    /**
     * 修改用户公告
     *
     * @param hashUserNotice 用户公告
     * @return 结果
     */
    @Override
    public int updateHashUserNotice(HashUserNotice hashUserNotice) {
        hashUserNotice.setUpdateTime(DateUtils.getNowDate());
        return hashUserNoticeMapper.updateHashUserNotice(hashUserNotice);
    }

    /**
     * 批量删除用户公告
     *
     * @param ids 需要删除的用户公告主键
     * @return 结果
     */
    @Override
    public int deleteHashUserNoticeByIds(String[] ids) {
        return hashUserNoticeMapper.deleteHashUserNoticeByIds(ids);
    }

    /**
     * 删除用户公告信息
     *
     * @param id 用户公告主键
     * @return 结果
     */
    @Override
    public int deleteHashUserNoticeById(String id) {
        return hashUserNoticeMapper.deleteHashUserNoticeById(id);
    }
}
