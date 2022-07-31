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
import com.ruoyi.wallet.domain.PayOrder;
import com.ruoyi.wallet.service.IPayOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充值订单记录Controller
 * 
 * @author xxk
 * @date 2022-07-31
 */
@RestController
@RequestMapping("/hash-wallet/smallOrder")
public class PayOrderController extends BaseController
{
    @Autowired
    private IPayOrderService payOrderService;

    /**
     * 查询充值订单记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayOrder payOrder)
    {
        startPage();
        List<PayOrder> list = payOrderService.selectPayOrderList(payOrder);
        return getDataTable(list);
    }

    /**
     * 导出充值订单记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:export')")
    @Log(title = "充值订单记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayOrder payOrder)
    {
        startOrderBy();
        List<PayOrder> list = payOrderService.selectPayOrderList(payOrder);
        ExcelUtil<PayOrder> util = new ExcelUtil<PayOrder>(PayOrder.class);
        util.exportExcel(response, list, "充值订单记录数据");
    }

    /**
     * 获取充值订单记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(payOrderService.selectPayOrderById(id));
    }

    /**
     * 新增充值订单记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:add')")
    @Log(title = "充值订单记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayOrder payOrder)
    {
        return toAjax(payOrderService.insertPayOrder(payOrder));
    }

    /**
     * 修改充值订单记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:edit')")
    @Log(title = "充值订单记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayOrder payOrder)
    {
        return toAjax(payOrderService.updatePayOrder(payOrder));
    }

    /**
     * 删除充值订单记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:smallOrder:remove')")
    @Log(title = "充值订单记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(payOrderService.deletePayOrderByIds(ids));
    }
}
