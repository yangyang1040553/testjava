package com.ruoyi.statistical.service.impl;

import com.ruoyi.common.constant.Global;
import com.ruoyi.statistical.domain.Index;
import com.ruoyi.statistical.domain.IndexActive;
import com.ruoyi.statistical.domain.IndexAmount;
import com.ruoyi.statistical.domain.Keep;
import com.ruoyi.statistical.mapper.IndexActiveMapper;
import com.ruoyi.statistical.mapper.IndexAmountMapper;
import com.ruoyi.statistical.mapper.IndexMapper;
import com.ruoyi.statistical.mapper.KeepMapper;
import com.ruoyi.statistical.service.IIndexService;
import com.ruoyi.statistical.service.IKeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留存分析Service业务层处理
 *
 * @author xxk
 * @date 2022-05-27
 */
@Service
public class IndexServiceImpl implements IIndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Autowired
    private IndexAmountMapper indexAmountMapper;

    @Autowired
    private IndexActiveMapper indexActiveMapper;

    @Override
    public Index selectIndex() {
        List<Index> indices = indexMapper.selevtMinAndMax();
        double minTrx = 0;
        double minUsdt = 0;
        String minTrxGameId = "";
        String minUsdtGameId = "";

        double maxTrx = 0;
        double maxUsdt = 0;
        String maxTrxGameId = "";
        String maxUsdtGameId = "";

        for (Index index : indices) {
            if (index.getTrx_win_amount() != null && index.getTrx_win_amount() < minTrx) {
                minTrx = index.getTrx_win_amount();
                minTrxGameId = index.getGame_id();
            }
            if (index.getUsdt_win_amount() != null && index.getUsdt_win_amount() < minUsdt) {
                minUsdt = index.getTrx_win_amount();
                minUsdtGameId = index.getGame_id();
            }

            if (index.getTrx_win_amount() != null && index.getTrx_win_amount() > maxTrx) {
                maxTrx = index.getTrx_win_amount();
                maxTrxGameId = index.getGame_id();
            }
            if (index.getUsdt_win_amount() != null && index.getUsdt_win_amount() > maxUsdt) {
                maxUsdt = index.getTrx_win_amount();
                maxUsdtGameId = index.getGame_id();
            }
        }

        Index index = indexMapper.selectIndex();

        index.setMinTrx(minTrx);
        index.setMinTrxGameId(minTrxGameId);

        index.setMaxTrx(maxTrx);
        index.setMaxTrxGameId(maxTrxGameId);


        index.setMinUsdt(minUsdt);
        index.setMinUsdtGameId(minUsdtGameId);

        index.setMaxUsdt(maxUsdt);
        index.setMaxUsdtGameId(maxUsdtGameId);

        return index;
    }

    @Override
    public IndexAmount selectCurrAmountInfo() {
        return indexAmountMapper.selectCurrAmountInfo();
    }

    @Override
    public List<IndexActive> selectCurrActive() {
        return indexActiveMapper.selectCurrActive();
    }

    @Override
    public IndexActive selectCurrActiveAmount() {
        return indexActiveMapper.selectCurrActiveAmountInfo();
    }
}
