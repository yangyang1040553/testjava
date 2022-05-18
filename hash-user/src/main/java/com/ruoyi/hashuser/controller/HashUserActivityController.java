package com.ruoyi.hashuser.controller;

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
import com.ruoyi.hashuser.domain.HashUserActivity;
import com.ruoyi.hashuser.service.IHashUserActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户的活动Controller
 * 
 * @author xxk
 * @date 2022-05-11
 */
@RestController
@RequestMapping("/hash-user/activity")
public class HashUserActivityController extends BaseController
{
    @Autowired
    private IHashUserActivityService hashUserActivityService;

    /**
     * 查询用户的活动列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUserActivity hashUserActivity)
    {
        startPage();
        startOrderBy();
        List<HashUserActivity> list = hashUserActivityService.selectHashUserActivityList(hashUserActivity);
        return getDataTable(list);
    }

    /**
     * 导出用户的活动列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:export')")
    @Log(title = "用户的活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUserActivity hashUserActivity)
    {
        List<HashUserActivity> list = hashUserActivityService.selectHashUserActivityList(hashUserActivity);
        ExcelUtil<HashUserActivity> util = new ExcelUtil<HashUserActivity>(HashUserActivity.class);
        util.exportExcel(response, list, "用户的活动数据");
    }

    /**
     * 获取用户的活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hashUserActivityService.selectHashUserActivityById(id));
    }

    /**
     * 新增用户的活动
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:add')")
    @Log(title = "用户的活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUserActivity hashUserActivity)
    {
        return toAjax(hashUserActivityService.insertHashUserActivity(hashUserActivity));
    }

    /**
     * 修改用户的活动
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:edit')")
    @Log(title = "用户的活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUserActivity hashUserActivity)
    {
        return toAjax(hashUserActivityService.updateHashUserActivity(hashUserActivity));
    }

    /**
     * 删除用户的活动
     */
    @PreAuthorize("@ss.hasPermi('hash-user:activity:remove')")
    @Log(title = "用户的活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hashUserActivityService.deleteHashUserActivityByIds(ids));
    }
}
