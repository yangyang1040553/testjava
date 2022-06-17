package com.ruoyi.wallet.controller;

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
import com.ruoyi.wallet.domain.WalletRechargeOrder;
import com.ruoyi.wallet.service.IWalletRechargeOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充值Controller
 * 
 * @author xxk
 * @date 2022-06-17
 */
@RestController
@RequestMapping("/hash-wallet/rechargeOrder")
public class WalletRechargeOrderController extends BaseController
{
    @Autowired
    private IWalletRechargeOrderService walletRechargeOrderService;

    /**
     * 查询充值列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletRechargeOrder walletRechargeOrder)
    {
        startPage();
        startOrderBy();
        List<WalletRechargeOrder> list = walletRechargeOrderService.selectWalletRechargeOrderList(walletRechargeOrder);
        return getDataTable(list);
    }

    /**
     * 导出充值列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:export')")
    @Log(title = "充值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletRechargeOrder walletRechargeOrder)
    {
        List<WalletRechargeOrder> list = walletRechargeOrderService.selectWalletRechargeOrderList(walletRechargeOrder);
        ExcelUtil<WalletRechargeOrder> util = new ExcelUtil<WalletRechargeOrder>(WalletRechargeOrder.class);
        util.exportExcel(response, list, "充值数据");
    }

    /**
     * 获取充值详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(walletRechargeOrderService.selectWalletRechargeOrderById(id));
    }

    /**
     * 新增充值
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:add')")
    @Log(title = "充值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletRechargeOrder walletRechargeOrder)
    {
        return toAjax(walletRechargeOrderService.insertWalletRechargeOrder(walletRechargeOrder));
    }

    /**
     * 修改充值
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:edit')")
    @Log(title = "充值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletRechargeOrder walletRechargeOrder)
    {
        return toAjax(walletRechargeOrderService.updateWalletRechargeOrder(walletRechargeOrder));
    }

    /**
     * 删除充值
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:rechargeOrder:remove')")
    @Log(title = "充值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(walletRechargeOrderService.deleteWalletRechargeOrderByIds(ids));
    }
}
