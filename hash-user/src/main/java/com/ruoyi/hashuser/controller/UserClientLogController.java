package com.ruoyi.hashuser.controller;

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
import com.ruoyi.hashuser.domain.UserClientLog;
import com.ruoyi.hashuser.service.IUserClientLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户端日志Controller
 * 
 * @author xxk
 * @date 2022-07-08
 */
@RestController
@RequestMapping("/hash-user/clientLog")
public class UserClientLogController extends BaseController
{
    @Autowired
    private IUserClientLogService userClientLogService;

    /**
     * 查询客户端日志列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserClientLog userClientLog)
    {
        startPage();
        startOrderBy();
        List<UserClientLog> list = userClientLogService.selectUserClientLogList(userClientLog);
        return getDataTable(list);
    }

    /**
     * 导出客户端日志列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:export')")
    @Log(title = "客户端日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserClientLog userClientLog)
    {
        startOrderBy();
        List<UserClientLog> list = userClientLogService.selectUserClientLogList(userClientLog);
        ExcelUtil<UserClientLog> util = new ExcelUtil<UserClientLog>(UserClientLog.class);
        util.exportExcel(response, list, "客户端日志数据");
    }

    /**
     * 获取客户端日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userClientLogService.selectUserClientLogById(id));
    }

    /**
     * 新增客户端日志
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:add')")
    @Log(title = "客户端日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserClientLog userClientLog)
    {
        return toAjax(userClientLogService.insertUserClientLog(userClientLog));
    }

    /**
     * 修改客户端日志
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:edit')")
    @Log(title = "客户端日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserClientLog userClientLog)
    {
        return toAjax(userClientLogService.updateUserClientLog(userClientLog));
    }

    /**
     * 删除客户端日志
     */
    @PreAuthorize("@ss.hasPermi('hash-user:clientLog:remove')")
    @Log(title = "客户端日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userClientLogService.deleteUserClientLogByIds(ids));
    }
}
