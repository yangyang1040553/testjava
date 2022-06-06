package com.ruoyi.wallet.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.wallet.domain.WalletTransactionOrder;
import com.ruoyi.wallet.service.IWalletTransactionOrderService;
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
 * 转换订单Controller
 * 
 * @author xxk
 * @date 2022-05-26
 */
@RestController
@RequestMapping("/hash-wallet/walletOrder")
public class WalletTransactionOrderController extends BaseController
{
    @Autowired
    private IWalletTransactionOrderService walletTransactionOrderService;

    /**
     * 查询转换订单列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletTransactionOrder walletTransactionOrder)
    {
        startPage();
        startOrderBy();
        List<WalletTransactionOrder> list = walletTransactionOrderService.selectWalletTransactionOrderList(walletTransactionOrder);
        return getDataTable(list);
    }

    /**
     * 导出转换订单列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:export')")
    @Log(title = "转换订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletTransactionOrder walletTransactionOrder)
    {
        List<WalletTransactionOrder> list = walletTransactionOrderService.selectWalletTransactionOrderList(walletTransactionOrder);
        ExcelUtil<WalletTransactionOrder> util = new ExcelUtil<WalletTransactionOrder>(WalletTransactionOrder.class);
        util.exportExcel(response, list, "转换订单数据");
    }

    /**
     * 获取转换订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(walletTransactionOrderService.selectWalletTransactionOrderById(id));
    }

    /**
     * 新增转换订单
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:add')")
    @Log(title = "转换订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletTransactionOrder walletTransactionOrder)
    {
        return toAjax(walletTransactionOrderService.insertWalletTransactionOrder(walletTransactionOrder));
    }

    /**
     * 修改转换订单
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:edit')")
    @Log(title = "转换订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletTransactionOrder walletTransactionOrder)
    {
        return toAjax(walletTransactionOrderService.updateWalletTransactionOrder(walletTransactionOrder));
    }

    /**
     * 删除转换订单
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:remove')")
    @Log(title = "转换订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(walletTransactionOrderService.deleteWalletTransactionOrderByIds(ids));
    }
}
