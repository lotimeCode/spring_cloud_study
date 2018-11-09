package com.lotime.myapp1.client;

import com.lotime.myapp1.entity.User;
import com.lotime.myapp1.hystrix.ServerDemoClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wangzhimin
 * @version create 2018/11/7 16:47
 */
@FeignClient(name = "myService1",fallback = ServerDemoClientHystrix.class)
public interface ServerClient1 {

    @RequestMapping(value = "/server1/test1",method = RequestMethod.GET)
    public String server1Test1(@RequestParam("name")String name);

    @RequestMapping(value = "/server2/test1",method = RequestMethod.GET)
    public String server2Test1(@RequestParam("name")String name, @RequestParam("id")Integer id);

    @RequestMapping(value = "/server2/test2",method = RequestMethod.GET)
    public String server2Test2(@RequestParam("id")Integer id);


    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User getUserById(@PathVariable("id")Integer id);

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    List<User> getUserListByIds(@RequestParam("ids")List<Integer> ids);
}
