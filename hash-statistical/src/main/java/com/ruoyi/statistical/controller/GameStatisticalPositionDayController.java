package com.ruoyi.statistical.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.statistical.domain.GameStatisticalDay;
import com.ruoyi.statistical.domain.GameStatisticalPositionDay;
import com.ruoyi.statistical.service.IGameStatisticalPositionDayService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏押注位置日统计Controller
 * 
 * @author xxk
 * @date 2022-05-27
 */
@RestController
@RequestMapping("/hash-statistical/gameStatistcalDay")
public class GameStatisticalPositionDayController extends BaseController
{
    @Autowired
    private IGameStatisticalPositionDayService gameStatisticalPositionDayService;

    /**
     * 查询游戏押注位置日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalPositionDay gameStatisticalPositionDay)
    {
        startPage();
        startOrderBy();
        List<GameStatisticalPositionDay> list = gameStatisticalPositionDayService.selectGameStatisticalPositionDayList(gameStatisticalPositionDay);
        return getDataTable(list);
    }

    /**
     * 导出游戏押注位置日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:export')")
    @Log(title = "游戏押注位置日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalPositionDay gameStatisticalPositionDay)
    {
        startOrderBy();
        List<GameStatisticalPositionDay> list = gameStatisticalPositionDayService.selectGameStatisticalPositionDayList(gameStatisticalPositionDay);
        for (GameStatisticalPositionDay statisticalDay : list) {
            statisticalDay.setTrxAwardAmount(statisticalDay.getTrxAwardAmount());
            statisticalDay.setTrxBetAmount(statisticalDay.getTrxBetAmount());

            statisticalDay.setUsdtAwardAmount(statisticalDay.getUsdtAwardAmount());
            statisticalDay.setUsdtBetAmount(statisticalDay.getUsdtBetAmount());
        }
        ExcelUtil<GameStatisticalPositionDay> util = new ExcelUtil<GameStatisticalPositionDay>(GameStatisticalPositionDay.class);
        util.exportExcel(response, list, "游戏押注位置日统计数据");
    }

    /**
     * 获取游戏押注位置日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameStatisticalPositionDayService.selectGameStatisticalPositionDayById(id));
    }

    /**
     * 新增游戏押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:add')")
    @Log(title = "游戏押注位置日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalPositionDay gameStatisticalPositionDay)
    {
        return toAjax(gameStatisticalPositionDayService.insertGameStatisticalPositionDay(gameStatisticalPositionDay));
    }

    /**
     * 修改游戏押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:edit')")
    @Log(title = "游戏押注位置日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalPositionDay gameStatisticalPositionDay)
    {
        return toAjax(gameStatisticalPositionDayService.updateGameStatisticalPositionDay(gameStatisticalPositionDay));
    }

    /**
     * 删除游戏押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameStatistcalDay:remove')")
    @Log(title = "游戏押注位置日统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameStatisticalPositionDayService.deleteGameStatisticalPositionDayByIds(ids));
    }
}
