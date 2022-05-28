package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留存分析对象 keep
 *
 * @author xxk
 * @date 2022-05-27
 */
public class Keep extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 注册时间 */
    @Excel(name = "注册时间")
    private String registerTime;

    /** 注册总数 */
    @Excel(name = "注册总数")
    private Long total;

    /** 登录总数 */
    @Excel(name = "登录总数")
    private Long loginCount;

    /** 次日留存 */
    @Excel(name = "次日留存")
    private String one;

    /** 二日留存 */
    @Excel(name = "二日留存")
    private String two;

    /** 三日留存 */
    @Excel(name = "三日留存")
    private String three;

    /** 四日留存 */
    @Excel(name = "四日留存")
    private String four;

    /** 五日留存 */
    @Excel(name = "五日留存")
    private String five;

    /** 六日留存 */
    @Excel(name = "六日留存")
    private String six;

    /** 七日留存 */
    @Excel(name = "七日留存")
    private String seven;

    /** 八日留存 */
    @Excel(name = "八日留存")
    private String eight;

    /** 九日留存 */
    @Excel(name = "九日留存")
    private String nine;

    /** 十日留存 */
    @Excel(name = "十日留存")
    private String ten;

    /** 十一日留存 */
    @Excel(name = "十一日留存")
    private String eleven;

    /** 十二日留存 */
    @Excel(name = "十二日留存")
    private String twelve;

    /** 十三日留存 */
    @Excel(name = "十三日留存")
    private String thirteen;

    /** 十四日留存 */
    @Excel(name = "十四日留存")
    private String fourteen;

    /** 十五日留存 */
    @Excel(name = "十五日留存")
    private String fifteen;

    /** 十六日留存 */
    @Excel(name = "十六日留存")
    private String sixteen;

    /** 十七日留存 */
    @Excel(name = "十七日留存")
    private String seventeen;

    /** 十八日留存 */
    @Excel(name = "十八日留存")
    private String eighteen;

    /** 十九日留存 */
    @Excel(name = "十九日留存")
    private String nineteen;

    /** 二十日留存 */
    @Excel(name = "二十日留存")
    private String twenty;

    /** 二十一日留存 */
    @Excel(name = "二十一日留存")
    private String twentyOne;

    /** 二十二日留存 */
    @Excel(name = "二十二日留存")
    private String twentyTwo;

    /** 二十三日留存 */
    @Excel(name = "二十三日留存")
    private String twentyThree;

    /** 二十四日留存 */
    @Excel(name = "二十四日留存")
    private String twentyFour;

    /** 二十五日留存 */
    @Excel(name = "二十五日留存")
    private String twentyFive;

    /** 二十六日留存 */
    @Excel(name = "二十六日留存")
    private String twentySix;

    /** 二十七日留存 */
    @Excel(name = "二十七日留存")
    private String twentySeven;

    /** 二十八日留存 */
    @Excel(name = "二十八日留存")
    private String twentyEight;

    /** 二十九日留存 */
    @Excel(name = "二十九日留存")
    private String twentyNine;

    /** 三十日留存 */
    @Excel(name = "三十日留存")
    private String thirty;

    private int type;
    private String sql;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setRegisterTime(String registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getRegisterTime()
    {
        return registerTime;
    }
    public void setTotal(Long total)
    {
        this.total = total;
    }

    public Long getTotal()
    {
        return total;
    }
    public void setLoginCount(Long loginCount)
    {
        this.loginCount = loginCount;
    }

    public Long getLoginCount()
    {
        return loginCount;
    }
    public void setOne(String one)
    {
        this.one = one;
    }

    public String getOne()
    {
        return one;
    }
    public void setTwo(String two)
    {
        this.two = two;
    }

    public String getTwo()
    {
        return two;
    }
    public void setThree(String three)
    {
        this.three = three;
    }

    public String getThree()
    {
        return three;
    }
    public void setFour(String four)
    {
        this.four = four;
    }

    public String getFour()
    {
        return four;
    }
    public void setFive(String five)
    {
        this.five = five;
    }

    public String getFive()
    {
        return five;
    }
    public void setSix(String six)
    {
        this.six = six;
    }

    public String getSix()
    {
        return six;
    }
    public void setSeven(String seven)
    {
        this.seven = seven;
    }

    public String getSeven()
    {
        return seven;
    }
    public void setEight(String eight)
    {
        this.eight = eight;
    }

    public String getEight()
    {
        return eight;
    }
    public void setNine(String nine)
    {
        this.nine = nine;
    }

    public String getNine()
    {
        return nine;
    }
    public void setTen(String ten)
    {
        this.ten = ten;
    }

    public String getTen()
    {
        return ten;
    }
    public void setEleven(String eleven)
    {
        this.eleven = eleven;
    }

    public String getEleven()
    {
        return eleven;
    }
    public void setTwelve(String twelve)
    {
        this.twelve = twelve;
    }

    public String getTwelve()
    {
        return twelve;
    }
    public void setThirteen(String thirteen)
    {
        this.thirteen = thirteen;
    }

    public String getThirteen()
    {
        return thirteen;
    }
    public void setFourteen(String fourteen)
    {
        this.fourteen = fourteen;
    }

    public String getFourteen()
    {
        return fourteen;
    }
    public void setFifteen(String fifteen)
    {
        this.fifteen = fifteen;
    }

    public String getFifteen()
    {
        return fifteen;
    }
    public void setSixteen(String sixteen)
    {
        this.sixteen = sixteen;
    }

    public String getSixteen()
    {
        return sixteen;
    }
    public void setSeventeen(String seventeen)
    {
        this.seventeen = seventeen;
    }

    public String getSeventeen()
    {
        return seventeen;
    }
    public void setEighteen(String eighteen)
    {
        this.eighteen = eighteen;
    }

    public String getEighteen()
    {
        return eighteen;
    }
    public void setNineteen(String nineteen)
    {
        this.nineteen = nineteen;
    }

    public String getNineteen()
    {
        return nineteen;
    }
    public void setTwenty(String twenty)
    {
        this.twenty = twenty;
    }

    public String getTwenty()
    {
        return twenty;
    }
    public void setTwentyOne(String twentyOne)
    {
        this.twentyOne = twentyOne;
    }

    public String getTwentyOne()
    {
        return twentyOne;
    }
    public void setTwentyTwo(String twentyTwo)
    {
        this.twentyTwo = twentyTwo;
    }

    public String getTwentyTwo()
    {
        return twentyTwo;
    }
    public void setTwentyThree(String twentyThree)
    {
        this.twentyThree = twentyThree;
    }

    public String getTwentyThree()
    {
        return twentyThree;
    }
    public void setTwentyFour(String twentyFour)
    {
        this.twentyFour = twentyFour;
    }

    public String getTwentyFour()
    {
        return twentyFour;
    }
    public void setTwentyFive(String twentyFive)
    {
        this.twentyFive = twentyFive;
    }

    public String getTwentyFive()
    {
        return twentyFive;
    }
    public void setTwentySix(String twentySix)
    {
        this.twentySix = twentySix;
    }

    public String getTwentySix()
    {
        return twentySix;
    }
    public void setTwentySeven(String twentySeven)
    {
        this.twentySeven = twentySeven;
    }

    public String getTwentySeven()
    {
        return twentySeven;
    }
    public void setTwentyEight(String twentyEight)
    {
        this.twentyEight = twentyEight;
    }

    public String getTwentyEight()
    {
        return twentyEight;
    }
    public void setTwentyNine(String twentyNine)
    {
        this.twentyNine = twentyNine;
    }

    public String getTwentyNine()
    {
        return twentyNine;
    }
    public void setThirty(String thirty)
    {
        this.thirty = thirty;
    }

    public String getThirty()
    {
        return thirty;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("registerTime", getRegisterTime())
                .append("total", getTotal())
                .append("loginCount", getLoginCount())
                .append("one", getOne())
                .append("two", getTwo())
                .append("three", getThree())
                .append("four", getFour())
                .append("five", getFive())
                .append("six", getSix())
                .append("seven", getSeven())
                .append("eight", getEight())
                .append("nine", getNine())
                .append("ten", getTen())
                .append("eleven", getEleven())
                .append("twelve", getTwelve())
                .append("thirteen", getThirteen())
                .append("fourteen", getFourteen())
                .append("fifteen", getFifteen())
                .append("sixteen", getSixteen())
                .append("seventeen", getSeventeen())
                .append("eighteen", getEighteen())
                .append("nineteen", getNineteen())
                .append("twenty", getTwenty())
                .append("twentyOne", getTwentyOne())
                .append("twentyTwo", getTwentyTwo())
                .append("twentyThree", getTwentyThree())
                .append("twentyFour", getTwentyFour())
                .append("twentyFive", getTwentyFive())
                .append("twentySix", getTwentySix())
                .append("twentySeven", getTwentySeven())
                .append("twentyEight", getTwentyEight())
                .append("twentyNine", getTwentyNine())
                .append("thirty", getThirty())
                .toString();
    }
}
