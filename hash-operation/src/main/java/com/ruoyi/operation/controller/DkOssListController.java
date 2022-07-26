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
import com.ruoyi.operation.domain.DkOssList;
import com.ruoyi.operation.service.IDkOssListService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对抗存储列Controller
 * 
 * @author xxk
 * @date 2022-07-26
 */
@RestController
@RequestMapping("/hash-operation/dkOss")
public class DkOssListController extends BaseController
{
    @Autowired
    private IDkOssListService dkOssListService;

    /**
     * 查询对抗存储列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:list')")
    @GetMapping("/list")
    public TableDataInfo list(DkOssList dkOssList)
    {
        startPage();
        List<DkOssList> list = dkOssListService.selectDkOssListList(dkOssList);
        return getDataTable(list);
    }

    /**
     * 导出对抗存储列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:export')")
    @Log(title = "对抗存储列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DkOssList dkOssList)
    {
        startOrderBy();
        List<DkOssList> list = dkOssListService.selectDkOssListList(dkOssList);
        ExcelUtil<DkOssList> util = new ExcelUtil<DkOssList>(DkOssList.class);
        util.exportExcel(response, list, "对抗存储列数据");
    }

    /**
     * 获取对抗存储列详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dkOssListService.selectDkOssListById(id));
    }

    /**
     * 新增对抗存储列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:add')")
    @Log(title = "对抗存储列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DkOssList dkOssList)
    {
        return toAjax(dkOssListService.insertDkOssList(dkOssList));
    }

    /**
     * 修改对抗存储列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:edit')")
    @Log(title = "对抗存储列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DkOssList dkOssList)
    {
        return toAjax(dkOssListService.updateDkOssList(dkOssList));
    }

    /**
     * 删除对抗存储列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:dkOss:remove')")
    @Log(title = "对抗存储列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dkOssListService.deleteDkOssListByIds(ids));
    }
}
