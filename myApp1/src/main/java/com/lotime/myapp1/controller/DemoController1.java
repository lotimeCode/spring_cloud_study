package com.lotime.myapp1.controller;

import com.lotime.myapp1.client.ServerClient1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:41
 */
@RestController
@RequestMapping("/app1")
public class DemoController1 {

    @Resource
    private ServerClient1 serverClient1;

    @RequestMapping(value = "/test1")
    public String getAllStr(){
        System.out.println("app come in ...");
        return "my app come in, receive message from server : " + serverClient1.server1Test1("lotime");
    }
}
