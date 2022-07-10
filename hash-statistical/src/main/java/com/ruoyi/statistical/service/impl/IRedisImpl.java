package com.ruoyi.statistical.service.impl;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.mapper.HashUserMapper;
import com.ruoyi.hashuser.redis.GameRedis;
import com.ruoyi.statistical.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRedisImpl implements IRedisService {


    @Autowired
    HashUserMapper hashUserMapper;


    @Autowired
    GameRedis gameRedis;


    public static final int LIMIT = 10;

    @Override
    public TableDataInfo getOnLineList(HashUser hashUser) {

        List<String> onlineList = gameRedis.getOnlineList();

        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");

        // TODO: 2022/5/30    redis 为空直接返回
        if (onlineList == null || onlineList.size() == 0) {
            rspData.setRows(new ArrayList<>());
            rspData.setTotal(0);
            return rspData;
        }
        rspData.setTotal(onlineList.size());


        int page = hashUser.getPageNum();
        int pageSize = hashUser.getPageSize();

        int size = onlineList.size();
        String ids = "";

        String sql = " select id,\n" +
                "               user_type,\n" +
                "               area_code,\n" +
                "               phone,\n" +
                "               account,\n" +
                "               password,\n" +
                "               device_code,\n" +
                "               platform,\n" +
                "               nick_name,\n" +
                "               head,\n" +
                "               status,\n" +
                "               online,\n" +
                "               invitation_code,\n" +
                "               father_invitation_code,\n" +
                "               register_time,\n" +
                "               bind_time,\n" +
                "               register_ip,\n" +
                "               login_time,\n" +
                "               login_ip\n" +
                "        from t_user";

        // TODO: 2022/5/30 redis 中数量小于上限值 只查询 redis中的数据 拼接id    in 查询
        if (onlineList.size() < LIMIT) {
            for (String id : onlineList) {
                ids = ids + id + ",";
            }
            return getHashUsers(ids, sql, rspData);
        } else {

            // TODO: 2022/5/30 上限值大于 redis 中的数量时 ，分页 分段 获取ID 拼接  in 查询
            int maxCount = page * pageSize;
            int startIndex = maxCount - pageSize;
            int endIndex = maxCount;
            if (maxCount > onlineList.size()) {
                endIndex = maxCount - (maxCount - size);
                for (int i = startIndex; i < endIndex; i++) {
                    ids = ids + onlineList.get(i) + ",";
                }
            } else {
                for (int i = startIndex; i < endIndex; i++) {
                    ids =ids+ onlineList.get(i) + ",";
                }
            }
            return getHashUsers(ids, sql, rspData);
        }
    }

    private TableDataInfo getHashUsers(String ids, String sql, TableDataInfo tableDataInfo) {

        if (ids.length() > 0) {
            ids = ids.substring(0, ids.length() - 1);
        }
        if (!"".equals(ids)) {
            sql = sql + " where id in ( " + ids + " )";
        } else {
            return tableDataInfo;
        }
        List<HashUser> hashUsers = hashUserMapper.selectHashUserListByIds(sql);
        tableDataInfo.setRows(hashUsers);
        return tableDataInfo;
    }
}