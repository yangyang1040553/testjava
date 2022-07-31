package com.ruoyi.wallet.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.redis.RedisKey;
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
import com.ruoyi.wallet.domain.PayChannel;
import com.ruoyi.wallet.service.IPayChannelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付通道配置Controller
 *
 * @author xxk
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/hash-wallet/walletChannel")
public class PayChannelController extends BaseController {
    @Autowired
    private IPayChannelService payChannelService;

    @Autowired
    RedisCache redisCache;

    /***
     * 删除支付通道
     */
    public void delPayChannels() {
        redisCache.deleteObject(RedisKey.wallet_pay_channels);
    }


    /**
     * 查询支付通道配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:list')")
    @GetMapping("/list")
    public TableDataInfo list(PayChannel payChannel) {
        startPage();
        List<PayChannel> list = payChannelService.selectPayChannelList(payChannel);
        return getDataTable(list);
    }

    /**
     * 导出支付通道配置列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:export')")
    @Log(title = "支付通道配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PayChannel payChannel) {
        startOrderBy();
        List<PayChannel> list = payChannelService.selectPayChannelList(payChannel);
        ExcelUtil<PayChannel> util = new ExcelUtil<PayChannel>(PayChannel.class);
        util.exportExcel(response, list, "支付通道配置数据");
    }

    /**
     * 获取支付通道配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(payChannelService.selectPayChannelById(id));
    }

    /**
     * 新增支付通道配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:add')")
    @Log(title = "支付通道配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PayChannel payChannel) {
        delPayChannels();
        return toAjax(payChannelService.insertPayChannel(payChannel));
    }

    /**
     * 修改支付通道配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:edit')")
    @Log(title = "支付通道配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PayChannel payChannel) {
        delPayChannels();
        return toAjax(payChannelService.updatePayChannel(payChannel));
    }

    /**
     * 删除支付通道配置
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:walletChannel:remove')")
    @Log(title = "支付通道配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        delPayChannels();
        return toAjax(payChannelService.deletePayChannelByIds(ids));
    }
}
