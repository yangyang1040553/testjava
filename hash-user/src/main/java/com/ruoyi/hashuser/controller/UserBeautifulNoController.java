package com.ruoyi.hashuser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.HttpStatus;
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
import com.ruoyi.hashuser.domain.UserBeautifulNo;
import com.ruoyi.hashuser.service.IUserBeautifulNoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户靓号申请Controller
 *
 * @author xxk
 * @date 2022-08-29
 */
@RestController
@RequestMapping("/hash-user/beautifulNumber")
public class UserBeautifulNoController extends BaseController {
    @Autowired
    private IUserBeautifulNoService userBeautifulNoService;

    /**
     * 查询用户靓号申请列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserBeautifulNo userBeautifulNo) {
        startPage();
        List<UserBeautifulNo> list = userBeautifulNoService.selectUserBeautifulNoList(userBeautifulNo);
        return getDataTable(list);
    }

    /**
     * 导出用户靓号申请列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:export')")
    @Log(title = "用户靓号申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserBeautifulNo userBeautifulNo) {
        startOrderBy();
        List<UserBeautifulNo> list = userBeautifulNoService.selectUserBeautifulNoList(userBeautifulNo);
        ExcelUtil<UserBeautifulNo> util = new ExcelUtil<UserBeautifulNo>(UserBeautifulNo.class);
        util.exportExcel(response, list, "用户靓号申请数据");
    }

    /**
     * 获取用户靓号申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(userBeautifulNoService.selectUserBeautifulNoById(id));
    }

    /**
     * 新增用户靓号申请
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:add')")
    @Log(title = "用户靓号申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserBeautifulNo userBeautifulNo) {
        int i = userBeautifulNoService.insertUserBeautifulNo(userBeautifulNo);
        if (i > 0) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error(HttpStatus.ERROR, "该靓号已存在，请重新输入！");
    }

    /**
     * 修改用户靓号申请
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:edit')")
    @Log(title = "用户靓号申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserBeautifulNo userBeautifulNo) {
        int i = userBeautifulNoService.updateUserBeautifulNo(userBeautifulNo);
        if (i > 0) {
            return AjaxResult.success("修改成功！");
        }
        return AjaxResult.error(HttpStatus.ERROR, "该靓号已存在，请重新输入！");
    }

    /**
     * 删除用户靓号申请
     */
    @PreAuthorize("@ss.hasPermi('hash-user:beautifulNumber:remove')")
    @Log(title = "用户靓号申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(userBeautifulNoService.deleteUserBeautifulNoByIds(ids));
    }
}
