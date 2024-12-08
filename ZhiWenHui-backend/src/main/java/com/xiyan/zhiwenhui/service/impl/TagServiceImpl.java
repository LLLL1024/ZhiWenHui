package com.xiyan.zhiwenhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiyan.zhiwenhui.model.entity.Tag;
import com.xiyan.zhiwenhui.service.TagService;
import com.xiyan.zhiwenhui.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author 罗文俊
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-12-08 12:07:32
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




