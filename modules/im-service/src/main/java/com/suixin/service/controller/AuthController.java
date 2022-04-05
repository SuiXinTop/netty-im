package com.suixin.service.controller;

import com.suixin.common.core.entity.dto.RestMsg;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PutMapping("/login")
    public RestMsg<Object> login() {
        return null;
    }

    @PutMapping("/logout")
    public RestMsg<Object> logout() {
        return null;
    }

}
