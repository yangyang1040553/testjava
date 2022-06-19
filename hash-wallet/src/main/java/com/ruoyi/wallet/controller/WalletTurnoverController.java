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
import com.ruoyi.wallet.domain.WalletTurnover;
import com.ruoyi.wallet.service.IWalletTurnoverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 钱包流水记录Controller
 * 
 * @author xxk
 * @date 2022-06-06
 */
@RestController
@RequestMapping("/hash-wallet/walletTurnover")
public class WalletTurnoverController extends BaseController
{
    @Autowired
    private IWalletTurnoverService walletTurnoverService;

    /**
     * 查询钱包流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletTurnover walletTurnover)
    {
        startPage();
        startOrderBy();
        List<WalletTurnover> list = walletTurnoverService.selectWalletTurnoverList(walletTurnover);
        return getDataTable(list);
    }

    /**
     * 导出钱包流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:export')")
    @Log(title = "钱包流水记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletTurnover walletTurnover)
    {
        startOrderBy();
        List<WalletTurnover> list = walletTurnoverService.selectWalletTurnoverList(walletTurnover);
        ExcelUtil<WalletTurnover> util = new ExcelUtil<WalletTurnover>(WalletTurnover.class);
        util.exportExcel(response, list, "钱包流水记录数据");
    }

    /**
     * 获取钱包流水记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(walletTurnoverService.selectWalletTurnoverById(id));
    }

    /**
     * 新增钱包流水记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:add')")
    @Log(title = "钱包流水记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletTurnover walletTurnover)
    {
        return toAjax(walletTurnoverService.insertWalletTurnover(walletTurnover));
    }

    /**
     * 修改钱包流水记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:edit')")
    @Log(title = "钱包流水记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletTurnover walletTurnover)
    {
        return toAjax(walletTurnoverService.updateWalletTurnover(walletTurnover));
    }

    /**
     * 删除钱包流水记录
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletTurnover:remove')")
    @Log(title = "钱包流水记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(walletTurnoverService.deleteWalletTurnoverByIds(ids));
    }
}
