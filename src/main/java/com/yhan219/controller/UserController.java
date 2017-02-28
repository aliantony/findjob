package com.yhan219.controller;

import com.yhan219.domain.User;
import com.yhan219.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yhan219 on 2017/2/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}.html")
    public String showUser(@PathVariable String username,Model model){
        User user = userService.getUserByUsername(username);
        model.addAttribute("user",user);
        return "/user/show";
    }

    @GetMapping("/{username}.json")
    @ResponseBody
    User getUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

}
