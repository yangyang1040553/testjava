package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GameSelectHash;

/**
 * 哈希查询记录Service接口
 * 
 * @author xxk
 * @date 2022-08-22
 */
public interface IGameSelectHashService 
{
    /**
     * 查询哈希查询记录
     * 
     * @param id 哈希查询记录主键
     * @return 哈希查询记录
     */
    public GameSelectHash selectGameSelectHashById(Long id);

    /**
     * 查询哈希查询记录列表
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 哈希查询记录集合
     */
    public List<GameSelectHash> selectGameSelectHashList(GameSelectHash gameSelectHash);

    /**
     * 新增哈希查询记录
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 结果
     */
    public int insertGameSelectHash(GameSelectHash gameSelectHash);

    /**
     * 修改哈希查询记录
     * 
     * @param gameSelectHash 哈希查询记录
     * @return 结果
     */
    public int updateGameSelectHash(GameSelectHash gameSelectHash);

    /**
     * 批量删除哈希查询记录
     * 
     * @param ids 需要删除的哈希查询记录主键集合
     * @return 结果
     */
    public int deleteGameSelectHashByIds(Long[] ids);

    /**
     * 删除哈希查询记录信息
     * 
     * @param id 哈希查询记录主键
     * @return 结果
     */
    public int deleteGameSelectHashById(Long id);
}
