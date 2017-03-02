package com.yhan219.controller;

import com.yhan219.config.SecurityUserService;
import com.yhan219.domain.User;
import com.yhan219.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by yhan219 on 2017/2/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("principal.username.equals(#username) or hasRole('ROLE_ADMIN')")
    @GetMapping("/{username}.html")
    public ModelAndView showUser(@PathVariable String username) {
        return new ModelAndView("/user/show", "user", userService.getUserByUsername(username));
    }

    @GetMapping("/{username}.json")
    @ResponseBody
    User getUser(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

}
