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
import com.ruoyi.hashuser.domain.UserTelegramGroup;
import com.ruoyi.hashuser.service.IUserTelegramGroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 群组列表Controller
 * 
 * @author xxk
 * @date 2022-07-10
 */
@RestController
@RequestMapping("/hash-user/group")
public class UserTelegramGroupController extends BaseController
{
    @Autowired
    private IUserTelegramGroupService userTelegramGroupService;

    /**
     * 查询群组列表列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserTelegramGroup userTelegramGroup)
    {
        startPage();
        startOrderBy();
        List<UserTelegramGroup> list = userTelegramGroupService.selectUserTelegramGroupList(userTelegramGroup);
        return getDataTable(list);
    }

    /**
     * 导出群组列表列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:export')")
    @Log(title = "群组列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserTelegramGroup userTelegramGroup)
    {
        startOrderBy();
        List<UserTelegramGroup> list = userTelegramGroupService.selectUserTelegramGroupList(userTelegramGroup);
        ExcelUtil<UserTelegramGroup> util = new ExcelUtil<UserTelegramGroup>(UserTelegramGroup.class);
        util.exportExcel(response, list, "群组列表数据");
    }

    /**
     * 获取群组列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:query')")
    @GetMapping(value = "/{groupId}")
    public AjaxResult getInfo(@PathVariable("groupId") String groupId)
    {
        return AjaxResult.success(userTelegramGroupService.selectUserTelegramGroupByGroupId(groupId));
    }

    /**
     * 新增群组列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:add')")
    @Log(title = "群组列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserTelegramGroup userTelegramGroup)
    {
        return toAjax(userTelegramGroupService.insertUserTelegramGroup(userTelegramGroup));
    }

    /**
     * 修改群组列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:edit')")
    @Log(title = "群组列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserTelegramGroup userTelegramGroup)
    {
        return toAjax(userTelegramGroupService.updateUserTelegramGroup(userTelegramGroup));
    }

    /**
     * 删除群组列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:group:remove')")
    @Log(title = "群组列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{groupIds}")
    public AjaxResult remove(@PathVariable String[] groupIds)
    {
        return toAjax(userTelegramGroupService.deleteUserTelegramGroupByGroupIds(groupIds));
    }
}
