package com.example.demo.controllers;


import com.example.demo.entity.MyCounter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@SessionAttributes("myCounter")
public class MainController {

    @GetMapping("/counter")
    public String counter(@ModelAttribute("myCounter") MyCounter myCounter, Model model) {
        myCounter.increment();
        model.addAttribute("counter", myCounter.getCount());
        return "index";
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("View count:0", null, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    @ModelAttribute("myCounter")
    public MyCounter setUp() {
        return new MyCounter();
    }


}
