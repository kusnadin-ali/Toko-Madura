package com.tujuhsembilan.tokomadura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.utils.ResponseUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    
    @PostMapping("/all")
    public ResponseUtil79 postMethodName() {
        log.info("masuk juga nih");
        return ResponseUtil.success("berhasil");
    }
    
}
