package com.ruoyi.wallet.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 支付类型配置对象 t_pay_type
 * 
 * @author xxk
 * @date 2022-07-29
 */
public class PayType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 支付列别名称 */
    @Excel(name = "支付列别名称")
    private String name;

    /** 列表编号 */
    @Excel(name = "列表编号")
    private String payTypeNo;

    /** 状态, 1:启用, 2:禁用 */
    @Excel(name = "状态, 1:启用, 2:禁用")
    private Long isEnable;

    /** 排序字段 升序 */
    @Excel(name = "排序字段 升序")
    private Long sort;

    /** icon图片地址 */
    @Excel(name = "icon图片地址")
    private String iconUrl;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPayTypeNo(String payTypeNo) 
    {
        this.payTypeNo = payTypeNo;
    }

    public String getPayTypeNo() 
    {
        return payTypeNo;
    }
    public void setIsEnable(Long isEnable) 
    {
        this.isEnable = isEnable;
    }

    public Long getIsEnable() 
    {
        return isEnable;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setIconUrl(String iconUrl) 
    {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl() 
    {
        return iconUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("payTypeNo", getPayTypeNo())
            .append("isEnable", getIsEnable())
            .append("sort", getSort())
            .append("iconUrl", getIconUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
