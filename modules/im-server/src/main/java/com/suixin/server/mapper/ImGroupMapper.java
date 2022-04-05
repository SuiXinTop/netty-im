package com.suixin.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suixin.common.core.entity.po.ImGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface ImGroupMapper extends BaseMapper<ImGroup> {

    Set<String> getUserIdSetByGroupId(Integer group);

}
