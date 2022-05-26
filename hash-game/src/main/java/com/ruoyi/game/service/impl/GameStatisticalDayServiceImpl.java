package com.ruoyi.game.service.impl;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.game.mapper.GameStatisticalDayMapper;
import com.ruoyi.game.domain.GameStatisticalDay;
import com.ruoyi.game.service.IGameStatisticalDayService;

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
        if (gameStatisticalDay.getType() == 1) {
            //按日查
            regex = "%Y-%m-%d";
        } else if (gameStatisticalDay.getType() == 2) {
            //按周查
            regex = "%Y-%u";
        } else if (gameStatisticalDay.getType() == 3) {
            //按月查
            regex = "%Y-%m";
        }


        String sql = "SELECT   DATE_FORMAT(id,'" + regex + "') as time  ,game_id,usdt_bet_amount,usdt_award_amount,trx_bet_amount,trx_award_amount from t_game_statistical_day \n";

        if (gameStatisticalDay.getGameId() != null) {
            sql += ("  where game_id =" + gameStatisticalDay.getGameId());
        }
        sql += " GROUP BY time,game_id,usdt_bet_amount,usdt_award_amount,trx_bet_amount,trx_award_amount";

        gameStatisticalDay.setSql(sql);

        List<GameStatisticalDay> gameStatisticalDays = gameStatisticalDayMapper.selectGameStatisticalDayList(gameStatisticalDay);

        // TODO: 2022/5/26   查询参数为周时 获取当前周 对应的 周一 的日期
        if (gameStatisticalDay.getType() == 2) {
            for (GameStatisticalDay statisticalDay : gameStatisticalDays) {
                String time = statisticalDay.getTime();
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
