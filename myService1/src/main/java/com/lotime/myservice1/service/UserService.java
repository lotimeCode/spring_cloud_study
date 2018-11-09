package com.lotime.myservice1.service;

import com.lotime.myservice1.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangzhimin
 * @version create 2018/11/8 19:51
 */
@Service
public class UserService {
    private static Map<Integer,User> userMap = new HashMap<>(7);

    static {
        userMap.put(1,new User(1,"user1"));
        userMap.put(2,new User(2,"user2"));
        userMap.put(3,new User(3,"user3"));
        userMap.put(4,new User(4,"user4"));
        userMap.put(5,new User(5,"user5"));
        userMap.put(6,new User(6,"user6"));
        userMap.put(7,new User(7,"user7"));
    }

    @HystrixCollapser(batchMethod = "getUserListByIds",scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds",value = "500"),@HystrixProperty
                    (name = "maxRequestsInBatch", value = "15")})
    public User getUserById(Integer id) {
        System.out.println("getUserById ======");
        return userMap.get(id);
    }

    @HystrixCommand
    public List<User> getUserListByIds(List<Integer> idList){
        System.out.println("getUserListByIds ++++++++");
        return userMap.values().stream().filter(user -> idList.contains(user.getUserId())).collect(Collectors.toList());
    }
}
