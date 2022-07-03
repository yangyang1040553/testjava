package com.ruoyi.statistical.service;

import com.ruoyi.statistical.domain.Index;
import com.ruoyi.statistical.domain.IndexAmount;
import com.ruoyi.statistical.domain.Keep;

import java.util.List;

/**
 * 留存分析Service接口
 *
 * @author xxk
 * @date 2022-05-27
 */
public interface IIndexService {
    public Index selectIndex();

    public IndexAmount selectCurrAmountInfo();
}
