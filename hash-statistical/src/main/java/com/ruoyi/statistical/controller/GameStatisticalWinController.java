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
import com.ruoyi.statistical.domain.GameStatisticalWin;
import com.ruoyi.statistical.service.IGameStatisticalWinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏输赢Controller
 * 
 * @author xxk
 * @date 2022-08-13
 */
@RestController
@RequestMapping("/hash-statistical/gameWin")
public class GameStatisticalWinController extends BaseController
{
    @Autowired
    private IGameStatisticalWinService gameStatisticalWinService;

    /**
     * 查询游戏输赢列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameStatisticalWin gameStatisticalWin)
    {
        startPage();
        List<GameStatisticalWin> list = gameStatisticalWinService.selectGameStatisticalWinList(gameStatisticalWin);
        return getDataTable(list);
    }

    /**
     * 导出游戏输赢列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:export')")
    @Log(title = "游戏输赢", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameStatisticalWin gameStatisticalWin)
    {
        startOrderBy();
        List<GameStatisticalWin> list = gameStatisticalWinService.selectGameStatisticalWinList(gameStatisticalWin);
        for (GameStatisticalWin statisticalWin : list) {
            statisticalWin.setTrxWinAmount(statisticalWin.getTrxWinAmount());
            statisticalWin.setTrxBetAmount(statisticalWin.getTrxBetAmount());
            statisticalWin.setTrxAwardAmount(statisticalWin.getTrxAwardAmount());

            statisticalWin.setUsdtWinAmount(statisticalWin.getUsdtWinAmount());
            statisticalWin.setUsdtBetAmount(statisticalWin.getTrxBetAmount());
            statisticalWin.setUsdtAwardAmount(statisticalWin.getTrxAwardAmount());
        }
        ExcelUtil<GameStatisticalWin> util = new ExcelUtil<GameStatisticalWin>(GameStatisticalWin.class);
        util.exportExcel(response, list, "游戏输赢数据");
    }

    /**
     * 获取游戏输赢详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameStatisticalWinService.selectGameStatisticalWinById(id));
    }

    /**
     * 新增游戏输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:add')")
    @Log(title = "游戏输赢", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameStatisticalWin gameStatisticalWin)
    {
        return toAjax(gameStatisticalWinService.insertGameStatisticalWin(gameStatisticalWin));
    }

    /**
     * 修改游戏输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:edit')")
    @Log(title = "游戏输赢", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameStatisticalWin gameStatisticalWin)
    {
        return toAjax(gameStatisticalWinService.updateGameStatisticalWin(gameStatisticalWin));
    }

    /**
     * 删除游戏输赢
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:gameWin:remove')")
    @Log(title = "游戏输赢", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameStatisticalWinService.deleteGameStatisticalWinByIds(ids));
    }
}
