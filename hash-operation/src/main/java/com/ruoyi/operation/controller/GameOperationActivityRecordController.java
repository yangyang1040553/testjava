package com.ruoyi.operation.controller;

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
import com.ruoyi.operation.domain.GameOperationActivityRecord;
import com.ruoyi.operation.service.IGameOperationActivityRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运营活动奖励记录Controller
 * 
 * @author xxk
 * @date 2022-06-27
 */
@RestController
@RequestMapping("/hash-operation/operationRecord")
public class GameOperationActivityRecordController extends BaseController
{
    @Autowired
    private IGameOperationActivityRecordService gameOperationActivityRecordService;

    /**
     * 查询运营活动奖励记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(GameOperationActivityRecord gameOperationActivityRecord)
    {
        startPage();
        startOrderBy();
        List<GameOperationActivityRecord> list = gameOperationActivityRecordService.selectGameOperationActivityRecordList(gameOperationActivityRecord);
        return getDataTable(list);
    }

    /**
     * 导出运营活动奖励记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:export')")
    @Log(title = "运营活动奖励记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GameOperationActivityRecord gameOperationActivityRecord)
    {
        startOrderBy();
        List<GameOperationActivityRecord> list = gameOperationActivityRecordService.selectGameOperationActivityRecordList(gameOperationActivityRecord);
        ExcelUtil<GameOperationActivityRecord> util = new ExcelUtil<GameOperationActivityRecord>(GameOperationActivityRecord.class);
        util.exportExcel(response, list, "运营活动奖励记录数据");
    }

    /**
     * 获取运营活动奖励记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(gameOperationActivityRecordService.selectGameOperationActivityRecordById(id));
    }

    /**
     * 新增运营活动奖励记录
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:add')")
    @Log(title = "运营活动奖励记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GameOperationActivityRecord gameOperationActivityRecord)
    {
        return toAjax(gameOperationActivityRecordService.insertGameOperationActivityRecord(gameOperationActivityRecord));
    }

    /**
     * 修改运营活动奖励记录
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:edit')")
    @Log(title = "运营活动奖励记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GameOperationActivityRecord gameOperationActivityRecord)
    {
        return toAjax(gameOperationActivityRecordService.updateGameOperationActivityRecord(gameOperationActivityRecord));
    }

    /**
     * 删除运营活动奖励记录
     */
    @PreAuthorize("@ss.hasPermi('hash-operation:operationRecord:remove')")
    @Log(title = "运营活动奖励记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(gameOperationActivityRecordService.deleteGameOperationActivityRecordByIds(ids));
    }
}
