package com.lotime.myservice1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhimin
 * @version create 2018/11/8 10:46
 */
@RestController
@RequestMapping(value = "/server2")
public class ServerController2 {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String testDemo1(@RequestParam("name")String name,@RequestParam("id")Integer id){
        System.out.println("myServer1 server1 test1 : name=" + name + ", id=" + id);
        return "server2_test1 : " + name + "_" + id;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String testDemo2(@RequestParam("id")Integer id){
        System.out.println("myServer1 server2 test2 : id=" + id);
        return "server2_test2 : " + id;
    }
}
