package com.ruoyi.statistical.controller;

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
import com.ruoyi.statistical.domain.Keep;
import com.ruoyi.statistical.service.IKeepService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 留存分析Controller
 * 
 * @author xxk
 * @date 2022-05-27
 */
@RestController
@RequestMapping("/hash-statistical/keepAlive")
public class KeepController extends BaseController
{
    @Autowired
    private IKeepService keepService;

    /**
     * 查询留存分析列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:list')")
    @GetMapping("/list")
    public TableDataInfo list(Keep keep)
    {
        startPage();
        List<Keep> list = keepService.selectKeepList(keep);
        return getDataTable(list);
    }

    /**
     * 导出留存分析列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:export')")
    @Log(title = "留存分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Keep keep)
    {
        List<Keep> list = keepService.selectKeepList(keep);
        ExcelUtil<Keep> util = new ExcelUtil<Keep>(Keep.class);
        util.exportExcel(response, list, "留存分析数据");
    }

    /**
     * 获取留存分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:query')")
    @GetMapping(value = "/{registerTime}")
    public AjaxResult getInfo(@PathVariable("registerTime") String registerTime)
    {
        return AjaxResult.success(keepService.selectKeepByRegisterTime(registerTime));
    }

    /**
     * 新增留存分析
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:add')")
    @Log(title = "留存分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Keep keep)
    {
        return toAjax(keepService.insertKeep(keep));
    }

    /**
     * 修改留存分析
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:edit')")
    @Log(title = "留存分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Keep keep)
    {
        return toAjax(keepService.updateKeep(keep));
    }

    /**
     * 删除留存分析
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:keepAlive:remove')")
    @Log(title = "留存分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registerTimes}")
    public AjaxResult remove(@PathVariable String[] registerTimes)
    {
        return toAjax(keepService.deleteKeepByRegisterTimes(registerTimes));
    }
}
