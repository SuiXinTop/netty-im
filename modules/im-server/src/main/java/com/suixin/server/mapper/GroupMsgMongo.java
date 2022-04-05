package com.suixin.server.mapper;

import com.suixin.common.core.entity.po.GroupMsg;
import com.suixin.common.datasource.mongo.AbstractMongoDao;
import org.springframework.stereotype.Component;

@Component
public class GroupMsgMongo extends AbstractMongoDao<GroupMsg> {

    @Override
    protected Class<GroupMsg> getEntityClass(){
        return GroupMsg.class;
    }

}
