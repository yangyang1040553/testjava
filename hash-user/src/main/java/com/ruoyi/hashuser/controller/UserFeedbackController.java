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
import com.ruoyi.hashuser.domain.UserFeedback;
import com.ruoyi.hashuser.service.IUserFeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户意见反馈Controller
 * 
 * @author xxk
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/hash-user/feedback")
public class UserFeedbackController extends BaseController
{
    @Autowired
    private IUserFeedbackService userFeedbackService;

    /**
     * 查询用户意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserFeedback userFeedback)
    {
        startPage();
        startOrderBy();
        List<UserFeedback> list = userFeedbackService.selectUserFeedbackList(userFeedback);
        return getDataTable(list);
    }

    /**
     * 导出用户意见反馈列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:export')")
    @Log(title = "用户意见反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserFeedback userFeedback)
    {
        List<UserFeedback> list = userFeedbackService.selectUserFeedbackList(userFeedback);
        ExcelUtil<UserFeedback> util = new ExcelUtil<UserFeedback>(UserFeedback.class);
        util.exportExcel(response, list, "用户意见反馈数据");
    }

    /**
     * 获取用户意见反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(userFeedbackService.selectUserFeedbackById(id));
    }

    /**
     * 新增用户意见反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:add')")
    @Log(title = "用户意见反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserFeedback userFeedback)
    {
        return toAjax(userFeedbackService.insertUserFeedback(userFeedback));
    }

    /**
     * 修改用户意见反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:edit')")
    @Log(title = "用户意见反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserFeedback userFeedback)
    {
        return toAjax(userFeedbackService.updateUserFeedback(userFeedback));
    }

    /**
     * 删除用户意见反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:feedback:remove')")
    @Log(title = "用户意见反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(userFeedbackService.deleteUserFeedbackByIds(ids));
    }
}
