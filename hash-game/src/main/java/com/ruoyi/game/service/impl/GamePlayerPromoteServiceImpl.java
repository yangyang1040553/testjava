package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GamePlayerPromoteMapper;
import com.ruoyi.game.domain.GamePlayerPromote;
import com.ruoyi.game.service.IGamePlayerPromoteService;

/**
 * 推广记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-19
 */
@Service
public class GamePlayerPromoteServiceImpl implements IGamePlayerPromoteService 
{
    @Autowired
    private GamePlayerPromoteMapper gamePlayerPromoteMapper;

    /**
     * 查询推广记录
     * 
     * @param id 推广记录主键
     * @return 推广记录
     */
    @Override
    public GamePlayerPromote selectGamePlayerPromoteById(String id)
    {
        return gamePlayerPromoteMapper.selectGamePlayerPromoteById(id);
    }

    /**
     * 查询推广记录列表
     * 
     * @param gamePlayerPromote 推广记录
     * @return 推广记录
     */
    @Override
    public List<GamePlayerPromote> selectGamePlayerPromoteList(GamePlayerPromote gamePlayerPromote)
    {
        return gamePlayerPromoteMapper.selectGamePlayerPromoteList(gamePlayerPromote);
    }

    /**
     * 新增推广记录
     * 
     * @param gamePlayerPromote 推广记录
     * @return 结果
     */
    @Override
    public int insertGamePlayerPromote(GamePlayerPromote gamePlayerPromote)
    {
        gamePlayerPromote.setCreateTime(DateUtils.getNowDate());
        return gamePlayerPromoteMapper.insertGamePlayerPromote(gamePlayerPromote);
    }

    /**
     * 修改推广记录
     * 
     * @param gamePlayerPromote 推广记录
     * @return 结果
     */
    @Override
    public int updateGamePlayerPromote(GamePlayerPromote gamePlayerPromote)
    {
        gamePlayerPromote.setUpdateTime(DateUtils.getNowDate());
        return gamePlayerPromoteMapper.updateGamePlayerPromote(gamePlayerPromote);
    }

    /**
     * 批量删除推广记录
     * 
     * @param ids 需要删除的推广记录主键
     * @return 结果
     */
    @Override
    public int deleteGamePlayerPromoteByIds(String[] ids)
    {
        return gamePlayerPromoteMapper.deleteGamePlayerPromoteByIds(ids);
    }

    /**
     * 删除推广记录信息
     * 
     * @param id 推广记录主键
     * @return 结果
     */
    @Override
    public int deleteGamePlayerPromoteById(String id)
    {
        return gamePlayerPromoteMapper.deleteGamePlayerPromoteById(id);
    }
}
