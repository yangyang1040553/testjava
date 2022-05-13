package com.ruoyi.game.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏菜单对象 t_game_menu
 * 
 * @author xxk
 * @date 2022-05-12
 */
public class GameMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一id */
    @Excel(name = "唯一id")
    private Long id;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String menuName;

    /** 权重值 */
    @Excel(name = "权重值")
    private Long weight;

    /** 是否活动菜单 1代表活动页 0代表不是 只能存在一条活动首页，添加的时候要进行判定 */
    @Excel(name = "是否活动菜单 1代表活动页 0代表不是 只能存在一条活动首页，添加的时候要进行判定")
    private String activity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMenuName(String menuName) 
    {
        this.menuName = menuName;
    }

    public String getMenuName() 
    {
        return menuName;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setActivity(String activity) 
    {
        this.activity = activity;
    }

    public String getActivity() 
    {
        return activity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("menuName", getMenuName())
            .append("weight", getWeight())
            .append("activity", getActivity())
            .toString();
    }
}
