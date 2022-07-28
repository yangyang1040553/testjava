package com.ruoyi.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对抗域名列对象 dk_domain_list
 * 
 * @author xxk
 * @date 2022-07-27
 */
public class DkDomainList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 域名类型 */
    @Excel(name = "域名类型")
    private String domainType;

    /** 域名 */
    @Excel(name = "域名")
    private String domain;


    @Excel(name = "健康状态 1 健康  0 不健康")
    private Integer status;


    @Excel(name = "访问次数")
    private Integer checkCount;

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDomainType(String domainType) 
    {
        this.domainType = domainType;
    }

    public String getDomainType() 
    {
        return domainType;
    }
    public void setDomain(String domain) 
    {
        this.domain = domain;
    }

    public String getDomain() 
    {
        return domain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("domainType", getDomainType())
            .append("domain", getDomain())
            .append("createTime", getCreateTime())
            .toString();
    }
}
