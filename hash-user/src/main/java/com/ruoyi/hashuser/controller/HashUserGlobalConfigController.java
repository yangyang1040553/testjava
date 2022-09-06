package com.ruoyi.hashuser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.hashuser.redis.UserRedis;
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
import com.ruoyi.hashuser.domain.HashUserGlobalConfig;
import com.ruoyi.hashuser.service.IHashUserGlobalConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户全局配置Controller
 *
 * @author xxk
 * @date 2022-05-12
 */
@RestController
@RequestMapping("/hash-user/hashUserConfig")
public class HashUserGlobalConfigController extends BaseController {
    @Autowired
    private IHashUserGlobalConfigService hashUserGlobalConfigService;
    @Autowired
    private UserRedis userRedis;

    /**
     * 查询用户全局配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUserGlobalConfig hashUserGlobalConfig) {
        //测试
        startPage();
        List<HashUserGlobalConfig> list = hashUserGlobalConfigService.selectHashUserGlobalConfigList(hashUserGlobalConfig);
        return getDataTable(list);
    }

    /**
     * 导出用户全局配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:export')")
    @Log(title = "用户全局配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUserGlobalConfig hashUserGlobalConfig) {
        startOrderBy();
        List<HashUserGlobalConfig> list = hashUserGlobalConfigService.selectHashUserGlobalConfigList(hashUserGlobalConfig);
        ExcelUtil<HashUserGlobalConfig> util = new ExcelUtil<HashUserGlobalConfig>(HashUserGlobalConfig.class);
        util.exportExcel(response, list, "用户全局配置数据");
    }

    /**
     * 获取用户全局配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(hashUserGlobalConfigService.selectHashUserGlobalConfigById(id));
    }

    /**
     * 新增用户全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:add')")
    @Log(title = "用户全局配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUserGlobalConfig hashUserGlobalConfig) {
        hashUserGlobalConfig.setCreateBy(getUsername());
        hashUserGlobalConfig.setCreateTime(DateUtils.getNowDate());
        return toAjax(hashUserGlobalConfigService.insertHashUserGlobalConfig(hashUserGlobalConfig));
    }

    /**
     * 修改用户全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:edit')")
    @Log(title = "用户全局配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUserGlobalConfig hashUserGlobalConfig) {
        hashUserGlobalConfig.setUpdateBy(getUsername());
        hashUserGlobalConfig.setUpdateTime(DateUtils.getNowDate());

        final int i = hashUserGlobalConfigService.updateHashUserGlobalConfig(hashUserGlobalConfig);
        if (i > 0) {
            userRedis.delUserGlobalConfig();
        }

        return toAjax(i);
    }

    /**
     * 删除用户全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-user:hashUserConfig:remove')")
    @Log(title = "用户全局配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(hashUserGlobalConfigService.deleteHashUserGlobalConfigByIds(ids));
    }
}
