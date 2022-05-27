package com.ruoyi.statistical.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.statistical.mapper.GameStatisticalPlayerDayMapper;
import com.ruoyi.statistical.domain.GameStatisticalPlayerDay;
import com.ruoyi.statistical.service.IGameStatisticalPlayerDayService;

/**
 * 游戏玩家日统计Service业务层处理
 *
 * @author xxk
 * @date 2022-05-27
 */
@Service
public class GameStatisticalPlayerDayServiceImpl implements IGameStatisticalPlayerDayService {
    @Autowired
    private GameStatisticalPlayerDayMapper gameStatisticalPlayerDayMapper;

    /**
     * 查询游戏玩家日统计
     *
     * @param id 游戏玩家日统计主键
     * @return 游戏玩家日统计
     */
    @Override
    public GameStatisticalPlayerDay selectGameStatisticalPlayerDayById(String id) {
        return gameStatisticalPlayerDayMapper.selectGameStatisticalPlayerDayById(id);
    }

    /**
     * 查询游戏玩家日统计列表
     *
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 游戏玩家日统计
     */
    @Override
    public List<GameStatisticalPlayerDay> selectGameStatisticalPlayerDayList(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        String regex = "";
        if (gameStatisticalPlayerDay.getType() == 1) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalPlayerDay.getType() == 2) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalPlayerDay.getType() == 3) {
            //按月查
            regex = "%Y-%m";
        }

        String sql =
                "SELECT DATE_FORMAT(id, '" + regex + "') AS time, \n" +
                        "game_id,\n" +
                        "user_id,\n" +
                        "sum(trx_bet_amount) AS trx_bet_amount, \n" +
                        "sum(trx_award_amount) AS trx_award_amount, \n" +
                        "sum(usdt_bet_amount) AS usdt_bet_amount, \n" +
                        "sum(usdt_award_amount) AS usdt_award_amount FROM t_game_statistical_player_day ";

        if (gameStatisticalPlayerDay.getUserId() != null && !"".equals(gameStatisticalPlayerDay.getUserId())) {
            sql += ("  where user_id =" + gameStatisticalPlayerDay.getUserId());
        }
        sql += " GROUP BY time, game_id ,user_id";

        gameStatisticalPlayerDay.setSql(sql);

        List<GameStatisticalPlayerDay> gameStatisticalDays = gameStatisticalPlayerDayMapper.selectGameStatisticalPlayerDayList(gameStatisticalPlayerDay);

        // TODO: 2022/5/26   查询参数为周时 获取当前周 对应的 周一 的日期
        if (gameStatisticalPlayerDay.getType() == 2) {
            for (GameStatisticalPlayerDay statisticalDay : gameStatisticalDays) {
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
    public List<GameStatisticalPlayerDay> selectDetailChildrenList(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        String regex = "";
        if (gameStatisticalPlayerDay.getType() == 1) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalPlayerDay.getType() == 2) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalPlayerDay.getType() == 3) {
            //按月查
            regex = "%Y-%m";
        }


        String sql = "SELECT\n" +
                "\tDATE_FORMAT( c.id, '" + regex + "' ) AS time,\n" +
                "\tc.game_id,\n" +
                "\tsum( c.trx_bet_amount ) AS trx_bet_amount,\n" +
                "\tsum( c.trx_award_amount ) AS trx_award_amount,\n" +
                "\tsum( c.usdt_bet_amount ) AS usdt_bet_amount,\n" +
                "\tsum( c.usdt_award_amount ) AS usdt_award_amount,\n" +
                "\tc.bet_position,\n" +
                "\tc.user_id \n" +
                "FROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\t\ta.id,\n" +
                "\t\ta.game_id,\n" +
                "\t\ta.usdt_bet_amount,\n" +
                "\t\ta.usdt_award_amount,\n" +
                "\t\ta.trx_bet_amount,\n" +
                "\t\ta.trx_award_amount,\n" +
                "\t\ta.bet_position,\n" +
                "\t\ta.user_id \n" +
                "\tFROM\n" +
                "\t\tt_game_statistical_position_player_day a\n" +
                "\t\tLEFT JOIN t_game_statistical_player_day b ON a.id = b.id \n" +
                "\t\tAND a.game_id = b.game_id \n" +
                "\t\tAND a.user_id = b.user_id \n" +
                "\t) c \n";

//        if (gameStatisticalDay.getGameId() != null && gameStatisticalDay.getTime() != null) {
//            sql += (" where c.game_id= " + gameStatisticalDay.getGameId() + " and DATE_FORMAT(c.id,'" + regex + "')=DATE_FORMAT('" + gameStatisticalDay.getTime() + "','" + regex + "')");
//        }

        if (gameStatisticalPlayerDay.getType() == 1) {
            //按日查
            sql += (" where c.game_id= " + gameStatisticalPlayerDay.getGameId() +
                    " and DATE_FORMAT(c.id,'" + regex + "')=DATE_FORMAT('" + gameStatisticalPlayerDay.getTime() + "','" + regex + "')" +
                    " and c.user_id=" + gameStatisticalPlayerDay.getUserId());
        } else if (gameStatisticalPlayerDay.getType() == 3) {
            //按月查
            sql += (" where  c.game_id=" + gameStatisticalPlayerDay.getGameId() +
                    " and DATE_FORMAT(c.id,'" + regex + "')='" + gameStatisticalPlayerDay.getTime() + "'" +
                    " and c.user_id=" + gameStatisticalPlayerDay.getUserId());
        } else if (gameStatisticalPlayerDay.getType() == 2) {
            //按月查

            String[] date = gameStatisticalPlayerDay.getWeek().split("-");

            WeekFields weekFields = WeekFields.ISO;
            LocalDate now = LocalDate.now();
            //输入你想要的年份和周数
            LocalDate localDate = now.withYear(Integer.parseInt(date[0])).with(weekFields.weekOfYear(), Integer.parseInt(date[1]));
            //周一
            LocalDate monday = localDate.with(weekFields.dayOfWeek(), 1L);
            //周日
            LocalDate sunday = localDate.with(weekFields.dayOfWeek(), 7L);
            sql += (" where   c.id BETWEEN '" + monday.toString() + "'  and '" + sunday.toString() + "'" +
                    " and c.game_id= " + gameStatisticalPlayerDay.getGameId() +
                    " and c.user_id=" + gameStatisticalPlayerDay.getUserId());
        }

        sql += " group by time,\n" +
                "\tc.game_id,\n" +
                "\tc.bet_position,\n" +
                "\tc.user_id";


        gameStatisticalPlayerDay.setSql(sql);

        List<GameStatisticalPlayerDay> gameStatisticalDays = gameStatisticalPlayerDayMapper.selectGameStatisticalPlayerDayList(gameStatisticalPlayerDay);

        return gameStatisticalDays;
    }

    /**
     * 新增游戏玩家日统计
     *
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 结果
     */
    @Override
    public int insertGameStatisticalPlayerDay(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        return gameStatisticalPlayerDayMapper.insertGameStatisticalPlayerDay(gameStatisticalPlayerDay);
    }

    /**
     * 修改游戏玩家日统计
     *
     * @param gameStatisticalPlayerDay 游戏玩家日统计
     * @return 结果
     */
    @Override
    public int updateGameStatisticalPlayerDay(GameStatisticalPlayerDay gameStatisticalPlayerDay) {
        return gameStatisticalPlayerDayMapper.updateGameStatisticalPlayerDay(gameStatisticalPlayerDay);
    }

    /**
     * 批量删除游戏玩家日统计
     *
     * @param ids 需要删除的游戏玩家日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPlayerDayByIds(String[] ids) {
        return gameStatisticalPlayerDayMapper.deleteGameStatisticalPlayerDayByIds(ids);
    }

    /**
     * 删除游戏玩家日统计信息
     *
     * @param id 游戏玩家日统计主键
     * @return 结果
     */
    @Override
    public int deleteGameStatisticalPlayerDayById(String id) {
        return gameStatisticalPlayerDayMapper.deleteGameStatisticalPlayerDayById(id);
    }
}
