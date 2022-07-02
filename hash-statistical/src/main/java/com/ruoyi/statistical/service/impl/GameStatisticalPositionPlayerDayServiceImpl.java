package com.ruoyi.statistical.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;

import com.ruoyi.common.constant.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GameStatisticalPositionPlayerDayMapper;
import com.ruoyi.statistical.domain.GameStatisticalPositionPlayerDay;
import com.ruoyi.statistical.service.IGameStatisticalPositionPlayerDayService;

/**
 * 游戏玩家押注位置日统计Service业务层处理
 *
 * @author xxk
 * @date 2022-05-27
 */
@Service
public class GameStatisticalPositionPlayerDayServiceImpl implements IGameStatisticalPositionPlayerDayService {
    @Autowired
    private GameStatisticalPositionPlayerDayMapper gameStatisticalPositionPlayerDayMapper;

    /**
     * 查询游戏玩家押注位置日统计
     *
     * @param id 游戏玩家押注位置日统计主键
     * @return 游戏玩家押注位置日统计
     */
    @Override
    public GameStatisticalPositionPlayerDay selectGameStatisticalPositionPlayerDayById(String id) {
        return gameStatisticalPositionPlayerDayMapper.selectGameStatisticalPositionPlayerDayById(id);
    }

    /**
     * 查询游戏玩家押注位置日统计列表
     *
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 游戏玩家押注位置日统计
     */
    @Override
    public List<GameStatisticalPositionPlayerDay> selectGameStatisticalPositionPlayerDayList(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay) {
        String regex = "";
        if (gameStatisticalPositionPlayerDay.getType() == Global.TYPE_DAY) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalPositionPlayerDay.getType() == Global.TYPE_WEEK) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalPositionPlayerDay.getType() == Global.TYPE_MONTH) {
            //按月查
            regex = "%Y-%m";
        }

        String sql =
                "SELECT DATE_FORMAT(id, '" + regex + "') AS time, \n" +
                        "game_id,\n" +
                        "bet_position,\n" +
                        "user_id,\n" +
                        "sum(trx_bet_amount) AS trx_bet_amount, \n" +
                        "sum(trx_award_amount) AS trx_award_amount, \n" +
                        "sum(usdt_bet_amount) AS usdt_bet_amount, \n" +
                        "sum(usdt_award_amount) AS usdt_award_amount, " +
                        "(usdt_award_amount-usdt_bet_amount) as usdt_win,\n" +
                        "(trx_award_amount-trx_bet_amount) as trx_win"+
                        " FROM t_game_statistical_position_player_day ";

        if (gameStatisticalPositionPlayerDay.getUserId() != null) {
            sql += ("  where user_id="+gameStatisticalPositionPlayerDay.getUserId());
        }

        if (gameStatisticalPositionPlayerDay.getGameId() != null) {
            if (sql.contains("where")){
                sql+=" and game_id="+gameStatisticalPositionPlayerDay.getGameId();
            } else {
                sql+=" where game_id="+gameStatisticalPositionPlayerDay.getGameId();
            }
        }

        sql += " GROUP BY time, game_id ,bet_position,user_id,usdt_win,trx_win";

        gameStatisticalPositionPlayerDay.setSql(sql);

        List<GameStatisticalPositionPlayerDay> gameStatisticalDays = gameStatisticalPositionPlayerDayMapper.selectGameStatisticalPositionPlayerDayList(gameStatisticalPositionPlayerDay);

        // TODO: 2022/5/26   查询参数为周时 获取当前周 对应的 周一 的日期
        if (gameStatisticalPositionPlayerDay.getType() == Global.TYPE_WEEK) {
            for (GameStatisticalPositionPlayerDay statisticalDay : gameStatisticalDays) {
                String time = statisticalDay.getTime();
                statisticalDay.setWeek(time);
                String[] date = time.split("-");

                WeekFields weekFields = WeekFields.ISO;
                LocalDate now = LocalDate.now();
                //输入你想要的年份和周数
                LocalDate localDate = now.withYear(Integer.parseInt(date[0])).with(weekFields.weekOfYear(), Integer.parseInt(date[1]));
                //周一
                LocalDate monday = localDate.with(weekFields.dayOfWeek(), 1L);
                //周日
//                LocalDate localDate2  = localDate.with(weekFields.dayOfWeek(), 7L);
                statisticalDay.setTime(monday.toString());

            }
        }

        return gameStatisticalDays;
    }

    /**
     * 新增游戏玩家押注位置日统计
     *
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 结果
     */
    @Override
    public int insertGameStatisticalPositionPlayerDay(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay) {
        return gameStatisticalPositionPlayerDayMapper.insertGameStatisticalPositionPlayerDay(gameStatisticalPositionPlayerDay);
    }

    /**
     * 修改游戏玩家押注位置日统计
     *
     * @param gameStatisticalPositionPlayerDay 游戏玩家押注位置日统计
     * @return 结果
     */
    @Override
    public int updateGameStatisticalPositionPlayerDay(GameStatisticalPositionPlayerDay gameStatisticalPositionPlayerDay) {
        return gameStatisticalPositionPlayerDayMapper.updateGameStatisticalPositionPlayerDay(gameStatisticalPositionPlayerDay);
    }

    /**
     * 批量删除游戏玩家押注位置日统计
     *
     * @param ids 需要删除的游戏玩家押注位置日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPositionPlayerDayByIds(String[] ids) {
        return gameStatisticalPositionPlayerDayMapper.deleteGameStatisticalPositionPlayerDayByIds(ids);
    }

    /**
     * 删除游戏玩家押注位置日统计信息
     *
     * @param id 游戏玩家押注位置日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPositionPlayerDayById(String id) {
        return gameStatisticalPositionPlayerDayMapper.deleteGameStatisticalPositionPlayerDayById(id);
    }
}
