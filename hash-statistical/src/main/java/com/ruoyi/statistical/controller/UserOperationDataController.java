package com.ruoyi.statistical.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
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
import com.ruoyi.statistical.domain.UserOperationData;
import com.ruoyi.statistical.service.IUserOperationDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 玩家运营数据Controller
 *
 * @author xxk
 * @date 2022-05-28
 */
@RestController
@RequestMapping("/hash-statistical/statisticalOperation")
public class UserOperationDataController extends BaseController {
    @Autowired
    private IUserOperationDataService userOperationDataService;

    /**
     * 查询玩家运营数据列表
     */
//    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserOperationData userOperationData) {
//        startPage();
        List<UserOperationData> list = userOperationDataService.selectUserOperationDataList(userOperationData);
        Collections.reverse(list);
        return getDataTable(list);
    }


    /**
     * 导出玩家运营数据列表
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:export')")
    @Log(title = "玩家运营数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserOperationData userOperationData) {
        startOrderBy();
        List<UserOperationData> list = userOperationDataService.selectUserOperationDataList(userOperationData);
        ExcelUtil<UserOperationData> util = new ExcelUtil<UserOperationData>(UserOperationData.class);
        util.exportExcel(response, list, "玩家运营数据数据");
    }

    /**
     * 获取玩家运营数据详细信息
     */
//    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(userOperationDataService.selectUserOperationDataById(id));
    }

    /**
     * 新增玩家运营数据
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:add')")
    @Log(title = "玩家运营数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserOperationData userOperationData) {
        return toAjax(userOperationDataService.insertUserOperationData(userOperationData));
    }

    /**
     * 修改玩家运营数据
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:edit')")
    @Log(title = "玩家运营数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserOperationData userOperationData) {
        return toAjax(userOperationDataService.updateUserOperationData(userOperationData));
    }

    /**
     * 删除玩家运营数据
     */
    @PreAuthorize("@ss.hasPermi('hash-statistical:statisticalOperation:remove')")
    @Log(title = "玩家运营数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(userOperationDataService.deleteUserOperationDataByIds(ids));
    }
}
