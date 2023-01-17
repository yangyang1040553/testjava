package com.ruoyi.hashUser.controller;

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
import com.ruoyi.hashUser.domain.UserGlobalConfig;
import com.ruoyi.hashUser.service.IUserGlobalConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 版本控制Controller
 * 
 * @author xxk
 * @date 2023-01-18
 */
@RestController
@RequestMapping("/hashUser/globalConfig")
public class UserGlobalConfigController extends BaseController
{
    @Autowired
    private IUserGlobalConfigService userGlobalConfigService;

    /**
     * 查询版本控制列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserGlobalConfig userGlobalConfig)
    {
        startPage();
        List<UserGlobalConfig> list = userGlobalConfigService.selectUserGlobalConfigList(userGlobalConfig);
        return getDataTable(list);
    }

    /**
     * 导出版本控制列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:export')")
    @Log(title = "版本控制", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserGlobalConfig userGlobalConfig)
    {
        startOrderBy();
        List<UserGlobalConfig> list = userGlobalConfigService.selectUserGlobalConfigList(userGlobalConfig);
        ExcelUtil<UserGlobalConfig> util = new ExcelUtil<UserGlobalConfig>(UserGlobalConfig.class);
        util.exportExcel(response, list, "版本控制数据");
    }

    /**
     * 获取版本控制详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(userGlobalConfigService.selectUserGlobalConfigById(id));
    }

    /**
     * 新增版本控制
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:add')")
    @Log(title = "版本控制", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserGlobalConfig userGlobalConfig)
    {
        return toAjax(userGlobalConfigService.insertUserGlobalConfig(userGlobalConfig));
    }

    /**
     * 修改版本控制
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:edit')")
    @Log(title = "版本控制", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserGlobalConfig userGlobalConfig)
    {
        return toAjax(userGlobalConfigService.updateUserGlobalConfig(userGlobalConfig));
    }

    /**
     * 删除版本控制
     */
    @PreAuthorize("@ss.hasPermi('hashUser:globalConfig:remove')")
    @Log(title = "版本控制", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(userGlobalConfigService.deleteUserGlobalConfigByIds(ids));
    }
}
