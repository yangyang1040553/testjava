package com.ruoyi.hashuser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hashuser.domain.HashUserBannerConfig;
import com.ruoyi.hashuser.service.IHashUserBannerConfigService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户首页的banner列Controller
 * 
 * @author xxk
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/hash-user/hashUserBannerConfig")
public class HashUserBannerConfigController extends BaseController
{
    @Autowired
    private IHashUserBannerConfigService hashUserBannerConfigService;

    /**
     * 查询用户首页的banner列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUserBannerConfig hashUserBannerConfig)
    {
        startPage();
        List<HashUserBannerConfig> list = hashUserBannerConfigService.selectHashUserBannerConfigList(hashUserBannerConfig);
        return getDataTable(list);
    }

    /**
     * 导出用户首页的banner列列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:export')")
    @Log(title = "用户首页的banner列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUserBannerConfig hashUserBannerConfig)
    {
        List<HashUserBannerConfig> list = hashUserBannerConfigService.selectHashUserBannerConfigList(hashUserBannerConfig);
        ExcelUtil<HashUserBannerConfig> util = new ExcelUtil<HashUserBannerConfig>(HashUserBannerConfig.class);
        util.exportExcel(response, list, "用户首页的banner列数据");
    }

    /**
     * 获取用户首页的banner列详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hashUserBannerConfigService.selectHashUserBannerConfigById(id));
    }

    /**
     * 新增用户首页的banner列
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:add')")
    @Log(title = "用户首页的banner列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUserBannerConfig hashUserBannerConfig)
    {
        hashUserBannerConfig.setCreateBy(getUsername());
        hashUserBannerConfig.setCreateTime(DateUtils.getNowDate());
        return toAjax(hashUserBannerConfigService.insertHashUserBannerConfig(hashUserBannerConfig));
    }

    /**
     * 修改用户首页的banner列
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:edit')")
    @Log(title = "用户首页的banner列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUserBannerConfig hashUserBannerConfig)
    {
        hashUserBannerConfig.setUpdateBy(getUsername());
        hashUserBannerConfig.setUpdateTime(DateUtils.getNowDate());
        return toAjax(hashUserBannerConfigService.updateHashUserBannerConfig(hashUserBannerConfig));
    }

    /**
     * 删除用户首页的banner列
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserBannerConfig:remove')")
    @Log(title = "用户首页的banner列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hashUserBannerConfigService.deleteHashUserBannerConfigByIds(ids));
    }
}
