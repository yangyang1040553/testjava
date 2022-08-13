package com.ruoyi.statistical.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.statistical.domain.GameStatisticalPlayerDay;
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
import com.ruoyi.statistical.domain.GameStatisticalPlayerWin;
import com.ruoyi.statistical.service.IGameStatisticalPlayerWinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 玩家输赢Controller
 *
 * @author xxk
 * @date 2022-06-01
 */
@RestController
@RequestMapping("/hash-statistical/win")
public class GameStatisticalPlayerWinController extends BaseController {
    @Autowired
    private IGameStatisticalPlayerWinService gameStatisticalPlayerWinService;

    /**
     * 查询玩家输赢列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalPlayerWin gameStatisticalPlayerWin) {
        startPage();
        startOrderBy();
        List<GameStatisticalPlayerWin> list = gameStatisticalPlayerWinService.selectGameStatisticalPlayerWinList(gameStatisticalPlayerWin);
        return getDataTable(list);
    }

    /**
     * 导出玩家输赢列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:export')")
    @Log(title = "玩家输赢", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalPlayerWin gameStatisticalPlayerWin) {
        startOrderBy();
        List<GameStatisticalPlayerWin> list = gameStatisticalPlayerWinService.selectGameStatisticalPlayerWinList(gameStatisticalPlayerWin);
        for (GameStatisticalPlayerWin statisticalPlayerWin : list) {
            statisticalPlayerWin.setTrxBetAmount(statisticalPlayerWin.getTrxBetAmount());
            statisticalPlayerWin.setTrxAwardAmount(statisticalPlayerWin.getTrxAwardAmount());
            statisticalPlayerWin.setTrxWinAmount(statisticalPlayerWin.getTrxWinAmount());

            statisticalPlayerWin.setUsdtBetAmount(statisticalPlayerWin.getUsdtBetAmount());
            statisticalPlayerWin.setUsdtAwardAmount(statisticalPlayerWin.getUsdtAwardAmount());
            statisticalPlayerWin.setUsdtWinAmount(statisticalPlayerWin.getUsdtWinAmount());
            statisticalPlayerWin.setId(statisticalPlayerWin.getId());

        }
        ExcelUtil<GameStatisticalPlayerWin> util = new ExcelUtil<GameStatisticalPlayerWin>(GameStatisticalPlayerWin.class);
        util.exportExcel(response, list, "玩家输赢数据");
    }

    /**
     * 获取玩家输赢详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gameStatisticalPlayerWinService.selectGameStatisticalPlayerWinById(id));
    }

    /**
     * 新增玩家输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:add')")
    @Log(title = "玩家输赢", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalPlayerWin gameStatisticalPlayerWin) {
        return toAjax(gameStatisticalPlayerWinService.insertGameStatisticalPlayerWin(gameStatisticalPlayerWin));
    }

    /**
     * 修改玩家输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:edit')")
    @Log(title = "玩家输赢", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalPlayerWin gameStatisticalPlayerWin) {
        return toAjax(gameStatisticalPlayerWinService.updateGameStatisticalPlayerWin(gameStatisticalPlayerWin));
    }

    /**
     * 删除玩家输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:win:remove')")
    @Log(title = "玩家输赢", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gameStatisticalPlayerWinService.deleteGameStatisticalPlayerWinByIds(ids));
    }
}
