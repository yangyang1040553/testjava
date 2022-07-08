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
import com.ruoyi.hashuser.domain.UserTelegram;
import com.ruoyi.hashuser.service.IUserTelegramService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户飞机Controller
 * 
 * @author xxk
 * @date 2022-07-08
 */
@RestController
@RequestMapping("/hash-user/telegramList")
public class UserTelegramController extends BaseController
{
    @Autowired
    private IUserTelegramService userTelegramService;

    /**
     * 查询用户飞机列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserTelegram userTelegram)
    {
        startPage();
        startOrderBy();
        List<UserTelegram> list = userTelegramService.selectUserTelegramList(userTelegram);
        return getDataTable(list);
    }

    /**
     * 导出用户飞机列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:export')")
    @Log(title = "用户飞机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserTelegram userTelegram)
    {
        startOrderBy();
        List<UserTelegram> list = userTelegramService.selectUserTelegramList(userTelegram);
        ExcelUtil<UserTelegram> util = new ExcelUtil<UserTelegram>(UserTelegram.class);
        util.exportExcel(response, list, "用户飞机数据");
    }

    /**
     * 获取用户飞机详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userTelegramService.selectUserTelegramById(id));
    }

    /**
     * 新增用户飞机
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:add')")
    @Log(title = "用户飞机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserTelegram userTelegram)
    {
        return toAjax(userTelegramService.insertUserTelegram(userTelegram));
    }

    /**
     * 修改用户飞机
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:edit')")
    @Log(title = "用户飞机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserTelegram userTelegram)
    {
        return toAjax(userTelegramService.updateUserTelegram(userTelegram));
    }

    /**
     * 删除用户飞机
     */
    @PreAuthorize("@ss.hasPermi('hash-user:telegramList:remove')")
    @Log(title = "用户飞机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userTelegramService.deleteUserTelegramByIds(ids));
    }
}
