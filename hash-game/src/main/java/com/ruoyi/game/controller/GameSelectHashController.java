package com.ruoyi.game.controller;

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
import com.ruoyi.game.domain.GameSelectHash;
import com.ruoyi.game.service.IGameSelectHashService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 哈希查询记录Controller
 *
 * @author xxk
 * @date 2022-08-22
 */
@RestController
@RequestMapping("/hash-game/hashSelect")
public class GameSelectHashController extends BaseController {
    @Autowired
    private IGameSelectHashService gameSelectHashService;

    /**
     * 查询哈希查询记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameSelectHash gameSelectHash) {
        startPage();
        List<GameSelectHash> list = gameSelectHashService.selectGameSelectHashList(gameSelectHash);
        return getDataTable(list);
    }

    /**
     * 导出哈希查询记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:export')")
    @Log(title = "哈希查询记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameSelectHash gameSelectHash) {
        startOrderBy();
        startOrderBy();
        List<GameSelectHash> list = gameSelectHashService.selectGameSelectHashList(gameSelectHash);
        for (GameSelectHash selectHash : list) {
            selectHash.setBetAmount(selectHash.getBetAmount());
        }
        ExcelUtil<GameSelectHash> util = new ExcelUtil<GameSelectHash>(GameSelectHash.class);
        util.exportExcel(response, list, "哈希查询记录数据");
    }

    /**
     * 获取哈希查询记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(gameSelectHashService.selectGameSelectHashById(id));
    }

    /**
     * 新增哈希查询记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:add')")
    @Log(title = "哈希查询记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameSelectHash gameSelectHash) {
        return toAjax(gameSelectHashService.insertGameSelectHash(gameSelectHash));
    }

    /**
     * 修改哈希查询记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:edit')")
    @Log(title = "哈希查询记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameSelectHash gameSelectHash) {
        return toAjax(gameSelectHashService.updateGameSelectHash(gameSelectHash));
    }

    /**
     * 删除哈希查询记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:hashSelect:remove')")
    @Log(title = "哈希查询记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(gameSelectHashService.deleteGameSelectHashByIds(ids));
    }
}
