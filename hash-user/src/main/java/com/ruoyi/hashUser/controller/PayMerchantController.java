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
import com.ruoyi.hashUser.domain.PayMerchant;
import com.ruoyi.hashUser.service.IPayMerchantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付商户配置Controller
 * 
 * @author xxk
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/hashUser/merchant")
public class PayMerchantController extends BaseController
{
    @Autowired
    private IPayMerchantService payMerchantService;

    /**
     * 查询支付商户配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayMerchant payMerchant)
    {
        startPage();
        List<PayMerchant> list = payMerchantService.selectPayMerchantList(payMerchant);
        return getDataTable(list);
    }

    /**
     * 导出支付商户配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:export')")
    @Log(title = "支付商户配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayMerchant payMerchant)
    {
        startOrderBy();
        List<PayMerchant> list = payMerchantService.selectPayMerchantList(payMerchant);
        ExcelUtil<PayMerchant> util = new ExcelUtil<PayMerchant>(PayMerchant.class);
        util.exportExcel(response, list, "支付商户配置数据");
    }

    /**
     * 获取支付商户配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(payMerchantService.selectPayMerchantById(id));
    }

    /**
     * 新增支付商户配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:add')")
    @Log(title = "支付商户配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayMerchant payMerchant)
    {
        return toAjax(payMerchantService.insertPayMerchant(payMerchant));
    }

    /**
     * 修改支付商户配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:edit')")
    @Log(title = "支付商户配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayMerchant payMerchant)
    {
        return toAjax(payMerchantService.updatePayMerchant(payMerchant));
    }

    /**
     * 删除支付商户配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:merchant:remove')")
    @Log(title = "支付商户配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(payMerchantService.deletePayMerchantByIds(ids));
    }
}
