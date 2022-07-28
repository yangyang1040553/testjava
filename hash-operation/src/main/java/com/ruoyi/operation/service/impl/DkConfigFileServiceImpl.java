package com.ruoyi.operation.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.DkConfigFileMapper;
import com.ruoyi.operation.domain.DkConfigFile;
import com.ruoyi.operation.service.IDkConfigFileService;

/**
 * 对抗配置文件Service业务层处理
 *
 * @author xxk
 * @date 2022-07-27
 */
@Service
public class DkConfigFileServiceImpl implements IDkConfigFileService {
    @Autowired
    private DkConfigFileMapper dkConfigFileMapper;

    /**
     * 查询对抗配置文件
     *
     * @param id 对抗配置文件主键
     * @return 对抗配置文件
     */
    @Override
    public DkConfigFile selectDkConfigFileById(Long id) {
        return dkConfigFileMapper.selectDkConfigFileById(id);
    }

    /**
     * 查询对抗配置文件列表
     *
     * @param dkConfigFile 对抗配置文件
     * @return 对抗配置文件
     */
    @Override
    public List<DkConfigFile> selectDkConfigFileList(DkConfigFile dkConfigFile) {
        return dkConfigFileMapper.selectDkConfigFileList(dkConfigFile);
    }

    /**
     * 新增对抗配置文件
     *
     * @param dkConfigFile 对抗配置文件
     * @return 结果
     */
    @Override
    public int insertDkConfigFile(DkConfigFile dkConfigFile) {
        dkConfigFile.setCreateTime(DateUtils.getNowDate());
        return dkConfigFileMapper.insertDkConfigFile(dkConfigFile);
    }

    /**
     * 修改对抗配置文件
     *
     * @param dkConfigFile 对抗配置文件
     * @return 结果
     */
    @Override
    public int updateDkConfigFile(DkConfigFile dkConfigFile) {
        return dkConfigFileMapper.updateDkConfigFile(dkConfigFile);
    }

    /**
     * 批量删除对抗配置文件
     *
     * @param ids 需要删除的对抗配置文件主键
     * @return 结果
     */
    @Override
    public int deleteDkConfigFileByIds(Long[] ids) {
        return dkConfigFileMapper.deleteDkConfigFileByIds(ids);
    }

    /**
     * 删除对抗配置文件信息
     *
     * @param id 对抗配置文件主键
     * @return 结果
     */
    @Override
    public int deleteDkConfigFileById(Long id) {
        return dkConfigFileMapper.deleteDkConfigFileById(id);
    }
}
