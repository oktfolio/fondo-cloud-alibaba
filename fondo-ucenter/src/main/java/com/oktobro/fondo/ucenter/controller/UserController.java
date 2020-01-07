package com.oktobro.fondo.ucenter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/01/07
 */
@RestController
public class UserController {

    @RequestMapping("test")
    private ResponseEntity test() {
        return ResponseEntity.ok().build();
    }
}
