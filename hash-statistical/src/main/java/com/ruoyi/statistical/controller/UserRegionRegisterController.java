package com.ruoyi.statistical.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.statistical.domain.GameStatisticalDay;
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
import com.ruoyi.statistical.domain.UserRegionRegister;
import com.ruoyi.statistical.service.IUserRegionRegisterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户区域注册次数Controller
 * 
 * @author xxk
 * @date 2022-06-10
 */
@RestController
@RequestMapping("/hash-statistical/regionRegister")
public class UserRegionRegisterController extends BaseController
{
    @Autowired
    private IUserRegionRegisterService userRegionRegisterService;

    /**
     * 查询用户区域注册次数列表
     */
//    @PreAuthorize("@ss.hasPermi('hash-statistical:register:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserRegionRegister userRegionRegister)
    {
        startPage();
        startOrderBy();
        List<UserRegionRegister> list = userRegionRegisterService.selectUserRegionRegisterList(userRegionRegister);
        return getDataTable(list);
    }

    /**
     * 导出用户区域注册次数列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:regionRegister:export')")
    @Log(title = "用户区域注册次数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserRegionRegister userRegionRegister)
    {
        startOrderBy();
        List<UserRegionRegister> list = userRegionRegisterService.selectUserRegionRegisterList(userRegionRegister);

        ExcelUtil<UserRegionRegister> util = new ExcelUtil<UserRegionRegister>(UserRegionRegister.class);
        util.exportExcel(response, list, "用户区域注册次数数据");
    }

    /**
     * 获取用户区域注册次数详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:regionRegister:query')")
    @GetMapping(value = "/{region}")
    public AjaxResult getInfo(@PathVariable("region") String region)
    {
        return AjaxResult.success(userRegionRegisterService.selectUserRegionRegisterByRegion(region));
    }

    /**
     * 新增用户区域注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:regionRegister:add')")
    @Log(title = "用户区域注册次数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserRegionRegister userRegionRegister)
    {
        return toAjax(userRegionRegisterService.insertUserRegionRegister(userRegionRegister));
    }

    /**
     * 修改用户区域注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:regionRegister:edit')")
    @Log(title = "用户区域注册次数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserRegionRegister userRegionRegister)
    {
        return toAjax(userRegionRegisterService.updateUserRegionRegister(userRegionRegister));
    }

    /**
     * 删除用户区域注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:regionRegister:remove')")
    @Log(title = "用户区域注册次数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regions}")
    public AjaxResult remove(@PathVariable String[] regions)
    {
        return toAjax(userRegionRegisterService.deleteUserRegionRegisterByRegions(regions));
    }
}
