package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户ip注册次数对象 t_user_ip_register
 * 
 * @author xxk
 * @date 2022-05-31
 */
public class UserIpRegister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ip;

    /** ip的位置信息 如-广东省 深圳 */
    @Excel(name = "ip的位置信息 如-广东省 深圳")
    private String ipAddr;

    /** 注册次数 */
    @Excel(name = "注册次数")
    private Long regCount;

    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setIpAddr(String ipAddr) 
    {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr() 
    {
        return ipAddr;
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
            .append("ip", getIp())
            .append("ipAddr", getIpAddr())
            .append("regCount", getRegCount())
            .toString();
    }
}
