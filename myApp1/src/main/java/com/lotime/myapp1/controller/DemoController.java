package com.lotime.myapp1.controller;

import com.lotime.myapp1.feginController.server.ServerDemoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:41
 */
@RestController
@RequestMapping("/app")
public class DemoController {

    @Resource
    private ServerDemoClient serverDemoClient;

    @RequestMapping(value = "/test")
    public String getAllStr(){
        System.out.println("app come in ...");
        return "my app come in, receive message from server : " + serverDemoClient.testDemo1("lotime");
    }
}
