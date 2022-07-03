package com.ruoyi.statistical.mapper;

import com.ruoyi.statistical.domain.IndexActive;
import com.ruoyi.statistical.domain.IndexAmount;

/**
 * 留存分析Mapper接口
 *
 * @author xxk
 * @date 2022-05-27
 */
public interface IndexActiveMapper {
    public IndexActive selectCurrActive();
}
