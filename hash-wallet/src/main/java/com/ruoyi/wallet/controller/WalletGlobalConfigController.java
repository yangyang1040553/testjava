package com.ruoyi.wallet.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.wallet.domain.WalletGlobalConfig;
import com.ruoyi.wallet.service.IWalletGlobalConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 钱包全局配置Controller
 *
 * @author xxk
 * @date 2022-05-24
 */
@RestController
@RequestMapping("/hash-wallet/globalWalletConfig")
public class WalletGlobalConfigController extends BaseController {
    @Autowired
    private IWalletGlobalConfigService walletGlobalConfigService;

    @Autowired
    RedisCache redisCache;

    /**
     * 查询钱包全局配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletGlobalConfig walletGlobalConfig) {
        startPage();
        startOrderBy();
        List<WalletGlobalConfig> list = walletGlobalConfigService.selectWalletGlobalConfigList(walletGlobalConfig);
        return getDataTable(list);
    }

    /**
     * 导出钱包全局配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:export')")
    @Log(title = "钱包全局配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletGlobalConfig walletGlobalConfig) {
        startOrderBy();
        List<WalletGlobalConfig> list = walletGlobalConfigService.selectWalletGlobalConfigList(walletGlobalConfig);
        ExcelUtil<WalletGlobalConfig> util = new ExcelUtil<WalletGlobalConfig>(WalletGlobalConfig.class);
        util.exportExcel(response, list, "钱包全局配置数据");
    }

    /**
     * 获取钱包全局配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(walletGlobalConfigService.selectWalletGlobalConfigById(id));
    }

    /**
     * 新增钱包全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:add')")
    @Log(title = "钱包全局配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletGlobalConfig walletGlobalConfig) {
        walletGlobalConfig.setCreateBy(getUsername());
        walletGlobalConfig.setCreateTime(DateUtils.getNowDate());
        return toAjax(walletGlobalConfigService.insertWalletGlobalConfig(walletGlobalConfig));
    }

    /**
     * 修改钱包全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:edit')")
    @Log(title = "钱包全局配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletGlobalConfig walletGlobalConfig) {
        walletGlobalConfig.setUpdateBy(getUsername());
        walletGlobalConfig.setUpdateTime(DateUtils.getNowDate());
        redisCache.deleteObject(RedisKey.wallet_global_config);
        return toAjax(walletGlobalConfigService.updateWalletGlobalConfig(walletGlobalConfig));
    }

    /**
     * 删除钱包全局配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:globalWalletConfig:remove')")
    @Log(title = "钱包全局配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(walletGlobalConfigService.deleteWalletGlobalConfigByIds(ids));
    }
}
