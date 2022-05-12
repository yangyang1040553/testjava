package com.ruoyi.game.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.game.domain.GameConfig;
import com.ruoyi.game.domain.model.BetRuleData;
import com.ruoyi.game.service.IGameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 游戏配置
 * Controller
 *
 * @author xxk
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/hash-game/config")
public class GameConfigController extends BaseController {
    @Autowired
    private IGameConfigService gameConfigService;

    /**
     * 查询游戏配置
     * 列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameConfig gameConfig) {
        startPage();
        List<GameConfig> list = gameConfigService.selectGameConfigList(gameConfig);
        return getDataTable(list);
    }

    /**
     * 导出游戏配置
     * 列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:export')")
    @Log(title = "游戏配置 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameConfig gameConfig) {
        List<GameConfig> list = gameConfigService.selectGameConfigList(gameConfig);
        ExcelUtil<GameConfig> util = new ExcelUtil<GameConfig>(GameConfig.class);
        util.exportExcel(response, list, "游戏配置数据");
    }

    /**
     * 获取游戏配置
     * 详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gameConfigService.selectGameConfigById(id));
    }

    /**
     * 新增游戏配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:add')")
    @Log(title = "游戏配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameConfig gameConfig) {
        return toAjax(gameConfigService.insertGameConfig(gameConfig));
    }

    /**
     * 修改游戏配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:edit')")
    @Log(title = "游戏配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameConfig gameConfig) {
        return toAjax(gameConfigService.updateGameConfig(gameConfig));
    }

    /**
     * 删除游戏配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:config:remove')")
    @Log(title = "游戏配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gameConfigService.deleteGameConfigByIds(ids));
    }
}
