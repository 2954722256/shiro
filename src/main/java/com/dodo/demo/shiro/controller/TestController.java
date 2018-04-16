package com.dodo.demo.shiro.controller;

import com.dodo.demo.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public String indexString(){
        System.out.println("indexString");
        return "just str， please visit  /index";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("login");
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/error2")
    public String error() {
        System.out.println("error2");
        return "error2";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session) {
        System.out.println("loginUser");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
//            return "login";
            System.out.println(""+e.getMessage());
            return "error2";
        }
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        System.out.println("admin");
        return "admin success";
    }

    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout() {
        System.out.println("logout");
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }


}
