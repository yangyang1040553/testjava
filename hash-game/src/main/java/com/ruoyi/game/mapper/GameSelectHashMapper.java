package com.ruoyi.game.mapper;

import java.util.List;
import com.ruoyi.game.domain.GameSelectHash;

/**
 * 哈希查询记录Mapper接口
 * 
 * @author xxk
 * @date 2022-08-22
 */
public interface GameSelectHashMapper 
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
     * 删除哈希查询记录
     * 
     * @param id 哈希查询记录主键
     * @return 结果
     */
    public int deleteGameSelectHashById(Long id);

    /**
     * 批量删除哈希查询记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameSelectHashByIds(Long[] ids);
}
