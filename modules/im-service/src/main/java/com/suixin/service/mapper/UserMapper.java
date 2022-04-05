package com.suixin.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suixin.common.core.entity.po.ImUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<ImUser> {

}
