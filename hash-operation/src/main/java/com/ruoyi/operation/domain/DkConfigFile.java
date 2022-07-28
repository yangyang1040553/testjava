package com.ruoyi.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对抗配置文件对象 dk_config_file
 * 
 * @author xxk
 * @date 2022-07-27
 */
public class DkConfigFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 配置文件 */
    @Excel(name = "配置文件")
    private String json;

    /** 存储桶列表 */
    @Excel(name = "存储桶列表")
    private String upOssList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJson(String json) 
    {
        this.json = json;
    }

    public String getJson() 
    {
        return json;
    }
    public void setUpOssList(String upOssList) 
    {
        this.upOssList = upOssList;
    }

    public String getUpOssList() 
    {
        return upOssList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("json", getJson())
            .append("upOssList", getUpOssList())
            .append("createTime", getCreateTime())
            .toString();
    }
}
