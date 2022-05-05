package com.ruoyi.business.controller;

import com.ruoyi.business.domain.TelegramBot;
import com.ruoyi.business.service.ITelegramBotService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用于对外访问 无权限的接口
 * @author xxk
 * @date 2022-05-02
 */
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {
    @Autowired
    private ITelegramBotService telegramBotService;


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(telegramBotService.selectTelegramBotById(id));
    }


}