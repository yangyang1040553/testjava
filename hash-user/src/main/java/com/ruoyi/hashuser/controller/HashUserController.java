package com.ruoyi.hashuser.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.hashuser.redis.UserRedis;
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
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.service.IHashUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 *
 * @author xxk
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/hash-user/HashUserService")

public class HashUserController extends BaseController {
    @Autowired
    private IHashUserService hashUserService;
    @Autowired
    private UserRedis userRedis;

    @Value("${service.user-addr}")
    public String serviceUserAddr;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:list')")
    @GetMapping("/list")
    public TableDataInfo list(HashUser hashUser) {
        startPage();
        startOrderBy();
        List<HashUser> list = hashUserService.selectHashUserList(hashUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HashUser hashUser) {
        startOrderBy();
        List<HashUser> list = hashUserService.selectHashUserList(hashUser);
        ExcelUtil<HashUser> util = new ExcelUtil<HashUser>(HashUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(hashUserService.selectHashUserById(id));
    }


    /**
     * 获取用户每日详细信息
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:queryDetail')")
    @GetMapping(value = "/detail/{id}")
    public AjaxResult getInfoDetail(@PathVariable("id") String id) {
        return AjaxResult.success(hashUserService.selectHashUserDetail(id));
    }


    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HashUser hashUser) {
        return toAjax(hashUserService.insertHashUser(hashUser));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HashUser hashUser) {

        if (StringUtils.isNotBlank(hashUser.getFatherInvitationCode())) {
            HashUser load = hashUserService.selectHashUserById(hashUser.getId());
            if (StringUtils.isNotBlank(load.getFatherInvitationCode()) && !load.getFatherInvitationCode().equals(hashUser.getFatherInvitationCode())) {
                return AjaxResult.error("邀请码已绑定，不能修改");
            } else if (StringUtils.isBlank(load.getFatherInvitationCode())) {
                //判断逻辑

                Map<String, Object> param = new HashMap<>();
                param.put("userId", hashUser.getId());
                param.put("code", hashUser.getFatherInvitationCode());

                final String s = HttpUtils.sendPost(serviceUserAddr + "/user/bindInvitationCode2", param);
                if (org.apache.commons.lang3.StringUtils.isBlank(s)) {
                    return AjaxResult.error();
                }
                final JSONObject jsonObject = JSON.parseObject(s);

                if (!jsonObject.getString("code").equals("200")) {
                    return AjaxResult.error(jsonObject.getString("msg"));
                } else {
                    return AjaxResult.success("绑定成功");
                }
            }

        }


        final int i = hashUserService.updateHashUser(hashUser);
        if (i > 0) {
            if (hashUser.getStatus() == 1) {
                //冻结玩家
                userRedis.delUserToken(hashUser.getId());
            }

//            if (StringUtils.isNotBlank(hashUser.getNoteName())) {
//                userRedis.setUserObject(hashUser.getId(), "nickName", hashUser.getNickName());
//            }
            userRedis.delUserObject(hashUser.getId());

        }

        return toAjax(i);
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('hash-user:HashUserService:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(hashUserService.deleteHashUserByIds(ids));
    }
}
