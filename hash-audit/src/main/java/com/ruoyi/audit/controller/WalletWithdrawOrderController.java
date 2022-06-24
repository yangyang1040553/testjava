package com.ruoyi.audit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Global;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.sign.Md5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
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
import com.ruoyi.audit.domain.WalletWithdrawOrder;
import com.ruoyi.audit.service.IWalletWithdrawOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现审核Controller
 *
 * @author xxk
 * @date 2022-06-02
 */
@RestController
@RequestMapping("/hash-audit/auditWidthdrawOrder")
public class WalletWithdrawOrderController extends BaseController {

    @Value("${service.wallet-addr}")
    public String serviceWalletAddr;

    @Autowired
    private IWalletWithdrawOrderService walletWithdrawOrderService;

    /**
     * 查询提现审核列表
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletWithdrawOrder walletWithdrawOrder) {
        startPage();
        startOrderBy();
        List<WalletWithdrawOrder> list = walletWithdrawOrderService.selectWalletWithdrawOrderList(walletWithdrawOrder);
        return getDataTable(list);
    }

    /**
     * 查询当日
     */
//    @PreAuthorize("@ss.hasPermi('hash-wallet:walletOrder:list')")
    @GetMapping("/getCurrDay")
    public TableDataInfo getCurrDay() {
        List<WalletWithdrawOrder> list = walletWithdrawOrderService.selectCurrDay();
        return getDataTable(list);
    }

    /**
     * 导出提现审核列表
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:export')")
    @Log(title = "提现审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletWithdrawOrder walletWithdrawOrder) {
        startOrderBy();
        List<WalletWithdrawOrder> list = walletWithdrawOrderService.selectWalletWithdrawOrderList(walletWithdrawOrder);
        ExcelUtil<WalletWithdrawOrder> util = new ExcelUtil<WalletWithdrawOrder>(WalletWithdrawOrder.class);
        util.exportExcel(response, list, "提现审核数据");
    }

    /**
     * 获取提现审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(walletWithdrawOrderService.selectWalletWithdrawOrderById(id));
    }

    /**
     * 新增提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:add')")
    @Log(title = "提现审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletWithdrawOrder walletWithdrawOrder) {
        return toAjax(walletWithdrawOrderService.insertWalletWithdrawOrder(walletWithdrawOrder));
    }

    /**
     * 修改提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:edit')")
    @Log(title = "提现审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletWithdrawOrder walletWithdrawOrder) {
        walletWithdrawOrder.setUpdateBy(getUsername());

        final WalletWithdrawOrder order = walletWithdrawOrderService.selectWalletWithdrawOrderById(walletWithdrawOrder.getId());
        if (order.getCheckPerson() != null) {
            if (!order.getCheckPerson().equals(getUsername())) {
                new AjaxResult(HttpStatus.ERROR, "该订单无权限操作");
            }
        } else {
            walletWithdrawOrder.setCheckPerson(getUsername());
        }

        //判断状态是否等于3
        if ("3".equals(walletWithdrawOrder.getCheckStatus())) {

            if (walletWithdrawOrder.getStatus() == 0) {
                Map<String, Object> param = new HashMap<>();
                param.put("orderId", walletWithdrawOrder.getId());
                param.put("isPass", true);

                final String hash = Md5Utils.hash(Global.USER_SECRET_KEY + walletWithdrawOrder.getId());
                param.put("sign", hash);

                final String s = HttpUtils.sendPost(serviceWalletAddr + "/wallet/back/withdrawResult", param);
                if (StringUtils.isBlank(s)) {
                    return AjaxResult.error();
                }
                final JSONObject jsonObject = JSON.parseObject(s);

                if (!jsonObject.getString("code").equals("200")) {
                    return AjaxResult.error(jsonObject.getString("msg"));
                }

                walletWithdrawOrderService.updateWalletWithdrawOrder(walletWithdrawOrder);
                return AjaxResult.success("审核通过，已转账");
            }


        } else if ("2".equals(walletWithdrawOrder.getCheckStatus())) {
            //提现拒绝
            Map<String, Object> param = new HashMap<>();
            param.put("orderId", walletWithdrawOrder.getId());
            param.put("isPass", false);

            final String hash = Md5Utils.hash(Global.USER_SECRET_KEY + walletWithdrawOrder.getId());
            param.put("sign", hash);

            final String s = HttpUtils.sendPost(serviceWalletAddr + "/wallet/back/withdrawResult", param);
            if (StringUtils.isBlank(s)) {
                return AjaxResult.error();
            }
            final JSONObject jsonObject = JSON.parseObject(s);

            if (!jsonObject.getString("code").equals("200")) {
                return AjaxResult.error(jsonObject.getString("msg"));
            }
            //设置状态为拒绝
            walletWithdrawOrder.setStatus(2L);
        }


        return toAjax(walletWithdrawOrderService.updateWalletWithdrawOrder(walletWithdrawOrder) > 0);
    }

    /**
     * 删除提现审核
     */
    @PreAuthorize("@ss.hasPermi('hash-audit:auditWidthdrawOrder:remove')")
    @Log(title = "提现审核", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(walletWithdrawOrderService.deleteWalletWithdrawOrderByIds(ids));
    }
}
