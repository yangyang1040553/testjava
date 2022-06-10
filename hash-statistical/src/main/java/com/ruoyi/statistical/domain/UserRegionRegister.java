package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户区域注册次数对象 t_user_region_register
 * 
 * @author xxk
 * @date 2022-06-10
 */
public class UserRegionRegister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 注册次数 */
    @Excel(name = "注册次数")
    private Long regCount;

    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setRegCount(Long regCount) 
    {
        this.regCount = regCount;
    }

    public Long getRegCount() 
    {
        return regCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("region", getRegion())
            .append("regCount", getRegCount())
            .toString();
    }
}
