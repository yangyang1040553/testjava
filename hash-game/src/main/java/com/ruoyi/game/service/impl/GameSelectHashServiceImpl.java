package com.ruoyi.game.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameSelectHashMapper;
import com.ruoyi.game.domain.GameSelectHash;
import com.ruoyi.game.service.IGameSelectHashService;

/**
 * 哈希查询记录Service业务层处理
 * 
 * @author xxk
 * @date 2022-08-22
 */
@Service
public class GameSelectHashServiceImpl implements IGameSelectHashService 
{
    @Autowired
    private GameSelectHashMapper gameSelectHashMapper;

    /**
     * 查询哈希查询记录
     * 
     * @param id 哈希查询记录主键
     * @return 哈希查询记录
     */
    @Override
    public GameSelectHash selectGameSelectHashById(Long id)
    {
        return gameSelectHashMapper.selectGameSelectHashById(id);
    }

    /**
     * 查询哈希查询记录列表
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 哈希查询记录
     */
    @Override
    public List<GameSelectHash> selectGameSelectHashList(GameSelectHash gameSelectHash)
    {
        return gameSelectHashMapper.selectGameSelectHashList(gameSelectHash);
    }

    /**
     * 新增哈希查询记录
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 结果
     */
    @Override
    public int insertGameSelectHash(GameSelectHash gameSelectHash)
    {
        gameSelectHash.setCreateTime(DateUtils.getNowDate());
        return gameSelectHashMapper.insertGameSelectHash(gameSelectHash);
    }

    /**
     * 修改哈希查询记录
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 结果
     */
    @Override
    public int updateGameSelectHash(GameSelectHash gameSelectHash)
    {
        return gameSelectHashMapper.updateGameSelectHash(gameSelectHash);
    }

    /**
     * 批量删除哈希查询记录
     * 
     * @param ids 需要删除的哈希查询记录主键
     * @return 结果
     */
    @Override
    public int deleteGameSelectHashByIds(Long[] ids)
    {
        return gameSelectHashMapper.deleteGameSelectHashByIds(ids);
    }

    /**
     * 删除哈希查询记录信息
     * 
     * @param id 哈希查询记录主键
     * @return 结果
     */
    @Override
    public int deleteGameSelectHashById(Long id)
    {
        return gameSelectHashMapper.deleteGameSelectHashById(id);
    }
}
