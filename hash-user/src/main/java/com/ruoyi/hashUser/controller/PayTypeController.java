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
import com.ruoyi.hashUser.domain.PayType;
import com.ruoyi.hashUser.service.IPayTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付类型配置Controller
 * 
 * @author xxk
 * @date 2023-01-05
 */
@RestController
@RequestMapping("/hashUser/type")
public class PayTypeController extends BaseController
{
    @Autowired
    private IPayTypeService payTypeService;

    /**
     * 查询支付类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayType payType)
    {
        startPage();
        List<PayType> list = payTypeService.selectPayTypeList(payType);
        return getDataTable(list);
    }

    /**
     * 导出支付类型配置列表
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:export')")
    @Log(title = "支付类型配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayType payType)
    {
        startOrderBy();
        List<PayType> list = payTypeService.selectPayTypeList(payType);
        ExcelUtil<PayType> util = new ExcelUtil<PayType>(PayType.class);
        util.exportExcel(response, list, "支付类型配置数据");
    }

    /**
     * 获取支付类型配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(payTypeService.selectPayTypeById(id));
    }

    /**
     * 新增支付类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:add')")
    @Log(title = "支付类型配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayType payType)
    {
        return toAjax(payTypeService.insertPayType(payType));
    }

    /**
     * 修改支付类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:edit')")
    @Log(title = "支付类型配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayType payType)
    {
        return toAjax(payTypeService.updatePayType(payType));
    }

    /**
     * 删除支付类型配置
     */
    @PreAuthorize("@ss.hasPermi('hashUser:type:remove')")
    @Log(title = "支付类型配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(payTypeService.deletePayTypeByIds(ids));
    }
}
