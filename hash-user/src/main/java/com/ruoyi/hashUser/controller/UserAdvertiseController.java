package com.ruoyi.hashUser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hashUser.domain.UserAdvertise;
import com.ruoyi.hashUser.service.IUserAdvertiseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 广告管理Controller
 * 
 * @author xxk
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/hashUser/article")
public class UserAdvertiseController extends BaseController
{
    @Autowired
    private IUserAdvertiseService userAdvertiseService;

    /**
     * 查询广告管理列表
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:list')")
    @GetMapping("/list")
    public @ResponseBody TableDataInfo list(UserAdvertise userAdvertise)
    {
        startPage();
        List<UserAdvertise> list = userAdvertiseService.selectUserAdvertiseList(userAdvertise);
        return getDataTable(list);
    }

    /**
     * 导出广告管理列表
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:export')")
    @Log(title = "广告管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserAdvertise userAdvertise)
    {
        startOrderBy();
        List<UserAdvertise> list = userAdvertiseService.selectUserAdvertiseList(userAdvertise);
        ExcelUtil<UserAdvertise> util = new ExcelUtil<UserAdvertise>(UserAdvertise.class);
        util.exportExcel(response, list, "广告管理数据");
    }

    /**
     * 获取广告管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(userAdvertiseService.selectUserAdvertiseById(id));
    }

    /**
     * 新增广告管理
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:add')")
    @Log(title = "广告管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserAdvertise userAdvertise)
    {
        return toAjax(userAdvertiseService.insertUserAdvertise(userAdvertise));
    }

    /**
     * 修改广告管理
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:edit')")
    @Log(title = "广告管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserAdvertise userAdvertise)
    {
        return toAjax(userAdvertiseService.updateUserAdvertise(userAdvertise));
    }

    /**
     * 删除广告管理
     */
//    @PreAuthorize("@ss.hasPermi('hashUser:advertise:remove')")
    @Log(title = "广告管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userAdvertiseService.deleteUserAdvertiseByIds(ids));
    }
}
