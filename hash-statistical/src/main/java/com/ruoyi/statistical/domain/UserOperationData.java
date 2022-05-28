package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 玩家运营数据对象 t_user_operation_data
 * 
 * @author xxk
 * @date 2022-05-28
 */
public class UserOperationData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日期 */
    @Excel(name = "日期")
    private String id;

    /** 活跃人数 */
    @Excel(name = "活跃人数")
    private Long activeCount;

    /** 注册人数 */
    @Excel(name = "注册人数")
    private Long registerCount;

    /** 推广人数 */
    @Excel(name = "推广人数")
    private Long promoteCount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setActiveCount(Long activeCount) 
    {
        this.activeCount = activeCount;
    }

    public Long getActiveCount() 
    {
        return activeCount;
    }
    public void setRegisterCount(Long registerCount) 
    {
        this.registerCount = registerCount;
    }

    public Long getRegisterCount() 
    {
        return registerCount;
    }
    public void setPromoteCount(Long promoteCount) 
    {
        this.promoteCount = promoteCount;
    }

    public Long getPromoteCount() 
    {
        return promoteCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("activeCount", getActiveCount())
            .append("registerCount", getRegisterCount())
            .append("promoteCount", getPromoteCount())
            .toString();
    }
}
