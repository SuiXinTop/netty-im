package com.suixin.server.mapper;

import com.suixin.common.core.entity.po.SingleMsg;
import com.suixin.common.datasource.mongo.AbstractMongoDao;
import org.springframework.stereotype.Component;

@Component
public class SingleMsgMongo extends AbstractMongoDao<SingleMsg> {

    @Override
    protected Class<SingleMsg> getEntityClass(){
        return SingleMsg.class;
    }

}
