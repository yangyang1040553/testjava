package com.ruoyi.statistical.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.statistical.domain.Index;
import com.ruoyi.statistical.domain.Keep;
import com.ruoyi.statistical.service.IIndexService;
import com.ruoyi.statistical.service.IKeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 留存分析Controller
 *
 * @author xxk
 * @date 2022-05-27
 */
@RestController
@RequestMapping("/hash-statistical/index")
public class IndexController extends BaseController {
    @Autowired
    private IIndexService iIndexService;

    /**
     * 查询留存分析列表
     */
    @GetMapping("/list")
    public AjaxResult list() {
        return AjaxResult.success(iIndexService.selectIndex());
    }

    @GetMapping("/currAmountInfo")
    public AjaxResult currAmountInfo() {
        return AjaxResult.success(iIndexService.selectCurrAmountInfo());
    }

    @GetMapping("/indexActive")
    public AjaxResult indexActive() {
        return AjaxResult.success(iIndexService.selectCurrActive());
    }

    @GetMapping("/selectCurrActiveAmount")
    public AjaxResult selectCurrActiveAmount() {
        return AjaxResult.success(iIndexService.selectCurrActiveAmount());
    }
}
