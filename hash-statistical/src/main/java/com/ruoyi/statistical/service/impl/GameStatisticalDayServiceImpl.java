package com.ruoyi.statistical.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;

import com.ruoyi.common.constant.Global;
import com.ruoyi.statistical.domain.GameStatisticalDay;
import com.ruoyi.statistical.mapper.GameStatisticalDayMapper;
import com.ruoyi.statistical.service.IGameStatisticalDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 游戏日统计Service业务层处理
 *
 * @author xxk
 * @date 2022-05-26
 */
@Service
public class GameStatisticalDayServiceImpl implements IGameStatisticalDayService {
    @Autowired
    private GameStatisticalDayMapper gameStatisticalDayMapper;

    /**
     * 查询游戏日统计
     *
     * @param id 游戏日统计主键
     * @return 游戏日统计
     */
    @Override
    public GameStatisticalDay selectGameStatisticalDayById(String id) {
        return gameStatisticalDayMapper.selectGameStatisticalDayById(id);
    }

    /**
     * 查询游戏日统计列表
     *
     * @param gameStatisticalDay 游戏日统计
     * @return 游戏日统计
     */
    @Override
    public List<GameStatisticalDay> selectGameStatisticalDayList(GameStatisticalDay gameStatisticalDay) {

        String regex = "";
        if (gameStatisticalDay.getType() == Global.TYPE_DAY) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalDay.getType() == Global.TYPE_WEEK) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalDay.getType() == Global.TYPE_MONTH) {
            //按月查
            regex = "%Y-%m";
        }


        String sql = "SELECT   DATE_FORMAT(id,'" + regex + "') as time  ," +
                "game_id,sum(trx_bet_amount)as trx_bet_amount," +
                "sum(trx_award_amount)as trx_award_amount," +
                "sum(usdt_bet_amount)as usdt_bet_amount\n" +
                ",sum(usdt_award_amount)as usdt_award_amount from t_game_statistical_day ";

        if (gameStatisticalDay.getType() == Global.TYPE_DAY) {
            sql = "SELECT\n" +
                    "\tDATE_FORMAT( id, '%Y-%m-%d' ) AS time,\n" +
                    "\tgame_id,\n" +
                    "  trx_bet_amount,\n" +
                    "\ttrx_award_amount,\n" +
                    "\tusdt_bet_amount,   \n" +
                    "\tusdt_award_amount \n" +
                    "FROM\n" +
                    "\tt_game_statistical_day \n" +
                    "WHERE\n" +
                    "\tid <= CURRENT_DATE \n";
        }

        if (gameStatisticalDay.getType() == Global.TYPE_WEEK) {
            sql ="SELECT   DATE_FORMAT(id,'" + regex + "') as time  ," +
                    "game_id,sum(trx_bet_amount)as trx_bet_amount," +
                    "sum(trx_award_amount)as trx_award_amount," +
                    "sum(usdt_bet_amount)as usdt_bet_amount\n" +
                    ",sum(usdt_award_amount)as usdt_award_amount from t_game_statistical_day  WHERE  id <= CURRENT_DATE ";
        }

        if (gameStatisticalDay.getGameId() != null) {
            if (sql.contains("WHERE")) {
                sql += (" and  game_id =" + gameStatisticalDay.getGameId());
            } else {
                sql += (" WHERE  game_id =" + gameStatisticalDay.getGameId());
            }
        }

        if (gameStatisticalDay.getType() != Global.TYPE_DAY) {
            sql += " GROUP BY time,game_id";
        }
        sql += " ORDER BY time DESC";
        gameStatisticalDay.setSql(sql);

        List<GameStatisticalDay> gameStatisticalDays = gameStatisticalDayMapper.selectGameStatisticalDayList(gameStatisticalDay);

        // TODO: 2022/5/26   查询参数为周时 获取当前周 对应的 周一 的日期
        if (gameStatisticalDay.getType() == Global.TYPE_WEEK) {
            for (GameStatisticalDay statisticalDay : gameStatisticalDays) {
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

    @Override
    public List<GameStatisticalDay> selectGameChildrenList(GameStatisticalDay gameStatisticalDay) {


        String regex = "";
        if (gameStatisticalDay.getType() == Global.TYPE_DAY) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalDay.getType() == Global.TYPE_WEEK) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalDay.getType() == Global.TYPE_MONTH) {
            //按月查
            regex = "%Y-%m";
        }


        String sql = "SELECT  DATE_FORMAT(c.id,'" + regex + "') as time ,c.game_id, " +
                " sum(c.trx_bet_amount)as trx_bet_amount," +
                "sum(c.trx_award_amount)as trx_award_amount," +
                "sum(c.usdt_bet_amount)as usdt_bet_amount\n" +
                ",sum(c.usdt_award_amount)as usdt_award_amount " +
                ",c.bet_position from (SELECT  a.id, a.game_id, a.usdt_bet_amount,a.usdt_award_amount,a.trx_bet_amount,a.trx_award_amount ,a.bet_position from t_game_statistical_position_day  a\n" +
                "LEFT  JOIN  t_game_statistical_day b on   a.id=b.id and a.game_id=b.game_id ) c ";

//        if (gameStatisticalDay.getGameId() != null && gameStatisticalDay.getTime() != null) {
//            sql += (" where c.game_id= " + gameStatisticalDay.getGameId() + " and DATE_FORMAT(c.id,'" + regex + "')=DATE_FORMAT('" + gameStatisticalDay.getTime() + "','" + regex + "')");
//        }

        if (gameStatisticalDay.getType() == Global.TYPE_DAY) {
            //按日查
            if (gameStatisticalDay.getGameId() != null && gameStatisticalDay.getTime() != null) {
                sql += (" where c.game_id= " + gameStatisticalDay.getGameId() + " and DATE_FORMAT(c.id,'" + regex + "')=DATE_FORMAT('" + gameStatisticalDay.getTime() + "','" + regex + "')");
            }
        } else if (gameStatisticalDay.getType() == Global.TYPE_MONTH) {
            //按月查
            if (gameStatisticalDay.getGameId() != null && gameStatisticalDay.getTime() != null) {
                sql += (" where c.game_id= " + gameStatisticalDay.getGameId() + " and DATE_FORMAT(c.id,'" + regex + "')='" + gameStatisticalDay.getTime() + "'");
            }
        } else if (gameStatisticalDay.getType() == Global.TYPE_WEEK) {
            //按周查
            if (gameStatisticalDay.getGameId() != null && gameStatisticalDay.getTime() != null) {

                String[] date = gameStatisticalDay.getWeek().split("-");

                WeekFields weekFields = WeekFields.ISO;
                LocalDate now = LocalDate.now();
                //输入你想要的年份和周数
                LocalDate localDate = now.withYear(Integer.parseInt(date[0])).with(weekFields.weekOfYear(), Integer.parseInt(date[1]));
                //周一
                LocalDate monday = localDate.with(weekFields.dayOfWeek(), 1L);
                //周日
                LocalDate sunday = localDate.with(weekFields.dayOfWeek(), 7L);
                sql += (" where c.game_id= " + gameStatisticalDay.getGameId() + " and c.id BETWEEN '" + monday.toString() + "'  and '" + sunday.toString() + "'");
            }
        }

        sql += " group by time ,c.game_id,c.bet_position";


        gameStatisticalDay.setSql(sql);

        List<GameStatisticalDay> gameStatisticalDays = gameStatisticalDayMapper.selectGameStatisticalDayList(gameStatisticalDay);

        return gameStatisticalDays;
    }

    /**
     * 新增游戏日统计
     *
     * @param gameStatisticalDay 游戏日统计
     * @return 结果
     */
    @Override
    public int insertGameStatisticalDay(GameStatisticalDay gameStatisticalDay) {
        return gameStatisticalDayMapper.insertGameStatisticalDay(gameStatisticalDay);
    }

    /**
     * 修改游戏日统计
     *
     * @param gameStatisticalDay 游戏日统计
     * @return 结果
     */
    @Override
    public int updateGameStatisticalDay(GameStatisticalDay gameStatisticalDay) {
        return gameStatisticalDayMapper.updateGameStatisticalDay(gameStatisticalDay);
    }

    /**
     * 批量删除游戏日统计
     *
     * @param ids 需要删除的游戏日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalDayByIds(String[] ids) {
        return gameStatisticalDayMapper.deleteGameStatisticalDayByIds(ids);
    }

    /**
     * 删除游戏日统计信息
     *
     * @param id 游戏日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalDayById(String id) {
        return gameStatisticalDayMapper.deleteGameStatisticalDayById(id);
    }
}
