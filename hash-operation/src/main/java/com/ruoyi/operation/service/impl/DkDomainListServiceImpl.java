package com.ruoyi.operation.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.LogUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.DkDomainListMapper;
import com.ruoyi.operation.domain.DkDomainList;
import com.ruoyi.operation.service.IDkDomainListService;

/**
 * 对抗域名列Service业务层处理
 *
 * @author xxk
 * @date 2022-07-27
 */
@Service
public class DkDomainListServiceImpl implements IDkDomainListService {
    @Autowired
    private DkDomainListMapper dkDomainListMapper;

    /**
     * 查询对抗域名列
     *
     * @param id 对抗域名列主键
     * @return 对抗域名列
     */
    @Override
    public DkDomainList selectDkDomainListById(Long id) {
        return dkDomainListMapper.selectDkDomainListById(id);
    }

    /**
     * 查询对抗域名列列表
     *
     * @param dkDomainList 对抗域名列
     * @return 对抗域名列
     */
    @Override
    public List<DkDomainList> selectDkDomainListList(DkDomainList dkDomainList) {

//        /hash/user/getHealthyInfo
        List<DkDomainList> dkDomainLists = dkDomainListMapper.selectDkDomainListList(dkDomainList);
        for (DkDomainList domain : dkDomainLists) {
            try {
                String resp = HttpUtils.sendGet(domain.getDomain() + "/hash/user/getHealthyInfo");
                LogUtils.getBlock("domain===>" + resp);
                if ("".equals(resp)) {
                    domain.setStatus(0);
                    domain.setCheckCount(0);
                } else {
                    domain.setStatus(1);
                    JSONObject jsonObject = JSONObject.parseObject(resp);
                    if (jsonObject.getInteger("code") == 200) {
                        JSONObject data = jsonObject.getJSONObject("data");
                        if (data != null) {
                            Integer checkCount = data.getInteger("checkCount");
                            domain.setCheckCount(checkCount);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                domain.setStatus(0);
                domain.setCheckCount(0);
            }
        }
        return dkDomainLists;
    }

    /**
     * 新增对抗域名列
     *
     * @param dkDomainList 对抗域名列
     * @return 结果
     */
    @Override
    public int insertDkDomainList(DkDomainList dkDomainList) {
        dkDomainList.setCreateTime(DateUtils.getNowDate());
        return dkDomainListMapper.insertDkDomainList(dkDomainList);
    }

    /**
     * 修改对抗域名列
     *
     * @param dkDomainList 对抗域名列
     * @return 结果
     */
    @Override
    public int updateDkDomainList(DkDomainList dkDomainList) {
        return dkDomainListMapper.updateDkDomainList(dkDomainList);
    }

    /**
     * 批量删除对抗域名列
     *
     * @param ids 需要删除的对抗域名列主键
     * @return 结果
     */
    @Override
    public int deleteDkDomainListByIds(Long[] ids) {
        return dkDomainListMapper.deleteDkDomainListByIds(ids);
    }

    /**
     * 删除对抗域名列信息
     *
     * @param id 对抗域名列主键
     * @return 结果
     */
    @Override
    public int deleteDkDomainListById(Long id) {
        return dkDomainListMapper.deleteDkDomainListById(id);
    }
}
