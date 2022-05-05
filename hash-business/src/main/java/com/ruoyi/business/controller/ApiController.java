package com.ruoyi.business.controller;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;


/**
 * 用于对外访问 无权限的接口
 * @author xxk
 * @date 2022-05-02
 */
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success();
    }


}