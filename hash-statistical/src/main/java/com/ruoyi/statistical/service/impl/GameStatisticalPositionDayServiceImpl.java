package com.ruoyi.statistical.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;

import com.ruoyi.common.constant.Global;
import com.ruoyi.statistical.domain.GameStatisticalPositionDay;
import com.ruoyi.statistical.mapper.GameStatisticalPositionDayMapper;
import com.ruoyi.statistical.service.IGameStatisticalPositionDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 游戏押注位置日统计Service业务层处理
 *
 * @author xxk
 * @date 2022-05-27
 */
@Service
public class GameStatisticalPositionDayServiceImpl implements IGameStatisticalPositionDayService {
    @Autowired
    private GameStatisticalPositionDayMapper gameStatisticalPositionDayMapper;

    /**
     * 查询游戏押注位置日统计
     *
     * @param id 游戏押注位置日统计主键
     * @return 游戏押注位置日统计
     */
    @Override
    public GameStatisticalPositionDay selectGameStatisticalPositionDayById(String id) {
        return gameStatisticalPositionDayMapper.selectGameStatisticalPositionDayById(id);
    }

    /**
     * 查询游戏押注位置日统计列表
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 游戏押注位置日统计
     */
    @Override
    public List<GameStatisticalPositionDay> selectGameStatisticalPositionDayList(GameStatisticalPositionDay gameStatisticalPositionDay) {
        String regex = "";
        if (gameStatisticalPositionDay.getType() == Global.TYPE_DAY) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalPositionDay.getType() == Global.TYPE_WEEK) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalPositionDay.getType() == Global.TYPE_MONTH) {
            //按月查
            regex = "%Y-%m";
        }

        String sql =
                "SELECT DATE_FORMAT(id, '" + regex + "') AS time, \n" +
                        "game_id,\n" +
                        "bet_position,\n" +
                        "sum(trx_bet_amount) AS trx_bet_amount, \n" +
                        "sum(trx_award_amount) AS trx_award_amount, \n" +
                        "sum(usdt_bet_amount) AS usdt_bet_amount, \n" +
                        "sum(usdt_award_amount) AS usdt_award_amount," +
                        "(usdt_award_amount-usdt_bet_amount) as usdt_win,\n" +
                        "(trx_award_amount-trx_bet_amount) as trx_win"+
                        " FROM t_game_statistical_position_day ";


        if (gameStatisticalPositionDay.getType() == Global.TYPE_DAY) {
            sql += "WHERE id <= CURRENT_DATE";
        }
        if (gameStatisticalPositionDay.getGameId() != null) {
            if (sql.contains("WHERE")) {
                sql += (" and  game_id =" + gameStatisticalPositionDay.getGameId());
            } else {
                sql += (" WHERE  game_id =" + gameStatisticalPositionDay.getGameId());
            }
        }

//        if (gameStatisticalPositionDay.getGameId() != null) {
//            sql += ("  where game_id =" + gameStatisticalPositionDay.getGameId());
//        }
        sql += " GROUP BY time, game_id ,bet_position,usdt_win,trx_win";

        gameStatisticalPositionDay.setSql(sql);

        List<GameStatisticalPositionDay> gameStatisticalDays = gameStatisticalPositionDayMapper.selectGameStatisticalPositionDayList(gameStatisticalPositionDay);

        // TODO: 2022/5/26   查询参数为周时 获取当前周 对应的 周一 的日期
        if (gameStatisticalPositionDay.getType() == 2) {
            for (GameStatisticalPositionDay statisticalDay : gameStatisticalDays) {
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
     * 新增游戏押注位置日统计
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 结果
     */
    @Override
    public int insertGameStatisticalPositionDay(GameStatisticalPositionDay gameStatisticalPositionDay) {
        return gameStatisticalPositionDayMapper.insertGameStatisticalPositionDay(gameStatisticalPositionDay);
    }

    /**
     * 修改游戏押注位置日统计
     *
     * @param gameStatisticalPositionDay 游戏押注位置日统计
     * @return 结果
     */
    @Override
    public int updateGameStatisticalPositionDay(GameStatisticalPositionDay gameStatisticalPositionDay) {
        return gameStatisticalPositionDayMapper.updateGameStatisticalPositionDay(gameStatisticalPositionDay);
    }

    /**
     * 批量删除游戏押注位置日统计
     *
     * @param ids 需要删除的游戏押注位置日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPositionDayByIds(String[] ids) {
        return gameStatisticalPositionDayMapper.deleteGameStatisticalPositionDayByIds(ids);
    }

    /**
     * 删除游戏押注位置日统计信息
     *
     * @param id 游戏押注位置日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPositionDayById(String id) {
        return gameStatisticalPositionDayMapper.deleteGameStatisticalPositionDayById(id);
    }
}
