package com.ruoyi.game.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hashuser.redis.GameRedis;
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
import com.ruoyi.game.domain.GameGlobalConfig;
import com.ruoyi.game.service.IGameGlobalConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏共用配置Controller
 * 
 * @author xxk
 * @date 2022-06-24
 */
@RestController
@RequestMapping("/hash-game/globalGame")
public class GameGlobalConfigController extends BaseController
{
    @Autowired
    private IGameGlobalConfigService gameGlobalConfigService;

    @Autowired
    GameRedis gameRedis;

    /**
     * 查询游戏共用配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameGlobalConfig gameGlobalConfig)
    {
        startPage();
        List<GameGlobalConfig> list = gameGlobalConfigService.selectGameGlobalConfigList(gameGlobalConfig);
        return getDataTable(list);
    }

    /**
     * 导出游戏共用配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:export')")
    @Log(title = "游戏共用配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameGlobalConfig gameGlobalConfig)
    {
        startOrderBy();
        List<GameGlobalConfig> list = gameGlobalConfigService.selectGameGlobalConfigList(gameGlobalConfig);
        ExcelUtil<GameGlobalConfig> util = new ExcelUtil<GameGlobalConfig>(GameGlobalConfig.class);
        util.exportExcel(response, list, "游戏共用配置数据");
    }

    /**
     * 获取游戏共用配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameGlobalConfigService.selectGameGlobalConfigById(id));
    }

    /**
     * 新增游戏共用配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:add')")
    @Log(title = "游戏共用配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameGlobalConfig gameGlobalConfig)
    {
        return toAjax(gameGlobalConfigService.insertGameGlobalConfig(gameGlobalConfig));
    }

    /**
     * 修改游戏共用配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:edit')")
    @Log(title = "游戏共用配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameGlobalConfig gameGlobalConfig)
    {
        gameGlobalConfig.setUpdateTime(DateUtils.getNowDate());
        gameGlobalConfig.setUpdateBy(getUsername());
        gameRedis.deleteGameGlobalConfig();
        return toAjax(gameGlobalConfigService.updateGameGlobalConfig(gameGlobalConfig));
    }

    /**
     * 删除游戏共用配置
     */
    @PreAuthorize("@ss.hasPermi('hash-game:globalGame:remove')")
    @Log(title = "游戏共用配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameGlobalConfigService.deleteGameGlobalConfigByIds(ids));
    }
}
