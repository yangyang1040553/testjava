package com.ruoyi.statistical.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.hashuser.domain.HashUser;
import com.ruoyi.hashuser.mapper.HashUserMapper;
import com.ruoyi.statistical.redis.GameRedis;
import com.ruoyi.statistical.service.IRedisService;
import com.ruoyi.statistical.service.IStatisticalPromoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IRedisImpl implements IRedisService {


    @Autowired
    HashUserMapper hashUserMapper;


    @Autowired
    GameRedis gameRedis;


    public static final int LIMIT = 10;

    @Override
    public List<HashUser> getOnLineList(HashUser hashUser) {


        List<String> onlineList = gameRedis.getOnlineList();

        if (onlineList == null || onlineList.size() == 0) {
            return new ArrayList<HashUser>();
        }

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
        if (onlineList.size() < LIMIT) {
            for (String id : onlineList) {
                ids = ids + id + ",";
            }
            return getHashUsers(ids, sql);
        } else {

            int maxCount = page * pageSize;
            int startIndex = maxCount - pageSize;
            int endIndex = maxCount;
            if (maxCount > onlineList.size()) {
                endIndex = maxCount - (maxCount - size);
                for (int i = startIndex; i < endIndex; i++) {
                    ids = onlineList.get(i) + ",";
                }
            } else {
                for (int i = startIndex; i < endIndex; i++) {
                    ids = onlineList.get(i) + ",";
                }
            }
            return getHashUsers(ids, sql);
        }
    }

    private List<HashUser> getHashUsers(String ids, String sql) {
        if (ids.length() > 0) {
            ids = ids.substring(0, ids.length() - 1);
        }
        if (!"".equals(ids)) {
            sql = sql + " where id in ( " + ids + " )";
        }else {
            return new ArrayList<HashUser>();
        }
        return hashUserMapper.selectHashUserListByIds(sql);
    }
}