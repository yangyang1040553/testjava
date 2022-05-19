package com.ruoyi.game.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.ListUtils;
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
import com.ruoyi.game.domain.GamePlayerPromote;
import com.ruoyi.game.service.IGamePlayerPromoteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推广记录Controller
 *
 * @author xxk
 * @date 2022-05-19
 */
@RestController
@RequestMapping("/hash-game/promote")
public class GamePlayerPromoteController extends BaseController {
    @Autowired
    private IGamePlayerPromoteService gamePlayerPromoteService;

    /**
     * 查询推广记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:list')")
    @GetMapping("/list")
    public TableDataInfo list(GamePlayerPromote gamePlayerPromote) {
        startPage();
        startOrderBy();
        List<GamePlayerPromote> list = gamePlayerPromoteService.selectGamePlayerPromoteList(gamePlayerPromote);
        return getDataTable(list);
    }

    /**
     * 导出推广记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:export')")
    @Log(title = "推广记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GamePlayerPromote gamePlayerPromote) throws CloneNotSupportedException {
        List<GamePlayerPromote> list = gamePlayerPromoteService.selectGamePlayerPromoteList(gamePlayerPromote);
        ExcelUtil<GamePlayerPromote> util = new ExcelUtil<GamePlayerPromote>(GamePlayerPromote.class);
        util.exportExcel(response,list, "推广记录数据");
    }

    /**
     * 获取推广记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gamePlayerPromoteService.selectGamePlayerPromoteById(id));
    }

    /**
     * 新增推广记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:add')")
    @Log(title = "推广记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GamePlayerPromote gamePlayerPromote) {
        return toAjax(gamePlayerPromoteService.insertGamePlayerPromote(gamePlayerPromote));
    }

    /**
     * 修改推广记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:edit')")
    @Log(title = "推广记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GamePlayerPromote gamePlayerPromote) {
        return toAjax(gamePlayerPromoteService.updateGamePlayerPromote(gamePlayerPromote));
    }

    /**
     * 删除推广记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:promote:remove')")
    @Log(title = "推广记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gamePlayerPromoteService.deleteGamePlayerPromoteByIds(ids));
    }
}
