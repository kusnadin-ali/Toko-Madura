package com.tujuhsembilan.tokomadura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.dto.users.RegisterRequest;
import com.tujuhsembilan.tokomadura.service.customer.iservice.LoginService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseUtil79 login(@RequestBody String entity) {
        return loginService.login();
    }

    @PostMapping("/register")
    public ResponseUtil79 register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
    }
    
    
}
