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
import com.ruoyi.operation.domain.DkDomainList;
import com.ruoyi.operation.service.IDkDomainListService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 对抗域名列Controller
 * 
 * @author xxk
 * @date 2022-07-27
 */
@RestController
@RequestMapping("/hash-operation/domanList")
public class DkDomainListController extends BaseController
{
    @Autowired
    private IDkDomainListService dkDomainListService;

    /**
     * 查询对抗域名列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:list')")
    @GetMapping("/list")
    public TableDataInfo list(DkDomainList dkDomainList)
    {
        startPage();
        List<DkDomainList> list = dkDomainListService.selectDkDomainListList(dkDomainList);
        return getDataTable(list);
    }

    /**
     * 导出对抗域名列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:export')")
    @Log(title = "对抗域名列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DkDomainList dkDomainList)
    {
        startOrderBy();
        List<DkDomainList> list = dkDomainListService.selectDkDomainListList(dkDomainList);
        ExcelUtil<DkDomainList> util = new ExcelUtil<DkDomainList>(DkDomainList.class);
        util.exportExcel(response, list, "对抗域名列数据");
    }

    /**
     * 获取对抗域名列详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dkDomainListService.selectDkDomainListById(id));
    }

    /**
     * 新增对抗域名列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:add')")
    @Log(title = "对抗域名列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DkDomainList dkDomainList)
    {
        return toAjax(dkDomainListService.insertDkDomainList(dkDomainList));
    }

    /**
     * 修改对抗域名列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:edit')")
    @Log(title = "对抗域名列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DkDomainList dkDomainList)
    {
        return toAjax(dkDomainListService.updateDkDomainList(dkDomainList));
    }

    /**
     * 删除对抗域名列
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:domanList:remove')")
    @Log(title = "对抗域名列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dkDomainListService.deleteDkDomainListByIds(ids));
    }
}
