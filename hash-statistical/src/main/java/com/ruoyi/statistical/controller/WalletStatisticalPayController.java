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
import com.ruoyi.statistical.domain.WalletStatisticalPay;
import com.ruoyi.statistical.service.IWalletStatisticalPayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 钱包日支付统计Controller
 *
 * @author xxk
 * @date 2022-06-24
 */
@RestController
@RequestMapping("/hash-statistical/everyDay")
public class WalletStatisticalPayController extends BaseController {
    @Autowired
    private IWalletStatisticalPayService walletStatisticalPayService;

    /**
     * 查询钱包日支付统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletStatisticalPay walletStatisticalPay) {
        startPage();
        startOrderBy();
        List<WalletStatisticalPay> list = walletStatisticalPayService.selectWalletStatisticalPayList(walletStatisticalPay);
        return getDataTable(list);
    }

    /**
     * 导出钱包日支付统计列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:export')")
    @Log(title = "钱包日支付统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletStatisticalPay walletStatisticalPay) {
        startOrderBy();
        List<WalletStatisticalPay> list = walletStatisticalPayService.selectWalletStatisticalPayList(walletStatisticalPay);
        for (WalletStatisticalPay walletStatistical : list) {
            walletStatistical.setTrxAmountWithdraw(walletStatistical.getTrxAmountWithdraw());
            walletStatistical.setUsdtAmountWithdraw(walletStatistical.getUsdtAmountWithdraw());
            walletStatistical.setTrxAmountRecharge(walletStatistical.getTrxAmountRecharge());
            walletStatistical.setUsdtAmountRecharge(walletStatistical.getUsdtAmountRecharge());
            walletStatistical.setUsdt_amount_trans(walletStatistical.getUsdt_amount_trans());
            walletStatistical.setTrx_amount_trans(walletStatistical.getTrx_amount_trans());

        }
        ExcelUtil<WalletStatisticalPay> util = new ExcelUtil<WalletStatisticalPay>(WalletStatisticalPay.class);
        util.exportExcel(response, list, "钱包日支付统计数据");
    }

    /**
     * 获取钱包日支付统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(walletStatisticalPayService.selectWalletStatisticalPayById(id));
    }

    /**
     * 新增钱包日支付统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:add')")
    @Log(title = "钱包日支付统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletStatisticalPay walletStatisticalPay) {
        return toAjax(walletStatisticalPayService.insertWalletStatisticalPay(walletStatisticalPay));
    }

    /**
     * 修改钱包日支付统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:edit')")
    @Log(title = "钱包日支付统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletStatisticalPay walletStatisticalPay) {
        return toAjax(walletStatisticalPayService.updateWalletStatisticalPay(walletStatisticalPay));
    }

    /**
     * 删除钱包日支付统计
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:everyDay:remove')")
    @Log(title = "钱包日支付统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(walletStatisticalPayService.deleteWalletStatisticalPayByIds(ids));
    }
}
