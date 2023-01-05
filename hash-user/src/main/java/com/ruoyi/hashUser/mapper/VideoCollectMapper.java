package com.ruoyi.hashUser.mapper;

import java.util.List;
import com.ruoyi.hashUser.domain.VideoCollect;

/**
 * 视频收藏Mapper接口
 * 
 * @author xxk
 * @date 2023-01-05
 */
public interface VideoCollectMapper 
{
    /**
     * 查询视频收藏
     * 
     * @param id 视频收藏主键
     * @return 视频收藏
     */
    public VideoCollect selectVideoCollectById(Long id);

    /**
     * 查询视频收藏列表
     * 
     * @param videoCollect 视频收藏
     * @return 视频收藏集合
     */
    public List<VideoCollect> selectVideoCollectList(VideoCollect videoCollect);

    /**
     * 新增视频收藏
     * 
     * @param videoCollect 视频收藏
     * @return 结果
     */
    public int insertVideoCollect(VideoCollect videoCollect);

    /**
     * 修改视频收藏
     * 
     * @param videoCollect 视频收藏
     * @return 结果
     */
    public int updateVideoCollect(VideoCollect videoCollect);

    /**
     * 删除视频收藏
     * 
     * @param id 视频收藏主键
     * @return 结果
     */
    public int deleteVideoCollectById(Long id);

    /**
     * 批量删除视频收藏
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVideoCollectByIds(Long[] ids);
}
