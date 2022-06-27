package com.ruoyi.hashuser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.hashuser.domain.UserVersion;
import com.ruoyi.hashuser.service.IUserVersionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 版本更新Controller
 *
 * @author xxk
 * @date 2022-06-27
 */
@RestController
@RequestMapping("/hash-user/version")
public class UserVersionController extends BaseController {
    @Autowired
    private IUserVersionService userVersionService;

    /**
     * 查询版本更新列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserVersion userVersion) {
        startPage();
        startOrderBy();
        List<UserVersion> list = userVersionService.selectUserVersionList(userVersion);
        return getDataTable(list);
    }

    /**
     * 导出版本更新列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:export')")
    @Log(title = "版本更新", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserVersion userVersion) {
        startOrderBy();
        List<UserVersion> list = userVersionService.selectUserVersionList(userVersion);
        ExcelUtil<UserVersion> util = new ExcelUtil<UserVersion>(UserVersion.class);
        util.exportExcel(response, list, "版本更新数据");
    }

    /**
     * 获取版本更新详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(userVersionService.selectUserVersionById(id));
    }

    /**
     * 新增版本更新
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:add')")
    @Log(title = "版本更新", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserVersion userVersion) {
        userVersion.setCreateTime(DateUtils.getNowDate());
        userVersion.setCreateBy(getUsername());
        int i = userVersionService.insertUserVersion(userVersion);
        if (i > 0) {
            return toAjax(1);
        }
        if (i == -1) {
            return AjaxResult.error("当前版本已经存在，不得重复创建！");
        }
        return AjaxResult.error("创建失败");
    }

    /**
     * 修改版本更新
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:edit')")
    @Log(title = "版本更新", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserVersion userVersion) {
        userVersion.setUpdateTime(DateUtils.getNowDate());
        userVersion.setUpdateBy(getUsername());
        return toAjax(userVersionService.updateUserVersion(userVersion));
    }

    /**
     * 删除版本更新
     */
    @PreAuthorize("@ss.hasPermi('hash-user:version:remove')")
    @Log(title = "版本更新", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(userVersionService.deleteUserVersionByIds(ids));
    }
}
