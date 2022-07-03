package com.ruoyi.statistical.mapper;

import com.ruoyi.statistical.domain.Index;
import com.ruoyi.statistical.domain.Keep;

import java.util.List;

/**
 * 留存分析Mapper接口
 *
 * @author xxk
 * @date 2022-05-27
 */
public interface IndexMapper {

    public Index selectIndex();
    public Index selectCurrAmountInfo();
    public List<Index> selevtMinAndMax();
}
