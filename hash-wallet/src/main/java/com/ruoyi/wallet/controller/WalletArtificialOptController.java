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
import com.ruoyi.wallet.domain.WalletArtificialOpt;
import com.ruoyi.wallet.service.IWalletArtificialOptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人工出入款Controller
 * 
 * @author xxk
 * @date 2022-07-10
 */
@RestController
@RequestMapping("/hash-wallet/walletoOpt")
public class WalletArtificialOptController extends BaseController
{
    @Autowired
    private IWalletArtificialOptService walletArtificialOptService;

    /**
     * 查询人工出入款列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletArtificialOpt walletArtificialOpt)
    {
        startPage();
        startOrderBy();
        List<WalletArtificialOpt> list = walletArtificialOptService.selectWalletArtificialOptList(walletArtificialOpt);
        return getDataTable(list);
    }

    /**
     * 导出人工出入款列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:export')")
    @Log(title = "人工出入款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletArtificialOpt walletArtificialOpt)
    {
        startPage();
        startOrderBy();
        List<WalletArtificialOpt> list = walletArtificialOptService.selectWalletArtificialOptList(walletArtificialOpt);
        for (WalletArtificialOpt artificialOpt : list) {
            artificialOpt.setAmount(artificialOpt.getAmount());
        }
        ExcelUtil<WalletArtificialOpt> util = new ExcelUtil<WalletArtificialOpt>(WalletArtificialOpt.class);
        util.exportExcel(response, list, "人工出入款数据");
    }

    /**
     * 获取人工出入款详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(walletArtificialOptService.selectWalletArtificialOptById(id));
    }

    /**
     * 新增人工出入款
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:add')")
    @Log(title = "人工出入款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletArtificialOpt walletArtificialOpt)
    {
        return toAjax(walletArtificialOptService.insertWalletArtificialOpt(walletArtificialOpt));
    }

    /**
     * 修改人工出入款
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:edit')")
    @Log(title = "人工出入款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletArtificialOpt walletArtificialOpt)
    {
        return toAjax(walletArtificialOptService.updateWalletArtificialOpt(walletArtificialOpt));
    }

    /**
     * 删除人工出入款
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletoOpt:remove')")
    @Log(title = "人工出入款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(walletArtificialOptService.deleteWalletArtificialOptByIds(ids));
    }
}
