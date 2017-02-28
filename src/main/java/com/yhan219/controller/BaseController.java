package com.yhan219.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yhan219 on 2017/2/13.
 */
@Controller
public class BaseController {

    @RequestMapping(value = {"/","/index","/login.html"})
    public String home(){
        return "login";
    }

}
