package com.ruoyi.hashUser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hashUser.mapper.VideoCollectMapper;
import com.ruoyi.hashUser.domain.VideoCollect;
import com.ruoyi.hashUser.service.IVideoCollectService;

/**
 * 视频收藏Service业务层处理
 * 
 * @author xxk
 * @date 2023-01-05
 */
@Service
public class VideoCollectServiceImpl implements IVideoCollectService 
{
    @Autowired
    private VideoCollectMapper videoCollectMapper;

    /**
     * 查询视频收藏
     * 
     * @param id 视频收藏主键
     * @return 视频收藏
     */
    @Override
    public VideoCollect selectVideoCollectById(Long id)
    {
        return videoCollectMapper.selectVideoCollectById(id);
    }

    /**
     * 查询视频收藏列表
     * 
     * @param videoCollect 视频收藏
     * @return 视频收藏
     */
    @Override
    public List<VideoCollect> selectVideoCollectList(VideoCollect videoCollect)
    {
        return videoCollectMapper.selectVideoCollectList(videoCollect);
    }

    /**
     * 新增视频收藏
     * 
     * @param videoCollect 视频收藏
     * @return 结果
     */
    @Override
    public int insertVideoCollect(VideoCollect videoCollect)
    {
        videoCollect.setCreateTime(DateUtils.getNowDate());
        return videoCollectMapper.insertVideoCollect(videoCollect);
    }

    /**
     * 修改视频收藏
     * 
     * @param videoCollect 视频收藏
     * @return 结果
     */
    @Override
    public int updateVideoCollect(VideoCollect videoCollect)
    {
        return videoCollectMapper.updateVideoCollect(videoCollect);
    }

    /**
     * 批量删除视频收藏
     * 
     * @param ids 需要删除的视频收藏主键
     * @return 结果
     */
    @Override
    public int deleteVideoCollectByIds(Long[] ids)
    {
        return videoCollectMapper.deleteVideoCollectByIds(ids);
    }

    /**
     * 删除视频收藏信息
     * 
     * @param id 视频收藏主键
     * @return 结果
     */
    @Override
    public int deleteVideoCollectById(Long id)
    {
        return videoCollectMapper.deleteVideoCollectById(id);
    }
}
