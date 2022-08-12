package com.ruoyi.wallet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Global;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.GoogleAuthenticator;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.sign.Md5Utils;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.wallet.domain.WalletRechargeOrder;
import com.ruoyi.wallet.vo.WalletInOutMoneyVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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
import com.ruoyi.wallet.domain.WalletPlayerData;
import com.ruoyi.wallet.service.IWalletPlayerDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户钱包Controller
 *
 * @author xxk
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/hash-wallet/management")
@Configuration
public class WalletPlayerDataController extends BaseController {

    @Value("${service.wallet-addr}")
    public String serviceWalletAddr;

    @Autowired
    private IWalletPlayerDataService walletPlayerDataService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询用户钱包列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:list')")
    @GetMapping("/list")
    public TableDataInfo list(WalletPlayerData walletPlayerData) {
        startPage();
        List<WalletPlayerData> list = walletPlayerDataService.selectWalletPlayerDataList(walletPlayerData);
        return getDataTable(list);
    }

    /**
     * 导出用户钱包列表
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:export')")
    @Log(title = "用户钱包", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WalletPlayerData walletPlayerData) {
        startOrderBy();
        List<WalletPlayerData> list = walletPlayerDataService.selectWalletPlayerDataList(walletPlayerData);
        for (WalletPlayerData statisticalPlayerDay : list) {
            statisticalPlayerDay.setTrxAmount(statisticalPlayerDay.getTrxAmount());
            statisticalPlayerDay.setUsdtAmount(statisticalPlayerDay.getUsdtAmount());
            statisticalPlayerDay.setTrxRemoteAmount(statisticalPlayerDay.getTrxRemoteAmount());
            statisticalPlayerDay.setUsdtRemoteAmount(statisticalPlayerDay.getUsdtRemoteAmount());
            statisticalPlayerDay.setTrxWithdrawTotal(statisticalPlayerDay.getTrxWithdrawTotal());
            statisticalPlayerDay.setUsdtWithdrawTotal(statisticalPlayerDay.getUsdtWithdrawTotal());
            statisticalPlayerDay.setTrxRechargeTotal(statisticalPlayerDay.getTrxRechargeTotal());
            statisticalPlayerDay.setUsdtRechargeTotal(statisticalPlayerDay.getUsdtRechargeTotal());
        }
        ExcelUtil<WalletPlayerData> util = new ExcelUtil<WalletPlayerData>(WalletPlayerData.class);
        util.exportExcel(response, list, "用户钱包数据");
    }

    /**
     * 获取用户钱包详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(walletPlayerDataService.selectWalletPlayerDataById(id));
    }

    /**
     * 新增用户钱包
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:add')")
    @Log(title = "用户钱包", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WalletPlayerData walletPlayerData) {
        return toAjax(walletPlayerDataService.insertWalletPlayerData(walletPlayerData));
    }


    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 修改用户钱包
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:edit')")
    @Log(title = "用户钱包", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WalletInOutMoneyVo walletInOutMoneyVo) {

        // 谷歌验证授权
        SysUser sysUser = userService.selectUserByUserName(getUsername());
        String secret = sysUser.getSecret();
        boolean authCode = GoogleAuthenticator.authcode(walletInOutMoneyVo.getGoogleCode(), secret);

        List<SysRole> sysRoles = roleMapper.selectRolesByUserName(getUsername());
        if (sysRoles.size() > 0) {
            if (sysRoles.get(0).getMax_money()==null) {
                return AjaxResult.error("请联系超级管理员为当前角色设置最大人工出入款金额！！");
            }
            Integer max_money = sysRoles.get(0).getMax_money();
            if (Math.abs(walletInOutMoneyVo.getAmount()) > max_money) {
                return AjaxResult.error("超过当前角色最大人工出入款金额！");
            }
        }


        if (!authCode) {
            return AjaxResult.error("验证码错误或已过期");
        }

        if (StringUtils.isBlank(walletInOutMoneyVo.getId())) {
            return AjaxResult.error("id为空");
        }

        if (StringUtils.isBlank(walletInOutMoneyVo.getWalletType())) {
            return AjaxResult.error("钱包类型为空");
        }


        Map<String, Object> param = new HashMap<>();
        param.put("userId", walletInOutMoneyVo.getId());
        param.put("walletType", walletInOutMoneyVo.getWalletType());
        param.put("amount", walletInOutMoneyVo.getAmount());
        param.put("note", walletInOutMoneyVo.getNote());
        param.put("optPerson", getUsername());

        final String hash = Md5Utils.hash(Global.USER_SECRET_KEY + walletInOutMoneyVo.getId() + walletInOutMoneyVo.getWalletType() + walletInOutMoneyVo.getAmount());
        param.put("sign", hash);

        final String s = HttpUtils.sendPost(serviceWalletAddr + "/wallet/back/backAddMoney", param);
        if (StringUtils.isBlank(s)) {
            return AjaxResult.error();
        }
        final JSONObject jsonObject = JSON.parseObject(s);

        if (!jsonObject.getString("code").equals("200")) {
            return AjaxResult.error(jsonObject.getString("msg"));
        }
        return AjaxResult.success();
    }

    /**
     * 删除用户钱包
     */
    @PreAuthorize("@ss.hasPermi('hash-wallet:management:remove')")
    @Log(title = "用户钱包", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(walletPlayerDataService.deleteWalletPlayerDataByIds(ids));
    }
}
