package com.ruoyi.hashUser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.hashUser.redis.UserRedis;
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
import com.ruoyi.hashUser.domain.UserBannerConfig;
import com.ruoyi.hashUser.service.IUserBannerConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Banner图Controller
 *
 * @author xxk
 * @date 2023-01-07
 */
@RestController
@RequestMapping("/hashUser/bannerConfig")
public class UserBannerConfigController extends BaseController {

    @Autowired
    UserRedis userRedis;
    @Autowired
    private IUserBannerConfigService userBannerConfigService;

    /**
     * 查询Banner图列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserBannerConfig userBannerConfig) {
        startPage();
        List<UserBannerConfig> list = userBannerConfigService.selectUserBannerConfigList(userBannerConfig);
        return getDataTable(list);
    }

    /**
     * 导出Banner图列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:export')")
    @Log(title = "Banner图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserBannerConfig userBannerConfig) {
        startOrderBy();
        List<UserBannerConfig> list = userBannerConfigService.selectUserBannerConfigList(userBannerConfig);
        ExcelUtil<UserBannerConfig> util = new ExcelUtil<UserBannerConfig>(UserBannerConfig.class);
        util.exportExcel(response, list, "Banner图数据");
    }

    /**
     * 获取Banner图详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(userBannerConfigService.selectUserBannerConfigById(id));
    }

    /**
     * 新增Banner图
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:add')")
    @Log(title = "Banner图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserBannerConfig userBannerConfig) {
        userRedis.delUserBanner();
        return toAjax(userBannerConfigService.insertUserBannerConfig(userBannerConfig));
    }

    /**
     * 修改Banner图
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:edit')")
    @Log(title = "Banner图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserBannerConfig userBannerConfig) {
        userRedis.delUserBanner();
        return toAjax(userBannerConfigService.updateUserBannerConfig(userBannerConfig));
    }

    /**
     * 删除Banner图
     */
    @PreAuthorize("@ss.hasPermi('hashUser:bannerConfig:remove')")
    @Log(title = "Banner图", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        userRedis.delUserBanner();
        return toAjax(userBannerConfigService.deleteUserBannerConfigByIds(ids));
    }
}
