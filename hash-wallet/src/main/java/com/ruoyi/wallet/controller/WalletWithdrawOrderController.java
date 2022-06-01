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
import com.ruoyi.wallet.domain.WalletWithdrawOrder;
import com.ruoyi.wallet.service.IWalletWithdrawOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现审核Controller
 * 
 * @author xxk
 * @date 2022-05-31
 */
@RestController
@RequestMapping("/hash-wallet/walletWidthdrawOrder")
public class WalletWithdrawOrderController extends BaseController
{
    @Autowired
    private IWalletWithdrawOrderService walletWithdrawOrderService;

    /**
     * 查询提现审核列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletWithdrawOrder walletWithdrawOrder)
    {
        startPage();
        List<WalletWithdrawOrder> list = walletWithdrawOrderService.selectWalletWithdrawOrderList(walletWithdrawOrder);
        return getDataTable(list);
    }

    /**
     * 导出提现审核列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:export')")
    @Log(title = "提现审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletWithdrawOrder walletWithdrawOrder)
    {
        List<WalletWithdrawOrder> list = walletWithdrawOrderService.selectWalletWithdrawOrderList(walletWithdrawOrder);
        ExcelUtil<WalletWithdrawOrder> util = new ExcelUtil<WalletWithdrawOrder>(WalletWithdrawOrder.class);
        util.exportExcel(response, list, "提现审核数据");
    }

    /**
     * 获取提现审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(walletWithdrawOrderService.selectWalletWithdrawOrderById(id));
    }

    /**
     * 新增提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:add')")
    @Log(title = "提现审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletWithdrawOrder walletWithdrawOrder)
    {
        return toAjax(walletWithdrawOrderService.insertWalletWithdrawOrder(walletWithdrawOrder));
    }

    /**
     * 修改提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:edit')")
    @Log(title = "提现审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletWithdrawOrder walletWithdrawOrder)
    {
        return toAjax(walletWithdrawOrderService.updateWalletWithdrawOrder(walletWithdrawOrder));
    }

    /**
     * 删除提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletWidthdrawOrder:remove')")
    @Log(title = "提现审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(walletWithdrawOrderService.deleteWalletWithdrawOrderByIds(ids));
    }
}
