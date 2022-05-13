package com.ruoyi.game.mapper;

import java.util.List;
import com.ruoyi.game.domain.GameMenu;

/**
 * 游戏菜单Mapper接口
 * 
 * @author xxk
 * @date 2022-05-12
 */
public interface GameMenuMapper 
{
    /**
     * 查询游戏菜单
     * 
     * @param id 游戏菜单主键
     * @return 游戏菜单
     */
    public GameMenu selectGameMenuById(Long id);

    /**
     * 查询游戏菜单列表
     * 
     * @param gameMenu 游戏菜单
     * @return 游戏菜单集合
     */
    public List<GameMenu> selectGameMenuList(GameMenu gameMenu);

    /**
     * 新增游戏菜单
     * 
     * @param gameMenu 游戏菜单
     * @return 结果
     */
    public int insertGameMenu(GameMenu gameMenu);

    /**
     * 修改游戏菜单
     * 
     * @param gameMenu 游戏菜单
     * @return 结果
     */
    public int updateGameMenu(GameMenu gameMenu);

    /**
     * 删除游戏菜单
     * 
     * @param id 游戏菜单主键
     * @return 结果
     */
    public int deleteGameMenuById(Long id);

    /**
     * 批量删除游戏菜单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGameMenuByIds(Long[] ids);
}
