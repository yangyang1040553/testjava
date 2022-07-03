package com.ruoyi.statistical.mapper;

import com.ruoyi.statistical.domain.Index;
import com.ruoyi.statistical.domain.IndexAmount;

import java.util.List;

/**
 * 留存分析Mapper接口
 *
 * @author xxk
 * @date 2022-05-27
 */
public interface IndexAmountMapper {
    public IndexAmount selectCurrAmountInfo();
}
