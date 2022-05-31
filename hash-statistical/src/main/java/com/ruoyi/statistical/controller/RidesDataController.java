package com.ruoyi.statistical.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.statistical.domain.UserOperationData;
import com.ruoyi.statistical.redis.GameRedis;
import com.ruoyi.statistical.service.IRedisService;
import com.ruoyi.statistical.service.IUserOperationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 玩家运营数据Controller
 *
 * @author xxk
 * @date 2022-05-28
 */
@RestController
@RequestMapping("/hash-statistical/redis")
public class RidesDataController extends BaseController {

    @Autowired
    IRedisService iRedisService;

    /**
     * 查询玩家运营数据列表
     */
    @PostMapping("/onlineList")
    public TableDataInfo list(@RequestBody HashUser hashUser) {
        startPage();
        startOrderBy();
        return iRedisService.getOnLineList(hashUser);
    }


}
