package com.ruoyi.game.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.game.domain.GameMenu;
import com.ruoyi.game.service.IGameMenuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏菜单Controller
 *
 * @author xxk
 * @date 2022-05-12
 */
@RestController
@RequestMapping("/hash-game/gameMenu")
public class GameMenuController extends BaseController {
    @Autowired
    private IGameMenuService gameMenuService;

    @Autowired
    private GameRedis gameRedis;

    /**
     * 查询游戏菜单列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameMenu gameMenu) {
        startPage();
        List<GameMenu> list = gameMenuService.selectGameMenuList(gameMenu);
        return getDataTable(list);
    }

    /**
     * 导出游戏菜单列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:export')")
    @Log(title = "游戏菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameMenu gameMenu) {
        startOrderBy();
        List<GameMenu> list = gameMenuService.selectGameMenuList(gameMenu);
        ExcelUtil<GameMenu> util = new ExcelUtil<GameMenu>(GameMenu.class);
        util.exportExcel(response, list, "游戏菜单数据");
    }

    /**
     * 获取游戏菜单详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(gameMenuService.selectGameMenuById(id));
    }

    /**
     * 新增游戏菜单
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:add')")
    @Log(title = "游戏菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameMenu gameMenu) {
        gameRedis.deleteGameMenu();
        return toAjax(gameMenuService.insertGameMenu(gameMenu));
    }

    /**
     * 修改游戏菜单
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:edit')")
    @Log(title = "游戏菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameMenu gameMenu) {
        gameRedis.deleteGameMenu();
        return toAjax(gameMenuService.updateGameMenu(gameMenu));
    }

    /**
     * 删除游戏菜单
     */
    @PreAuthorize("@ss.hasPermi('hash-game:gameMenu:remove')")
    @Log(title = "游戏菜单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        gameRedis.deleteGameMenu();
        return toAjax(gameMenuService.deleteGameMenuByIds(ids));
    }
}
