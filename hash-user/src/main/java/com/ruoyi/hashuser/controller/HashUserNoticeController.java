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
import com.ruoyi.hashuser.domain.HashUserNotice;
import com.ruoyi.hashuser.service.IHashUserNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户公告Controller
 * 
 * @author xxk
 * @date 2022-05-10
 */
@RestController
@RequestMapping("/hash-user/hashUserNotice")
public class HashUserNoticeController extends BaseController
{
    @Autowired
    private IHashUserNoticeService hashUserNoticeService;

    /**
     * 查询用户公告列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUserNotice hashUserNotice)
    {
        startPage();
        startOrderBy();
        List<HashUserNotice> list = hashUserNoticeService.selectHashUserNoticeList(hashUserNotice);
        return getDataTable(list);
    }

    /**
     * 导出用户公告列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:export')")
    @Log(title = "用户公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUserNotice hashUserNotice)
    {
        List<HashUserNotice> list = hashUserNoticeService.selectHashUserNoticeList(hashUserNotice);
        ExcelUtil<HashUserNotice> util = new ExcelUtil<HashUserNotice>(HashUserNotice.class);
        util.exportExcel(response, list, "用户公告数据");
    }

    /**
     * 获取用户公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(hashUserNoticeService.selectHashUserNoticeById(id));
    }

    /**
     * 新增用户公告
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:add')")
    @Log(title = "用户公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUserNotice hashUserNotice)
    {
        return toAjax(hashUserNoticeService.insertHashUserNotice(hashUserNotice));
    }

    /**
     * 修改用户公告
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:edit')")
    @Log(title = "用户公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUserNotice hashUserNotice)
    {
        return toAjax(hashUserNoticeService.updateHashUserNotice(hashUserNotice));
    }

    /**
     * 删除用户公告
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserNotice:remove')")
    @Log(title = "用户公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(hashUserNoticeService.deleteHashUserNoticeByIds(ids));
    }
}
