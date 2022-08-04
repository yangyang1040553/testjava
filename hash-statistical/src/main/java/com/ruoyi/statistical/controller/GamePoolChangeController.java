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
import com.ruoyi.statistical.domain.GamePoolChange;
import com.ruoyi.statistical.service.IGamePoolChangeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏奖金池变化Controller
 * 
 * @author xxk
 * @date 2022-08-04
 */
@RestController
@RequestMapping("/hash-statistical/poolChange")
public class GamePoolChangeController extends BaseController
{
    @Autowired
    private IGamePoolChangeService gamePoolChangeService;

    /**
     * 查询游戏奖金池变化列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:list')")
    @GetMapping("/list")
    public TableDataInfo list(GamePoolChange gamePoolChange)
    {
//        startPage();
        List<GamePoolChange> list = gamePoolChangeService.selectGamePoolChangeList(gamePoolChange);
        return getDataTable(list);
    }

    /**
     * 导出游戏奖金池变化列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:export')")
    @Log(title = "游戏奖金池变化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GamePoolChange gamePoolChange)
    {
        startOrderBy();
        List<GamePoolChange> list = gamePoolChangeService.selectGamePoolChangeList(gamePoolChange);
        ExcelUtil<GamePoolChange> util = new ExcelUtil<GamePoolChange>(GamePoolChange.class);
        util.exportExcel(response, list, "游戏奖金池变化数据");
    }

    /**
     * 获取游戏奖金池变化详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gamePoolChangeService.selectGamePoolChangeById(id));
    }

    /**
     * 新增游戏奖金池变化
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:add')")
    @Log(title = "游戏奖金池变化", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GamePoolChange gamePoolChange)
    {
        return toAjax(gamePoolChangeService.insertGamePoolChange(gamePoolChange));
    }

    /**
     * 修改游戏奖金池变化
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:edit')")
    @Log(title = "游戏奖金池变化", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GamePoolChange gamePoolChange)
    {
        return toAjax(gamePoolChangeService.updateGamePoolChange(gamePoolChange));
    }

    /**
     * 删除游戏奖金池变化
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:poolChange:remove')")
    @Log(title = "游戏奖金池变化", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gamePoolChangeService.deleteGamePoolChangeByIds(ids));
    }
}
