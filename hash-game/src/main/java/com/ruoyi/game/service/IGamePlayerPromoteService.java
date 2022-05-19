package com.ruoyi.game.service;

import java.util.List;
import com.ruoyi.game.domain.GamePlayerPromote;

/**
 * 推广记录Service接口
 * 
 * @author xxk
 * @date 2022-05-19
 */
public interface IGamePlayerPromoteService 
{
    /**
     * 查询推广记录
     * 
     * @param id 推广记录主键
     * @return 推广记录
     */
    public GamePlayerPromote selectGamePlayerPromoteById(String id);

    /**
     * 查询推广记录列表
     * 
     * @param gamePlayerPromote 推广记录
     * @return 推广记录集合
     */
    public List<GamePlayerPromote> selectGamePlayerPromoteList(GamePlayerPromote gamePlayerPromote);

    /**
     * 新增推广记录
     * 
     * @param gamePlayerPromote 推广记录
     * @return 结果
     */
    public int insertGamePlayerPromote(GamePlayerPromote gamePlayerPromote);

    /**
     * 修改推广记录
     * 
     * @param gamePlayerPromote 推广记录
     * @return 结果
     */
    public int updateGamePlayerPromote(GamePlayerPromote gamePlayerPromote);

    /**
     * 批量删除推广记录
     * 
     * @param ids 需要删除的推广记录主键集合
     * @return 结果
     */
    public int deleteGamePlayerPromoteByIds(String[] ids);

    /**
     * 删除推广记录信息
     * 
     * @param id 推广记录主键
     * @return 结果
     */
    public int deleteGamePlayerPromoteById(String id);
}
