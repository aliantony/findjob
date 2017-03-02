package com.yhan219.controller;

import com.yhan219.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yhan219 on 2017/2/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{username}.html")
    public String show(@PathVariable String username, Model model){
        model.addAttribute("user", userRepository.getUserByUsername(username));
        return "/admin/show";
    }
}
