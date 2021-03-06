package com.lotime.myservice1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:37
 */
@RestController
@RequestMapping(value = "/serve1")
public class ServerController1 {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String testDemo1(@RequestParam("name")String name){
        System.out.println("myServer1 receive : " + name);
        return "serve1_test1 : name=" + name;
    }
}
