package com.suixin.server.test;

import com.suixin.common.core.entity.po.ImMsg;
import com.suixin.server.mapper.ImMsgMongo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImServerApplicationTest {

    @Autowired
    private ImMsgMongo imMsgMongo;

    @Test
    public void name(){
        ImMsg imMsg=new ImMsg();
        imMsg.setReceiverId(1);
        imMsg.setMsgContent("2111111111");
        imMsgMongo.save(imMsg);
    }

    @Test
    public void name1(){
        ImMsg imMsg=new ImMsg();
        imMsg.setReceiverId(1);
        imMsg.setMsgContent("2111111111");
        imMsgMongo.save(imMsg);
    }
}
