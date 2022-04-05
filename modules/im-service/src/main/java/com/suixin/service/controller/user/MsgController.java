package com.suixin.service.controller.user;

import com.suixin.common.core.entity.dto.RestMsg;
import com.suixin.common.security.annotation.PreAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/msg")
public class MsgController {

    @PreAuth
    @GetMapping("/single")
    public RestMsg<Object> getHistorySingleMsg(Integer userId, Integer pageNum, Integer pageSize) {
        return null;
    }

    @PreAuth
    @GetMapping("/group")
    public RestMsg<Object> getHistoryGroupMsg(Integer userId, Integer pageNum, Integer pageSize) {
        return null;
    }

}
