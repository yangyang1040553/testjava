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
import com.ruoyi.statistical.domain.GameStatisticalPlayerDay;
import com.ruoyi.statistical.service.IGameStatisticalPlayerDayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏玩家日统计Controller
 *
 * @author xxk
 * @date 2022-05-27
 */
@RestController
@RequestMapping("/hash-statistical/statisticalUserDay")
public class GameStatisticalPlayerDayController extends BaseController {
    @Autowired
    private IGameStatisticalPlayerDayService gameStatisticalPlayerDayService;

    /**
     * 查询游戏玩家日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        startPage();
        startOrderBy();
        List<GameStatisticalPlayerDay> list = gameStatisticalPlayerDayService.selectGameStatisticalPlayerDayList(gameStatisticalPlayerDay);
        return getDataTable(list);
    }


    /**
     * 查询游戏玩家日统计列表
     */
//    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:list')")
    @GetMapping("/childrenList")
    public TableDataInfo childrenList(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        List<GameStatisticalPlayerDay> list = gameStatisticalPlayerDayService.selectDetailChildrenList(gameStatisticalPlayerDay);
        return getDataTable(list);
    }


    /**
     * 导出游戏玩家日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:export')")
    @Log(title = "游戏玩家日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        startOrderBy();
        List<GameStatisticalPlayerDay> list = gameStatisticalPlayerDayService.selectGameStatisticalPlayerDayList(gameStatisticalPlayerDay);
        for (GameStatisticalPlayerDay statisticalPlayerDay : list) {
            statisticalPlayerDay.setTrxAwardAmount(statisticalPlayerDay.getTrxAwardAmount());
            statisticalPlayerDay.setTrxBetAmount(statisticalPlayerDay.getTrxBetAmount());

            statisticalPlayerDay.setUsdtAwardAmount(statisticalPlayerDay.getUsdtAwardAmount());
            statisticalPlayerDay.setUsdtBetAmount(statisticalPlayerDay.getUsdtBetAmount());
        }
        ExcelUtil<GameStatisticalPlayerDay> util = new ExcelUtil<GameStatisticalPlayerDay>(GameStatisticalPlayerDay.class);
        util.exportExcel(response, list, "游戏玩家日统计数据");
    }

    /**
     * 获取游戏玩家日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gameStatisticalPlayerDayService.selectGameStatisticalPlayerDayById(id));
    }

    /**
     * 新增游戏玩家日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:add')")
    @Log(title = "游戏玩家日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        return toAjax(gameStatisticalPlayerDayService.insertGameStatisticalPlayerDay(gameStatisticalPlayerDay));
    }

    /**
     * 修改游戏玩家日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:edit')")
    @Log(title = "游戏玩家日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        return toAjax(gameStatisticalPlayerDayService.updateGameStatisticalPlayerDay(gameStatisticalPlayerDay));
    }

    /**
     * 删除游戏玩家日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalUserDay:remove')")
    @Log(title = "游戏玩家日统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gameStatisticalPlayerDayService.deleteGameStatisticalPlayerDayByIds(ids));
    }
}
