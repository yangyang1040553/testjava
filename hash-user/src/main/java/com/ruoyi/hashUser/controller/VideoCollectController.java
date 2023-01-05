package com.ruoyi.hashUser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hashUser.domain.VideoCollect;
import com.ruoyi.hashUser.service.IVideoCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频收藏Controller
 * 
 * @author xxk
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/hashUser/collect")
public class VideoCollectController extends BaseController
{
    @Autowired
    private IVideoCollectService videoCollectService;

    /**
     * 查询视频收藏列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:list')")
    @GetMapping("/list")
    public TableDataInfo list(VideoCollect videoCollect)
    {
        startPage();
        List<VideoCollect> list = videoCollectService.selectVideoCollectList(videoCollect);
        return getDataTable(list);
    }

    /**
     * 导出视频收藏列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:export')")
    @Log(title = "视频收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VideoCollect videoCollect)
    {
        startOrderBy();
        List<VideoCollect> list = videoCollectService.selectVideoCollectList(videoCollect);
        ExcelUtil<VideoCollect> util = new ExcelUtil<VideoCollect>(VideoCollect.class);
        util.exportExcel(response, list, "视频收藏数据");
    }

    /**
     * 获取视频收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(videoCollectService.selectVideoCollectById(id));
    }

    /**
     * 新增视频收藏
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:add')")
    @Log(title = "视频收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VideoCollect videoCollect)
    {
        return toAjax(videoCollectService.insertVideoCollect(videoCollect));
    }

    /**
     * 修改视频收藏
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:edit')")
    @Log(title = "视频收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VideoCollect videoCollect)
    {
        return toAjax(videoCollectService.updateVideoCollect(videoCollect));
    }

    /**
     * 删除视频收藏
     */
    @PreAuthorize("@ss.hasPermi('hashUser:collect:remove')")
    @Log(title = "视频收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(videoCollectService.deleteVideoCollectByIds(ids));
    }
}
