package com.ruoyi.hashuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户靓号申请对象 t_user_beautiful_no
 * 
 * @author xxk
 * @date 2022-08-29
 */
public class UserBeautifulNo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 账号 */
    @Excel(name = "账号")
    private String id;

    /** 靓号 */
    @Excel(name = "靓号")
    private String code;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("createTime", getCreateTime())
            .toString();
    }
}
