package com.ruoyi.hashuser.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashuser.mapper.UserVersionMapper;
import com.ruoyi.hashuser.domain.UserVersion;
import com.ruoyi.hashuser.service.IUserVersionService;

/**
 * 版本更新Service业务层处理
 *
 * @author xxk
 * @date 2022-06-27
 */
@Service
public class UserVersionServiceImpl implements IUserVersionService {
    @Autowired
    private UserVersionMapper userVersionMapper;

    /**
     * 查询版本更新
     *
     * @param id 版本更新主键
     * @return 版本更新
     */
    @Override
    public UserVersion selectUserVersionById(Long id) {
        return userVersionMapper.selectUserVersionById(id);
    }

    /**
     * 查询版本更新列表
     *
     * @param userVersion 版本更新
     * @return 版本更新
     */
    @Override
    public List<UserVersion> selectUserVersionList(UserVersion userVersion) {
        return userVersionMapper.selectUserVersionList(userVersion);
    }

    /**
     * 新增版本更新
     *
     * @param userVersion 版本更新
     * @return 结果
     */
    @Override
    public int insertUserVersion(UserVersion userVersion) {
        UserVersion user = userVersionMapper.selectUserVersionByVersion(userVersion.getVersion());
        if (user != null) {
            return -1;
        }
        userVersion.setCreateTime(DateUtils.getNowDate());
        return userVersionMapper.insertUserVersion(userVersion);
    }

    /**
     * 修改版本更新
     *
     * @param userVersion 版本更新
     * @return 结果
     */
    @Override
    public int updateUserVersion(UserVersion userVersion) {
        userVersion.setUpdateTime(DateUtils.getNowDate());
        return userVersionMapper.updateUserVersion(userVersion);
    }

    /**
     * 批量删除版本更新
     *
     * @param ids 需要删除的版本更新主键
     * @return 结果
     */
    @Override
    public int deleteUserVersionByIds(Long[] ids) {
        return userVersionMapper.deleteUserVersionByIds(ids);
    }

    /**
     * 删除版本更新信息
     *
     * @param id 版本更新主键
     * @return 结果
     */
    @Override
    public int deleteUserVersionById(Long id) {
        return userVersionMapper.deleteUserVersionById(id);
    }
}
