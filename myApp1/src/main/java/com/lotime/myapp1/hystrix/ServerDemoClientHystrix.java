package com.lotime.myapp1.hystrix;

import com.lotime.myapp1.client.ServerClient1;
import com.lotime.myapp1.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author wangzhimin
 * @version create 2018/11/7 17:10
 */
@Component
public class ServerDemoClientHystrix implements ServerClient1 {

    @Override
    public String server1Test1(String name) {
        return "server1Test1 服务降级";
    }

    @Override
    public String server2Test1(String name, Integer id) {
        return "server2Test1 服务降级";
    }

    @Override
    public String server2Test2(Integer id) {
        return "server2Test2 服务降级";
    }

    @Override
    public User getUserById(Integer id) {
        return new User();
    }

    @Override
    public List<User> getUserListByIds(List<Integer> ids) {
        return Collections.emptyList();
    }
}
