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
import com.ruoyi.statistical.domain.StatisticalPromote;
import com.ruoyi.statistical.service.IStatisticalPromoteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author xxk
 * @date 2022-05-28
 */
@RestController
@RequestMapping("/hash-statistical/promoteLeaderboard")
public class StatisticalPromoteController extends BaseController
{
    @Autowired
    private IStatisticalPromoteService statisticalPromoteService;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:list')")
    @GetMapping("/list")
    public TableDataInfo list(StatisticalPromote statisticalPromote)
    {
        startPage();
        startOrderBy();
        List<StatisticalPromote> list = statisticalPromoteService.selectStatisticalPromoteList(statisticalPromote);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StatisticalPromote statisticalPromote)
    {
        startOrderBy();
        List<StatisticalPromote> list = statisticalPromoteService.selectStatisticalPromoteList(statisticalPromote);
        ExcelUtil<StatisticalPromote> util = new ExcelUtil<StatisticalPromote>(StatisticalPromote.class);
        util.exportExcel(response, list, "VIEW数据");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(statisticalPromoteService.selectStatisticalPromoteById(id));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StatisticalPromote statisticalPromote)
    {
        return toAjax(statisticalPromoteService.insertStatisticalPromote(statisticalPromote));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StatisticalPromote statisticalPromote)
    {
        return toAjax(statisticalPromoteService.updateStatisticalPromote(statisticalPromote));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:promoteLeaderboard:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(statisticalPromoteService.deleteStatisticalPromoteByIds(ids));
    }
}
