package com.lotime.myapp1.feginController.server;

import com.lotime.myapp1.hystrix.ServerDemoClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:47
 */
@FeignClient(name = "myService1",path = "/demo",fallback = ServerDemoClientHystrix.class)
public interface ServerDemoClient {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String testDemo1(@RequestParam("name")String name);
}
