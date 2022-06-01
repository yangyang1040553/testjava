package com.ruoyi.statistical.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.statistical.domain.GameStatisticalDay;
import com.ruoyi.statistical.service.IGameStatisticalDayService;
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
 * 游戏日统计Controller
 *
 * @author xxk
 * @date 2022-05-26
 */
@RestController
@RequestMapping("/hash-statistical/statisticalGame")
public class GameStatisticalDayController extends BaseController {
    @Autowired
    private IGameStatisticalDayService gameStatisticalDayService;

    /**
     * 查询游戏日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalGame:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalDay gameStatisticalDay) {
        startPage();
        startOrderBy();
        List<GameStatisticalDay> list = gameStatisticalDayService.selectGameStatisticalDayList(gameStatisticalDay);
        return getDataTable(list);
    }


    /**
     * 查询游戏日统计列表
     */
    @GetMapping("/childList")
    public TableDataInfo childList(GameStatisticalDay gameStatisticalDay) {
        List<GameStatisticalDay> list = gameStatisticalDayService.selectGameChildrenList(gameStatisticalDay);
        return getDataTable(list);
    }

    /**
     * 导出游戏日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalGame:export')")
    @Log(title = "游戏日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalDay gameStatisticalDay) {
        List<GameStatisticalDay> list = gameStatisticalDayService.selectGameStatisticalDayList(gameStatisticalDay);
        ExcelUtil<GameStatisticalDay> util = new ExcelUtil<GameStatisticalDay>(GameStatisticalDay.class);
        util.exportExcel(response, list, "游戏日统计数据");
    }

    /**
     * 获取游戏日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalGame:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gameStatisticalDayService.selectGameStatisticalDayById(id));
    }

    /**
     * 新增游戏日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-game:statisticalGame:add')")
    @Log(title = "游戏日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalDay gameStatisticalDay) {
        return toAjax(gameStatisticalDayService.insertGameStatisticalDay(gameStatisticalDay));
    }

    /**
     * 修改游戏日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalGame:edit')")
    @Log(title = "游戏日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalDay gameStatisticalDay) {
        return toAjax(gameStatisticalDayService.updateGameStatisticalDay(gameStatisticalDay));
    }

    /**
     * 删除游戏日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalGame:remove')")
    @Log(title = "游戏日统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gameStatisticalDayService.deleteGameStatisticalDayByIds(ids));
    }
}
