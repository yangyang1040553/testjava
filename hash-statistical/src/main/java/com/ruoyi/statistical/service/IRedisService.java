package com.ruoyi.statistical.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.hashuser.domain.HashUser;

import java.util.List;
import java.util.Map;

public interface IRedisService {


    public TableDataInfo getOnLineList(HashUser jsonObject);
}
