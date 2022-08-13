package com.ruoyi.statistical.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏输赢对象 t_game_statistical_win
 * 
 * @author xxk
 * @date 2022-08-13
 */
public class GameStatisticalWin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id-天为单位 */
    @Excel(name = "时间")
    private String id;

    /** 今日usdt押注金额 */
    @Excel(name = "今日usdt押注金额")
    private Long usdtBetAmount;

    /** 今日usdt中奖金额 */
    @Excel(name = "今日usdt中奖金额")
    private Long usdtAwardAmount;

    /** 今日usdt输赢金额 */
    @Excel(name = "今日usdt输赢金额")
    private Long usdtWinAmount;

    /** 今日trx押注金额 */
    @Excel(name = "今日trx押注金额")
    private Long trxBetAmount;

    /** 今日trx中奖金额 */
    @Excel(name = "今日trx中奖金额")
    private Long trxAwardAmount;

    /** 今日trx输赢金额 */
    @Excel(name = "今日trx输赢金额")
    private Long trxWinAmount;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUsdtBetAmount(Long usdtBetAmount) 
    {
        this.usdtBetAmount = usdtBetAmount;
    }

    public Long getUsdtBetAmount() 
    {
        return usdtBetAmount;
    }
    public void setUsdtAwardAmount(Long usdtAwardAmount) 
    {
        this.usdtAwardAmount = usdtAwardAmount;
    }

    public Long getUsdtAwardAmount() 
    {
        return usdtAwardAmount;
    }
    public void setUsdtWinAmount(Long usdtWinAmount) 
    {
        this.usdtWinAmount = usdtWinAmount;
    }

    public Long getUsdtWinAmount() 
    {
        return usdtWinAmount;
    }
    public void setTrxBetAmount(Long trxBetAmount) 
    {
        this.trxBetAmount = trxBetAmount;
    }

    public Long getTrxBetAmount() 
    {
        return trxBetAmount;
    }
    public void setTrxAwardAmount(Long trxAwardAmount) 
    {
        this.trxAwardAmount = trxAwardAmount;
    }

    public Long getTrxAwardAmount() 
    {
        return trxAwardAmount;
    }
    public void setTrxWinAmount(Long trxWinAmount) 
    {
        this.trxWinAmount = trxWinAmount;
    }

    public Long getTrxWinAmount() 
    {
        return trxWinAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usdtBetAmount", getUsdtBetAmount())
            .append("usdtAwardAmount", getUsdtAwardAmount())
            .append("usdtWinAmount", getUsdtWinAmount())
            .append("trxBetAmount", getTrxBetAmount())
            .append("trxAwardAmount", getTrxAwardAmount())
            .append("trxWinAmount", getTrxWinAmount())
            .toString();
    }
}
