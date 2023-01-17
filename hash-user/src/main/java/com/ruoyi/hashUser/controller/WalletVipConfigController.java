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
import com.ruoyi.hashUser.domain.WalletVipConfig;
import com.ruoyi.hashUser.service.IWalletVipConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIP类型配置Controller
 * 
 * @author xxk
 * @date 2023-01-06
 */
@RestController
@RequestMapping("/hashUser/config")
public class WalletVipConfigController extends BaseController
{
    @Autowired
    private IWalletVipConfigService walletVipConfigService;

    /**
     * 查询VIP类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletVipConfig walletVipConfig)
    {
        startPage();
        List<WalletVipConfig> list = walletVipConfigService.selectWalletVipConfigList(walletVipConfig);
        return getDataTable(list);
    }

    /**
     * 导出VIP类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:export')")
    @Log(title = "VIP类型配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletVipConfig walletVipConfig)
    {
        startOrderBy();
        List<WalletVipConfig> list = walletVipConfigService.selectWalletVipConfigList(walletVipConfig);
        ExcelUtil<WalletVipConfig> util = new ExcelUtil<WalletVipConfig>(WalletVipConfig.class);
        util.exportExcel(response, list, "VIP类型配置数据");
    }

    /**
     * 获取VIP类型配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(walletVipConfigService.selectWalletVipConfigById(id));
    }

    /**
     * 新增VIP类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:add')")
    @Log(title = "VIP类型配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletVipConfig walletVipConfig)
    {
        return toAjax(walletVipConfigService.insertWalletVipConfig(walletVipConfig));
    }

    /**
     * 修改VIP类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:edit')")
    @Log(title = "VIP类型配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletVipConfig walletVipConfig)
    {
        return toAjax(walletVipConfigService.updateWalletVipConfig(walletVipConfig));
    }

    /**
     * 删除VIP类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:config:remove')")
    @Log(title = "VIP类型配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(walletVipConfigService.deleteWalletVipConfigByIds(ids));
    }
}
