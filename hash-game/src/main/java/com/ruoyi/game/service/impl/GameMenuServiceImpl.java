package com.ruoyi.game.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameMenuMapper;
import com.ruoyi.game.domain.GameMenu;
import com.ruoyi.game.service.IGameMenuService;

/**
 * 游戏菜单Service业务层处理
 * 
 * @author xxk
 * @date 2022-05-12
 */
@Service
public class GameMenuServiceImpl implements IGameMenuService 
{
    @Autowired
    private GameMenuMapper gameMenuMapper;

    /**
     * 查询游戏菜单
     * 
     * @param id 游戏菜单主键
     * @return 游戏菜单
     */
    @Override
    public GameMenu selectGameMenuById(Long id)
    {
        return gameMenuMapper.selectGameMenuById(id);
    }

    /**
     * 查询游戏菜单列表
     * 
     * @param gameMenu 游戏菜单
     * @return 游戏菜单
     */
    @Override
    public List<GameMenu> selectGameMenuList(GameMenu gameMenu)
    {
        return gameMenuMapper.selectGameMenuList(gameMenu);
    }

    /**
     * 新增游戏菜单
     * 
     * @param gameMenu 游戏菜单
     * @return 结果
     */
    @Override
    public int insertGameMenu(GameMenu gameMenu)
    {
        return gameMenuMapper.insertGameMenu(gameMenu);
    }

    /**
     * 修改游戏菜单
     * 
     * @param gameMenu 游戏菜单
     * @return 结果
     */
    @Override
    public int updateGameMenu(GameMenu gameMenu)
    {
        return gameMenuMapper.updateGameMenu(gameMenu);
    }

    /**
     * 批量删除游戏菜单
     * 
     * @param ids 需要删除的游戏菜单主键
     * @return 结果
     */
    @Override
    public int deleteGameMenuByIds(Long[] ids)
    {
        return gameMenuMapper.deleteGameMenuByIds(ids);
    }

    /**
     * 删除游戏菜单信息
     * 
     * @param id 游戏菜单主键
     * @return 结果
     */
    @Override
    public int deleteGameMenuById(Long id)
    {
        return gameMenuMapper.deleteGameMenuById(id);
    }
}
