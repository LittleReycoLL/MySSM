package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//这里用了@SessionAttributes，可以直接把model中的user(也就key)放入其中
//这样保证了session中存在user这个对象
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "Login";
    }
    @RequestMapping("/checkLogin")
    public String checkLogin(User user, Model model){
        user = userService.checkLogin(user.getUsername(),user.getPassword());
        if (user!=null){
            model.addAttribute("user",user);
            return "success";
        }
        return "fail";

    }
}
