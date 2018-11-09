package com.lotime.myapp1.controller;

import com.lotime.myapp1.client.ServerClient1;
import com.lotime.myapp1.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhimin
 * @version create 2018/11/8 20:09
 */
@RestController
@RequestMapping("/app3")
public class AppUserController {

    @Resource
    private ServerClient1 serverUserClient;

    @RequestMapping(value = "/getUser")
    public void getAllUsers() throws Exception{
        long start = System.currentTimeMillis();
        sendHttpRequests(5,10);
        long end  = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public void sendHttpRequests(int threadNum,int reqNum) throws Exception{
        List<Thread> threadList = new ArrayList<>(threadNum);
        for(int i=0;i<threadNum;i++){
            Map<String, User> result = new HashMap<>(reqNum);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= reqNum; i++) {
                        String str = "user_";
                        str = str + i + "_";
                        int id = i % 7 + 1;
                        result.put(str + id, serverUserClient.getUserById(id));
                    }
                    System.out.println(result.values().size());
                }
            });
            threadList.add(thread);
        }
        for(Thread thread : threadList) {
            thread.start();
        }
        for(Thread thread : threadList){
            thread.join();
        }

    }
}
