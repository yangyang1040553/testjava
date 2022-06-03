package com.ruoyi.statistical.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.statistical.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
