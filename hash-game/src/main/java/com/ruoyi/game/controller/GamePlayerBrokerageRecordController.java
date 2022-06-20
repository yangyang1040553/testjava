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
import com.ruoyi.game.domain.GamePlayerBrokerageRecord;
import com.ruoyi.game.service.IGamePlayerBrokerageRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 玩家返佣记录Controller
 * 
 * @author xxk
 * @date 2022-05-16
 */
@RestController
@RequestMapping("/hash-game/brokerageRecord")
public class GamePlayerBrokerageRecordController extends BaseController
{
    @Autowired
    private IGamePlayerBrokerageRecordService gamePlayerBrokerageRecordService;

    /**
     * 查询玩家返佣记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        startPage();
        startOrderBy();
        List<GamePlayerBrokerageRecord> list = gamePlayerBrokerageRecordService.selectGamePlayerBrokerageRecordList(gamePlayerBrokerageRecord);
        return getDataTable(list);
    }

    /**
     * 导出玩家返佣记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:export')")
    @Log(title = "玩家返佣记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        startOrderBy();
        List<GamePlayerBrokerageRecord> list = gamePlayerBrokerageRecordService.selectGamePlayerBrokerageRecordList(gamePlayerBrokerageRecord);
        ExcelUtil<GamePlayerBrokerageRecord> util = new ExcelUtil<GamePlayerBrokerageRecord>(GamePlayerBrokerageRecord.class);
        util.exportExcel(response, list, "玩家返佣记录数据");
    }

    /**
     * 获取玩家返佣记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gamePlayerBrokerageRecordService.selectGamePlayerBrokerageRecordById(id));
    }

    /**
     * 新增玩家返佣记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:add')")
    @Log(title = "玩家返佣记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        return toAjax(gamePlayerBrokerageRecordService.insertGamePlayerBrokerageRecord(gamePlayerBrokerageRecord));
    }

    /**
     * 修改玩家返佣记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:edit')")
    @Log(title = "玩家返佣记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GamePlayerBrokerageRecord gamePlayerBrokerageRecord)
    {
        return toAjax(gamePlayerBrokerageRecordService.updateGamePlayerBrokerageRecord(gamePlayerBrokerageRecord));
    }

    /**
     * 删除玩家返佣记录
     */
    @PreAuthorize("@ss.hasPermi('hash-game:brokerageRecord:remove')")
    @Log(title = "玩家返佣记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gamePlayerBrokerageRecordService.deleteGamePlayerBrokerageRecordByIds(ids));
    }
}
