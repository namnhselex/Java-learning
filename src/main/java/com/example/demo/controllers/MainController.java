package com.example.demo.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello World", null, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

}
