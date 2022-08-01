package com.ruoyi.statistical.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.Global;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 statistical_promote
 * 
 * @author xxk
 * @date 2022-05-28
 */
public class StatisticalPromote extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 玩家id */
    private String id;

    /** 一级代理人数 */
    @Excel(name = "一级代理人数")
    private Long level1Person;

    /** 二级代理人数 */
    @Excel(name = "二级代理人数")
    private Long level2Person;

    /** 三级代理人数 */
    @Excel(name = "三级代理人数")
    private Long level3Person;

    /** 手机区号 */
    @Excel(name = "手机区号")
    private String areaCode;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户名 */
    @Excel(name = "用户名")
    private String account;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 代理返佣赔率0.98-0.90 */
    @Excel(name = "代理返佣赔率0.98-0.90")
    private Double promoteOdds;

    /** 分享出去的返佣赔率（可在页面修改） */
    @Excel(name = "分享出去的返佣赔率", readConverterExp = "可=在页面修改")
    private Double sharePromoteOdds;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long sumnumber;


    @Excel(name = "邀请奖励人数")
    private String invite_award_person;
    @Excel(name = "团队usdt总输赢")
    private Double team_usdt_win_amount;
    @Excel(name = "团队trx总输赢")
    private Double team_trx_win_amount;


    @Excel(name = "邀请码")
    private String invitation_code;

    public String getInvitation_code() {
        return invitation_code;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }


    public String getInvite_award_person() {
        return invite_award_person;
    }

    public void setInvite_award_person(String invite_award_person) {
        this.invite_award_person = invite_award_person;
    }

    public Double getTeam_usdt_win_amount() {
        return Global.getWalletAmountToReal(team_usdt_win_amount);
    }

    public void setTeam_usdt_win_amount(Double team_usdt_win_amount) {
        this.team_usdt_win_amount = team_usdt_win_amount;
    }

    public Double getTeam_trx_win_amount() {
        return Global.getWalletAmountToReal(team_trx_win_amount);
    }

    public void setTeam_trx_win_amount(Double team_trx_win_amount) {
        this.team_trx_win_amount = team_trx_win_amount;
    }



    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLevel1Person(Long level1Person) 
    {
        this.level1Person = level1Person;
    }

    public Long getLevel1Person() 
    {
        return level1Person;
    }
    public void setLevel2Person(Long level2Person) 
    {
        this.level2Person = level2Person;
    }

    public Long getLevel2Person() 
    {
        return level2Person;
    }
    public void setLevel3Person(Long level3Person) 
    {
        this.level3Person = level3Person;
    }

    public Long getLevel3Person() 
    {
        return level3Person;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setRegisterTime(Date registerTime) 
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() 
    {
        return registerTime;
    }
    public void setPromoteOdds(Double promoteOdds)
    {
        this.promoteOdds = promoteOdds;
    }

    public Double getPromoteOdds()
    {
        return promoteOdds;
    }
    public void setSharePromoteOdds(Double sharePromoteOdds)
    {
        this.sharePromoteOdds = sharePromoteOdds;
    }

    public Double getSharePromoteOdds()
    {
        return sharePromoteOdds;
    }
    public void setSumnumber(Long sumnumber) 
    {
        this.sumnumber = sumnumber;
    }

    public Long getSumnumber() 
    {
        return sumnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("level1Person", getLevel1Person())
            .append("level2Person", getLevel2Person())
            .append("level3Person", getLevel3Person())
            .append("areaCode", getAreaCode())
            .append("phone", getPhone())
            .append("nickName", getNickName())
            .append("account", getAccount())
            .append("registerTime", getRegisterTime())
            .append("promoteOdds", getPromoteOdds())
            .append("sharePromoteOdds", getSharePromoteOdds())
            .append("sumnumber", getSumnumber())
            .toString();
    }
}
