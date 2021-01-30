package com.ifsp.apipagamento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping(value="/")
    public String getMethodName() {
        return "IFSP API 2 - Pagamentos";
    }
    
    
}
