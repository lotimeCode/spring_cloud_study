package com.lotime.myapp1.controller;

import com.lotime.myapp1.client.ServerClient1;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:41
 */
@RestController
@RequestMapping("/app2")
@DefaultProperties(defaultFallback = "defaultFallback")
public class DemoController2 {

    @Resource
    private ServerClient1 serverClient1;

    @RequestMapping(value = "/test1")
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "5000")})
    public String testServerDemo2Test1(){
        System.out.println("app test1 come in ...");
        try {
            Thread.sleep(7000);
        }catch (Exception e){

        }
        return "my app come in, [app2 test1] receive from server : " + serverClient1.server2Test1("wzmm",123);
    }

    @RequestMapping(value = "/test2")
    @HystrixCommand(defaultFallback = "fallback")
    public String testServerDemo2Test2(){
        System.out.println("app test2 come in ...");
        return "my app come in, [app2 test2] receive from server : " + serverClient1.server2Test2(456678);
    }

    private String fallback(){
        return "降级保护（指定）";
    }


    private String defaultFallback(){
        return "降级保护(默认)";
    }
}
