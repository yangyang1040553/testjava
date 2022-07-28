package com.ruoyi.operation.mapper;

import java.util.List;
import com.ruoyi.operation.domain.DkConfigFile;

/**
 * 对抗配置文件Mapper接口
 * 
 * @author xxk
 * @date 2022-07-27
 */
public interface DkConfigFileMapper 
{
    /**
     * 查询对抗配置文件
     * 
     * @param id 对抗配置文件主键
     * @return 对抗配置文件
     */
    public DkConfigFile selectDkConfigFileById(Long id);

    /**
     * 查询对抗配置文件列表
     * 
     * @param dkConfigFile 对抗配置文件
     * @return 对抗配置文件集合
     */
    public List<DkConfigFile> selectDkConfigFileList(DkConfigFile dkConfigFile);

    /**
     * 新增对抗配置文件
     * 
     * @param dkConfigFile 对抗配置文件
     * @return 结果
     */
    public int insertDkConfigFile(DkConfigFile dkConfigFile);

    /**
     * 修改对抗配置文件
     * 
     * @param dkConfigFile 对抗配置文件
     * @return 结果
     */
    public int updateDkConfigFile(DkConfigFile dkConfigFile);

    /**
     * 删除对抗配置文件
     * 
     * @param id 对抗配置文件主键
     * @return 结果
     */
    public int deleteDkConfigFileById(Long id);

    /**
     * 批量删除对抗配置文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDkConfigFileByIds(Long[] ids);
}
