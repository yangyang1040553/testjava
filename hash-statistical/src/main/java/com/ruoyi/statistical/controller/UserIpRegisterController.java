package com.ruoyi.statistical.controller;

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
import com.ruoyi.statistical.domain.UserIpRegister;
import com.ruoyi.statistical.service.IUserIpRegisterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户ip注册次数Controller
 * 
 * @author xxk
 * @date 2022-05-31
 */
@RestController
@RequestMapping("/hash-statistical/register")
public class UserIpRegisterController extends BaseController
{
    @Autowired
    private IUserIpRegisterService userIpRegisterService;

    /**
     * 查询用户ip注册次数列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserIpRegister userIpRegister)
    {
        startPage();
        startOrderBy();
        List<UserIpRegister> list = userIpRegisterService.selectUserIpRegisterList(userIpRegister);
        return getDataTable(list);
    }

    /**
     * 导出用户ip注册次数列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:export')")
    @Log(title = "用户ip注册次数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserIpRegister userIpRegister)
    {
        startOrderBy();
        List<UserIpRegister> list = userIpRegisterService.selectUserIpRegisterList(userIpRegister);
        ExcelUtil<UserIpRegister> util = new ExcelUtil<UserIpRegister>(UserIpRegister.class);
        util.exportExcel(response, list, "用户ip注册次数数据");
    }

    /**
     * 获取用户ip注册次数详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:query')")
    @GetMapping(value = "/{ip}")
    public AjaxResult getInfo(@PathVariable("ip") String ip)
    {
        return AjaxResult.success(userIpRegisterService.selectUserIpRegisterByIp(ip));
    }

    /**
     * 新增用户ip注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:add')")
    @Log(title = "用户ip注册次数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserIpRegister userIpRegister)
    {
        return toAjax(userIpRegisterService.insertUserIpRegister(userIpRegister));
    }

    /**
     * 修改用户ip注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:edit')")
    @Log(title = "用户ip注册次数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserIpRegister userIpRegister)
    {
        return toAjax(userIpRegisterService.updateUserIpRegister(userIpRegister));
    }

    /**
     * 删除用户ip注册次数
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:register:remove')")
    @Log(title = "用户ip注册次数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ips}")
    public AjaxResult remove(@PathVariable String[] ips)
    {
        return toAjax(userIpRegisterService.deleteUserIpRegisterByIps(ips));
    }
}
