package com.ruoyi.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运营活动对象 t_game_operation_activity
 *
 * @author xxk
 * @date 2022-06-26
 */
public class GameOperationActivity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 1:周累计 2救援金 3每日活动 4连赢在赢 5新人包赢
     */
    @Excel(name = "1:周累计 2救援金 3每日活动 4连赢在赢 5新人包赢")
    private String id;

    /**
     * 配置数据
     */
    @Excel(name = "配置数据")
    private String json;

    /**
     * 是否开启
     */
    @Excel(name = "是否开启")
    private Long isOpen;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setIsOpen(Long isOpen) {
        this.isOpen = isOpen;
    }

    public Long getIsOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("json", getJson())
                .append("isOpen", getIsOpen())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
