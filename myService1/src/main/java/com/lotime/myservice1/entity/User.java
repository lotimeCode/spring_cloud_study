package com.lotime.myservice1.entity;

/**
 * @author wangzhimin
 * @version create 2018/11/8 19:53
 */
public class User {
    private Integer userId;
    private String name;

    public User(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
