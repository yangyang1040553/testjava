package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.TelegramBotMapper;
import com.ruoyi.business.domain.TelegramBot;
import com.ruoyi.business.service.ITelegramBotService;

/**
 * 机器人Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-02
 */
@Service
public class TelegramBotServiceImpl implements ITelegramBotService 
{
    @Autowired
    private TelegramBotMapper telegramBotMapper;

    /**
     * 查询机器人
     * 
     * @param id 机器人主键
     * @return 机器人
     */
    @Override
    public TelegramBot selectTelegramBotById(Long id)
    {
        return telegramBotMapper.selectTelegramBotById(id);
    }

    /**
     * 查询机器人列表
     * 
     * @param telegramBot 机器人
     * @return 机器人
     */
    @Override
    public List<TelegramBot> selectTelegramBotList(TelegramBot telegramBot)
    {
        return telegramBotMapper.selectTelegramBotList(telegramBot);
    }

    /**
     * 新增机器人
     * 
     * @param telegramBot 机器人
     * @return 结果
     */
    @Override
    public int insertTelegramBot(TelegramBot telegramBot)
    {
        telegramBot.setCreateTime(DateUtils.getNowDate());
        return telegramBotMapper.insertTelegramBot(telegramBot);
    }

    /**
     * 修改机器人
     * 
     * @param telegramBot 机器人
     * @return 结果
     */
    @Override
    public int updateTelegramBot(TelegramBot telegramBot)
    {
        telegramBot.setUpdateTime(DateUtils.getNowDate());
        return telegramBotMapper.updateTelegramBot(telegramBot);
    }

    /**
     * 批量删除机器人
     * 
     * @param ids 需要删除的机器人主键
     * @return 结果
     */
    @Override
    public int deleteTelegramBotByIds(Long[] ids)
    {
        return telegramBotMapper.deleteTelegramBotByIds(ids);
    }

    /**
     * 删除机器人信息
     * 
     * @param id 机器人主键
     * @return 结果
     */
    @Override
    public int deleteTelegramBotById(Long id)
    {
        return telegramBotMapper.deleteTelegramBotById(id);
    }
}
