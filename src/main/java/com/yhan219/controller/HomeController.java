package com.yhan219.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yhan219 on 2017/3/2.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/templates/index.html"})
    public String index(){
        return "index";
    }

}
