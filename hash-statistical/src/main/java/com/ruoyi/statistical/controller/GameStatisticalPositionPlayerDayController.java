package com.ruoyi.statistical.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.statistical.domain.GameStatisticalPositionDay;
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
import com.ruoyi.statistical.domain.GameStatisticalPositionPlayerDay;
import com.ruoyi.statistical.service.IGameStatisticalPositionPlayerDayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏玩家押注位置日统计Controller
 * 
 * @author xxk
 * @date 2022-05-27
 */
@RestController
@RequestMapping("/hash-statistical/statisticalPlayerPosition")
public class GameStatisticalPositionPlayerDayController extends BaseController
{
    @Autowired
    private IGameStatisticalPositionPlayerDayService gameStatisticalPositionPlayerDayService;

    /**
     * 查询游戏玩家押注位置日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay)
    {
        startPage();
        startOrderBy();
        List<GameStatisticalPositionPlayerDay> list = gameStatisticalPositionPlayerDayService.selectGameStatisticalPositionPlayerDayList(gameStatisticalPositionPlayerDay);
        return getDataTable(list);
    }

    /**
     * 导出游戏玩家押注位置日统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:export')")
    @Log(title = "游戏玩家押注位置日统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay)
    {
        startOrderBy();
        List<GameStatisticalPositionPlayerDay> list = gameStatisticalPositionPlayerDayService.selectGameStatisticalPositionPlayerDayList(gameStatisticalPositionPlayerDay);
        for (GameStatisticalPositionPlayerDay statisticalDay : list) {
            statisticalDay.setTrxAwardAmount(statisticalDay.getTrxAwardAmount());
            statisticalDay.setTrxBetAmount(statisticalDay.getTrxBetAmount());

            statisticalDay.setUsdtAwardAmount(statisticalDay.getUsdtAwardAmount());
            statisticalDay.setUsdtBetAmount(statisticalDay.getUsdtBetAmount());

            statisticalDay.setUsdtWin(statisticalDay.getUsdtWin());
            statisticalDay.setTrxWin(statisticalDay.getTrxWin());
        }
        ExcelUtil<GameStatisticalPositionPlayerDay> util = new ExcelUtil<GameStatisticalPositionPlayerDay>(GameStatisticalPositionPlayerDay.class);
        util.exportExcel(response, list, "游戏玩家押注位置日统计数据");
    }

    /**
     * 获取游戏玩家押注位置日统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameStatisticalPositionPlayerDayService.selectGameStatisticalPositionPlayerDayById(id));
    }

    /**
     * 新增游戏玩家押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:add')")
    @Log(title = "游戏玩家押注位置日统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay)
    {
        return toAjax(gameStatisticalPositionPlayerDayService.insertGameStatisticalPositionPlayerDay(gameStatisticalPositionPlayerDay));
    }

    /**
     * 修改游戏玩家押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:edit')")
    @Log(title = "游戏玩家押注位置日统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay)
    {
        return toAjax(gameStatisticalPositionPlayerDayService.updateGameStatisticalPositionPlayerDay(gameStatisticalPositionPlayerDay));
    }

    /**
     * 删除游戏玩家押注位置日统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalPlayerPosition:remove')")
    @Log(title = "游戏玩家押注位置日统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameStatisticalPositionPlayerDayService.deleteGameStatisticalPositionPlayerDayByIds(ids));
    }
}
