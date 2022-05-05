package com.ruoyi.web.controller.business;

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
import com.ruoyi.business.domain.TelegramBot;
import com.ruoyi.business.service.ITelegramBotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机器人Controller
 * 
 * @author xxk
 * @date 2022-05-02
 */
@RestController
@RequestMapping("/telegram/bot")
public class TelegramBotController extends BaseController
{
    @Autowired
    private ITelegramBotService telegramBotService;

    /**
     * 查询机器人列表
     */
    @PreAuthorize("@ss.hasPermi('telegram:bot:list')")
    @GetMapping("/list")
    public TableDataInfo list(TelegramBot telegramBot)
    {
        startPage();
        List<TelegramBot> list = telegramBotService.selectTelegramBotList(telegramBot);
        return getDataTable(list);
    }

    /**
     * 导出机器人列表
     */
    @PreAuthorize("@ss.hasPermi('telegram:bot:export')")
    @Log(title = "机器人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TelegramBot telegramBot)
    {
        List<TelegramBot> list = telegramBotService.selectTelegramBotList(telegramBot);
        ExcelUtil<TelegramBot> util = new ExcelUtil<TelegramBot>(TelegramBot.class);
        util.exportExcel(response, list, "机器人数据");
    }


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(telegramBotService.selectTelegramBotById(id));
    }


    /**
     * 新增机器人
     */
    @PreAuthorize("@ss.hasPermi('telegram:bot:add')")
    @Log(title = "机器人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TelegramBot telegramBot)
    {
        return toAjax(telegramBotService.insertTelegramBot(telegramBot));
    }

    /**
     * 修改机器人
     */
    @PreAuthorize("@ss.hasPermi('telegram:bot:edit')")
    @Log(title = "机器人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TelegramBot telegramBot)
    {
        return toAjax(telegramBotService.updateTelegramBot(telegramBot));
    }

    /**
     * 删除机器人
     */
    @PreAuthorize("@ss.hasPermi('telegram:bot:remove')")
    @Log(title = "机器人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(telegramBotService.deleteTelegramBotByIds(ids));
    }
}
