package com.xiyan.zhiwenhui.model.dto.statistic;

import lombok.Data;

/**
 * App 用户提交答案结果数统计
 */
@Data
public class AppAnswerResultCountDTO {
    // 结果名称
    private String resultName;
    // 对应个数
    private String resultCount;
}