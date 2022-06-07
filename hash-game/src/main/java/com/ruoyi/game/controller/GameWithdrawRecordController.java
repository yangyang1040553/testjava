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
import com.ruoyi.game.domain.GameWithdrawRecord;
import com.ruoyi.game.service.IGameWithdrawRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 佣金提现记录Controller
 * 
 * @author xxk
 * @date 2022-05-19
 */
@RestController
@RequestMapping("/hash-game/widthdrawRecord")
public class GameWithdrawRecordController extends BaseController
{
    @Autowired
    private IGameWithdrawRecordService gameWithdrawRecordService;

    /**
     * 查询佣金提现记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameWithdrawRecord gameWithdrawRecord)
    {
        startPage();
        startOrderBy();
        List<GameWithdrawRecord> list = gameWithdrawRecordService.selectGameWithdrawRecordList(gameWithdrawRecord);
        return getDataTable(list);
    }

    /**
     * 导出佣金提现记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:export')")
    @Log(title = "佣金提现记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameWithdrawRecord gameWithdrawRecord)
    {
        List<GameWithdrawRecord> list = gameWithdrawRecordService.selectGameWithdrawRecordList(gameWithdrawRecord);
        ExcelUtil<GameWithdrawRecord> util = new ExcelUtil<GameWithdrawRecord>(GameWithdrawRecord.class);
        util.exportExcel(response, list, "佣金提现记录数据");
    }

    /**
     * 获取佣金提现记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameWithdrawRecordService.selectGameWithdrawRecordById(id));
    }

    /**
     * 新增佣金提现记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:add')")
    @Log(title = "佣金提现记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameWithdrawRecord gameWithdrawRecord)
    {
        return toAjax(gameWithdrawRecordService.insertGameWithdrawRecord(gameWithdrawRecord));
    }

    /**
     * 修改佣金提现记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:edit')")
    @Log(title = "佣金提现记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameWithdrawRecord gameWithdrawRecord)
    {
        return toAjax(gameWithdrawRecordService.updateGameWithdrawRecord(gameWithdrawRecord));
    }

    /**
     * 删除佣金提现记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:widthdrawRecord:remove')")
    @Log(title = "佣金提现记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameWithdrawRecordService.deleteGameWithdrawRecordByIds(ids));
    }
}