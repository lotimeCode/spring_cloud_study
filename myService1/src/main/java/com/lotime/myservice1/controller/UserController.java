package com.lotime.myservice1.controller;

import com.lotime.myservice1.entity.User;
import com.lotime.myservice1.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzhimin
 * @version create 2018/11/8 20:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id")Integer id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getUserById(@RequestParam("ids")List<Integer> ids){
        return userService.getUserListByIds(ids);
    }
}
