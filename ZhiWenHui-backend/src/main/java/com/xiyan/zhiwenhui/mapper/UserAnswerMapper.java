package com.xiyan.zhiwenhui.mapper;

import com.xiyan.zhiwenhui.model.dto.statistic.AppAnswerCountDTO;
import com.xiyan.zhiwenhui.model.dto.statistic.AppAnswerResultCountDTO;
import com.xiyan.zhiwenhui.model.entity.UserAnswer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* 兮颜
* @description 针对表【user_answer(用户答题记录)】的数据库操作Mapper
* @createDate 2024-08-20 11:01:15
* @Entity com.xiyan.zhiwenhui.model.entity.UserAnswer
*/
public interface UserAnswerMapper extends BaseMapper<UserAnswer> {

    @Select("select appId, count(userId) as answerCount from user_answer\n" +
            "    group by appId order by answerCount desc limit 10;")
    List<AppAnswerCountDTO> doAppAnswerCount();


    @Select("select resultName, count(resultName) as resultCount from user_answer\n" +
            "    where appId = #{appId}\n" +
            "    group by resultName order by resultCount desc;")
    List<AppAnswerResultCountDTO> doAppAnswerResultCount(Long appId);
}



