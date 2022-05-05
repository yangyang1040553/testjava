package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.TelegramBot;

/**
 * 机器人Mapper接口
 * 
 * @author xxk
 * @date 2022-05-02
 */
public interface TelegramBotMapper 
{
    /**
     * 查询机器人
     * 
     * @param id 机器人主键
     * @return 机器人
     */
    public TelegramBot selectTelegramBotById(Long id);

    /**
     * 查询机器人列表
     * 
     * @param telegramBot 机器人
     * @return 机器人集合
     */
    public List<TelegramBot> selectTelegramBotList(TelegramBot telegramBot);

    /**
     * 新增机器人
     * 
     * @param telegramBot 机器人
     * @return 结果
     */
    public int insertTelegramBot(TelegramBot telegramBot);

    /**
     * 修改机器人
     * 
     * @param telegramBot 机器人
     * @return 结果
     */
    public int updateTelegramBot(TelegramBot telegramBot);

    /**
     * 删除机器人
     * 
     * @param id 机器人主键
     * @return 结果
     */
    public int deleteTelegramBotById(Long id);

    /**
     * 批量删除机器人
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTelegramBotByIds(Long[] ids);
}
