package com.ruoyi.statistical.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.hashuser.domain.HashUser;

import java.util.List;
import java.util.Map;

public interface IRedisService {


    public List<HashUser> getOnLineList(HashUser jsonObject);
}
