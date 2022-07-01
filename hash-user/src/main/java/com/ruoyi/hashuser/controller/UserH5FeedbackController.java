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
import com.ruoyi.hashuser.domain.UserH5Feedback;
import com.ruoyi.hashuser.service.IUserH5FeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 落地页H5反馈Controller
 * 
 * @author xxk
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/hash-user/h5Feedback")
public class UserH5FeedbackController extends BaseController
{
    @Autowired
    private IUserH5FeedbackService userH5FeedbackService;

    /**
     * 查询落地页H5反馈列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserH5Feedback userH5Feedback)
    {
        startPage();
        startOrderBy();
        List<UserH5Feedback> list = userH5FeedbackService.selectUserH5FeedbackList(userH5Feedback);
        return getDataTable(list);
    }

    /**
     * 导出落地页H5反馈列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:export')")
    @Log(title = "落地页H5反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserH5Feedback userH5Feedback)
    {
        startOrderBy();
        List<UserH5Feedback> list = userH5FeedbackService.selectUserH5FeedbackList(userH5Feedback);
        ExcelUtil<UserH5Feedback> util = new ExcelUtil<UserH5Feedback>(UserH5Feedback.class);
        util.exportExcel(response, list, "落地页H5反馈数据");
    }

    /**
     * 获取落地页H5反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userH5FeedbackService.selectUserH5FeedbackById(id));
    }

    /**
     * 新增落地页H5反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:add')")
    @Log(title = "落地页H5反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserH5Feedback userH5Feedback)
    {
        return toAjax(userH5FeedbackService.insertUserH5Feedback(userH5Feedback));
    }

    /**
     * 修改落地页H5反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:edit')")
    @Log(title = "落地页H5反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserH5Feedback userH5Feedback)
    {
        return toAjax(userH5FeedbackService.updateUserH5Feedback(userH5Feedback));
    }

    /**
     * 删除落地页H5反馈
     */
    @PreAuthorize("@ss.hasPermi('hash-user:h5Feedback:remove')")
    @Log(title = "落地页H5反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userH5FeedbackService.deleteUserH5FeedbackByIds(ids));
    }
}
