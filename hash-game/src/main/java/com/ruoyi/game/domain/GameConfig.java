package com.ruoyi.game.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游戏配置
 * 对象 t_game_config
 *
 * @author xxk
 * @date 2022-05-08
 */
public class GameConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏id -1牛牛 2位数2 3单双 4大小 5龙虎 6幸运嘻哈 7幸运数字
     */
    private String id;

    /**
     * 游戏id
     */
    @Excel(name = "游戏id")
    private Long gameId;

    /**
     * 游戏名称
     */
    @Excel(name = "游戏名称")
    private String gameName;

    /**
     * 游戏场次 0初级场 1中级场 2高级场
     */
    @Excel(name = "游戏场次 0初级场 1中级场 2高级场")
    private Long gameSession;

    /**
     * 下注规则
     */
    @Excel(name = "下注规则")
    private String betRule;

    /**
     * 倍率配置（单个）
     */
    @Excel(name = "倍率配置", readConverterExp = "单=个")
    private Double odds;

    /**
     * 税收
     */
    @Excel(name = "税收")
    private Double tax;

    /**
     * 是否开启 0否 1开启
     */
    @Excel(name = "是否开启 0否 1开启")
    private Long open;

    /**
     * 是否活动场 0否 1是
     */
    @Excel(name = "是否活动场 0否 1是")
    private Long isActivity;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:MM:ss")
    private Date finishTime;


    private List<BetRule> betRuleList;

    private String sort;
    private int usdtMin;
    private int usdtMax;
    private int trxMax;
    private int trxMin;

    public List<BetRule> getBetRuleList() {
        return betRuleList;
    }

    public void setBetRuleList(List<BetRule> betRuleList) {
        this.betRuleList = betRuleList;
    }

    public int getUsdtMin() {
        return usdtMin;
    }

    public void setUsdtMin(int usdtMin) {
        this.usdtMin = usdtMin;
    }

    public int getUsdtMax() {
        return usdtMax;
    }

    public void setUsdtMax(int usdtMax) {
        this.usdtMax = usdtMax;
    }

    public int getTrxMax() {
        return trxMax;
    }

    public void setTrxMax(int trxMax) {
        this.trxMax = trxMax;
    }

    public int getTrxMin() {
        return trxMin;
    }

    public void setTrxMin(int trxMin) {
        this.trxMin = trxMin;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameSession(Long gameSession) {
        this.gameSession = gameSession;
    }

    public Long getGameSession() {
        return gameSession;
    }

    public void setBetRule(String betRule) {
        this.betRule = betRule;
    }

    public String getBetRule() {

        if (betRule != null) {
            JSONObject jsonObject = JSONObject.parseObject(betRule);
            JSONObject usdt = (JSONObject) jsonObject.getJSONObject("USDT");
            JSONObject trx = (JSONObject) jsonObject.getJSONObject("TRX");

//            setUsdtMax(usdt.getIntValue("betMaxLimit"));
//            setUsdtMin(usdt.getIntValue("betMinLimit"));

//            setTrxMax(trx.getIntValue("betMaxLimit"));
//            setTrxMin(trx.getIntValue("betMinLimit"));

            BetRule usdtRule = JSONObject.toJavaObject(usdt, BetRule.class);
            usdtRule.setName("USDT");
            usdtRule.setTitle("USDT规则");

            BetRule trxtRule = JSONObject.toJavaObject(trx, BetRule.class);
            trxtRule.setName("TRX");
            trxtRule.setTitle("TRX规则");

            betRuleList = new ArrayList<>();
            betRuleList.add(usdtRule);
            betRuleList.add(trxtRule);
        }

        return betRule;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public Double getOdds() {
        return odds;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public void setOpen(Long open) {
        this.open = open;
    }

    public Long getOpen() {
        return open;
    }

    public void setisActivity(Long isActivity) {
        this.isActivity = isActivity;
    }

    public Long getisActivity() {
        return isActivity;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("gameId", getGameId())
                .append("gameName", getGameName())
                .append("gameSession", getGameSession())
                .append("betRule", getBetRule())
                .append("odds", getOdds())
                .append("tax", getTax())
                .append("open", getOpen())
                .append("isActivity", getisActivity())
                .append("finishTime", getFinishTime())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }


    private static class BetRule {
        private String name;
        private String title;
        private int betMinLimit;
        private int betMaxLimit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBetMinLimit() {
            return betMinLimit;
        }

        public void setBetMinLimit(int betMinLimit) {
            this.betMinLimit = betMinLimit;
        }

        public int getBetMaxLimit() {
            return betMaxLimit;
        }

        public void setBetMaxLimit(int betMaxLimit) {
            this.betMaxLimit = betMaxLimit;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
