package com.suixin.server.mapper;

import com.suixin.common.core.entity.po.ImMsg;
import com.suixin.common.datasource.mongo.AbstractMongoDao;
import org.springframework.stereotype.Component;

@Component
public class ImMsgMongo extends AbstractMongoDao<ImMsg> {

    @Override
    protected Class<ImMsg> getEntityClass(){
        return ImMsg.class;
    }

}
