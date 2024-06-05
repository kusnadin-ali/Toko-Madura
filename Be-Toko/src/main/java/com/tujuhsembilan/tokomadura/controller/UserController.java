package com.tujuhsembilan.tokomadura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.dto.users.LoginRequest;
import com.tujuhsembilan.tokomadura.dto.users.RegisterRequest;
import com.tujuhsembilan.tokomadura.service.customer.iservice.LoginService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseUtil79 login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/register")
    public ResponseUtil79 register(@RequestBody RegisterRequest request) {
        return loginService.register(request);
    }
}
