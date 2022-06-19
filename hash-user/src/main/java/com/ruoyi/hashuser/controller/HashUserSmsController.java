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
import com.ruoyi.hashuser.domain.HashUserSms;
import com.ruoyi.hashuser.service.IHashUserSmsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户短信功能Controller
 * 
 * @author xxk
 * @date 2022-05-12
 */
@RestController
@RequestMapping("/hash-user/hashUserSms")
public class HashUserSmsController extends BaseController
{
    @Autowired
    private IHashUserSmsService hashUserSmsService;

    /**
     * 查询用户短信功能列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUserSms hashUserSms)
    {
        startPage();
        List<HashUserSms> list = hashUserSmsService.selectHashUserSmsList(hashUserSms);
        return getDataTable(list);
    }

    /**
     * 导出用户短信功能列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:export')")
    @Log(title = "用户短信功能", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUserSms hashUserSms)
    {
        startOrderBy();
        List<HashUserSms> list = hashUserSmsService.selectHashUserSmsList(hashUserSms);
        ExcelUtil<HashUserSms> util = new ExcelUtil<HashUserSms>(HashUserSms.class);
        util.exportExcel(response, list, "用户短信功能数据");
    }

    /**
     * 获取用户短信功能详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(hashUserSmsService.selectHashUserSmsById(id));
    }

    /**
     * 新增用户短信功能
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:add')")
    @Log(title = "用户短信功能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUserSms hashUserSms)
    {
        return toAjax(hashUserSmsService.insertHashUserSms(hashUserSms));
    }

    /**
     * 修改用户短信功能
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:edit')")
    @Log(title = "用户短信功能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUserSms hashUserSms)
    {
        return toAjax(hashUserSmsService.updateHashUserSms(hashUserSms));
    }

    /**
     * 删除用户短信功能
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserSms:remove')")
    @Log(title = "用户短信功能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(hashUserSmsService.deleteHashUserSmsByIds(ids));
    }
}
