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
import com.ruoyi.statistical.domain.GameStatisticalPromoteIncome;
import com.ruoyi.statistical.service.IGameStatisticalPromoteIncomeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 代理每日收益金额Controller
 * 
 * @author xxk
 * @date 2022-06-05
 */
@RestController
@RequestMapping("/hash-statistical/prototeIncome")
public class GameStatisticalPromoteIncomeController extends BaseController
{
    @Autowired
    private IGameStatisticalPromoteIncomeService gameStatisticalPromoteIncomeService;

    /**
     * 查询代理每日收益金额列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        startPage();
        startOrderBy();
        List<GameStatisticalPromoteIncome> list = gameStatisticalPromoteIncomeService.selectGameStatisticalPromoteIncomeList(gameStatisticalPromoteIncome);
        return getDataTable(list);
    }

    /**
     * 导出代理每日收益金额列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:export')")
    @Log(title = "代理每日收益金额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        List<GameStatisticalPromoteIncome> list = gameStatisticalPromoteIncomeService.selectGameStatisticalPromoteIncomeList(gameStatisticalPromoteIncome);
        ExcelUtil<GameStatisticalPromoteIncome> util = new ExcelUtil<GameStatisticalPromoteIncome>(GameStatisticalPromoteIncome.class);
        util.exportExcel(response, list, "代理每日收益金额数据");
    }

    /**
     * 获取代理每日收益金额详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameStatisticalPromoteIncomeService.selectGameStatisticalPromoteIncomeById(id));
    }

    /**
     * 新增代理每日收益金额
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:add')")
    @Log(title = "代理每日收益金额", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        return toAjax(gameStatisticalPromoteIncomeService.insertGameStatisticalPromoteIncome(gameStatisticalPromoteIncome));
    }

    /**
     * 修改代理每日收益金额
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:edit')")
    @Log(title = "代理每日收益金额", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalPromoteIncome gameStatisticalPromoteIncome)
    {
        return toAjax(gameStatisticalPromoteIncomeService.updateGameStatisticalPromoteIncome(gameStatisticalPromoteIncome));
    }

    /**
     * 删除代理每日收益金额
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:prototeIncome:remove')")
    @Log(title = "代理每日收益金额", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameStatisticalPromoteIncomeService.deleteGameStatisticalPromoteIncomeByIds(ids));
    }
}
