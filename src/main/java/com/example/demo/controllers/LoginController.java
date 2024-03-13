package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@SessionAttributes("user")
public class LoginController {

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        System.out.println("cookieValue: " + cookie.getValue() + "/");
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(
            @ModelAttribute("user") Customer customer,
            @CookieValue(value = "setUser", defaultValue = "") String setUser,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ){
        System.out.println("Do login" + customer.getUsername());
        if (customer.getUsername().equals("admin") && customer.getPassword().equals("admin")){
            Cookie cookie = new Cookie("setUser", customer.getUsername());
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie1 : cookies) {
                    if (cookie1.getName().equals("setUser")) {
                        model.addAttribute("cookieValue", cookie1);
                    } else {
                        model.addAttribute("cookieValue", new Cookie("setUser", ""));
                    }
                }
            }
            model.addAttribute("message", "Login success!");
        }else{
            System.out.println("Login failed!");
            model.addAttribute("message", "Login failed!");
        }
        return "login";
    }

    @ModelAttribute("user")
    public Customer setUp(){
        return new Customer();
    }
}
