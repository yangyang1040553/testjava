package com.ruoyi.game.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.LogUtils;
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
import com.ruoyi.game.domain.GameBetRecord;
import com.ruoyi.game.service.IGameBetRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游戏投注记录Controller
 *
 * @author xxk
 * @date 2022-05-12
 */
@RestController
@RequestMapping("/hash-game/record")
public class GameBetRecordController extends BaseController {
    @Autowired
    private IGameBetRecordService gameBetRecordService;


    /**
     * 查询游戏投注记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameBetRecord gameBetRecord) {
        startPage();
        startOrderBy();
        List<GameBetRecord> list = gameBetRecordService.selectGameBetRecordList(gameBetRecord);
//        LogUtils.getBlock(list);
        return getDataTable(list);
    }

    /**
     * 导出游戏投注记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:export')")
    @Log(title = "游戏投注记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameBetRecord gameBetRecord) {
        startPage();
        startOrderBy();
        List<GameBetRecord> list = gameBetRecordService.selectGameBetRecordList(gameBetRecord);
        for (GameBetRecord betRecord : list) {
            betRecord.setWinAmount(betRecord.getWinAmount());
            betRecord.setUsdt_miner_fee(betRecord.getUsdt_miner_fee());
        }
        ExcelUtil<GameBetRecord> util = new ExcelUtil<GameBetRecord>(GameBetRecord.class);
        util.exportExcel(response, list, "游戏投注记录数据");
    }

    /**
     * 获取游戏投注记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(gameBetRecordService.selectGameBetRecordById(id));
    }

    /**
     * 新增游戏投注记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:add')")
    @Log(title = "游戏投注记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameBetRecord gameBetRecord) {
        return toAjax(gameBetRecordService.insertGameBetRecord(gameBetRecord));
    }

    /**
     * 修改游戏投注记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:edit')")
    @Log(title = "游戏投注记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameBetRecord gameBetRecord) {
        return toAjax(gameBetRecordService.updateGameBetRecord(gameBetRecord));
    }

    /**
     * 删除游戏投注记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:record:remove')")
    @Log(title = "游戏投注记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(gameBetRecordService.deleteGameBetRecordByIds(ids));
    }
}
