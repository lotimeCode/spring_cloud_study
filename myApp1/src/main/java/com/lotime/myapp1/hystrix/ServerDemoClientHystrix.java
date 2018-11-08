package com.lotime.myapp1.hystrix;

import com.lotime.myapp1.feginController.server.ServerDemoClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangzhimin
 * @version create 2018/11/7 17:10
 */
@Component
public class ServerDemoClientHystrix implements ServerDemoClient {
    @Override
    public String testDemo1(@RequestParam("name")String name) {
        System.out.println("ServerDemoClientHystrix come in ...");
        return "occur error 9999";
    }
}
