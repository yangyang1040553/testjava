package com.ruoyi.operation.controller;

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
import com.ruoyi.operation.domain.GameOperationActivity;
import com.ruoyi.operation.service.IGameOperationActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运营活动Controller
 * 
 * @author xxk
 * @date 2022-06-26
 */
@RestController
@RequestMapping("/hash-operation/activity")
public class GameOperationActivityController extends BaseController
{
    @Autowired
    private IGameOperationActivityService gameOperationActivityService;

    /**
     * 查询运营活动列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameOperationActivity gameOperationActivity)
    {
        startPage();
        List<GameOperationActivity> list = gameOperationActivityService.selectGameOperationActivityList(gameOperationActivity);
        return getDataTable(list);
    }

    /**
     * 导出运营活动列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:export')")
    @Log(title = "运营活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameOperationActivity gameOperationActivity)
    {
        startOrderBy();
        List<GameOperationActivity> list = gameOperationActivityService.selectGameOperationActivityList(gameOperationActivity);
        ExcelUtil<GameOperationActivity> util = new ExcelUtil<GameOperationActivity>(GameOperationActivity.class);
        util.exportExcel(response, list, "运营活动数据");
    }

    /**
     * 获取运营活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gameOperationActivityService.selectGameOperationActivityById(id));
    }

    /**
     * 新增运营活动
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:add')")
    @Log(title = "运营活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameOperationActivity gameOperationActivity)
    {
        return toAjax(gameOperationActivityService.insertGameOperationActivity(gameOperationActivity));
    }

    /**
     * 修改运营活动
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:edit')")
    @Log(title = "运营活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameOperationActivity gameOperationActivity)
    {
        return toAjax(gameOperationActivityService.updateGameOperationActivity(gameOperationActivity));
    }

    /**
     * 删除运营活动
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:activity:remove')")
    @Log(title = "运营活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gameOperationActivityService.deleteGameOperationActivityByIds(ids));
    }
}
