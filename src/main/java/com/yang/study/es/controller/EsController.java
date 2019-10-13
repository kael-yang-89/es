package com.yang.study.es.controller;

import com.yang.study.es.entity.User;
import com.yang.study.es.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * package:com.yang.study.es.controller
 * author:yang
 * date: 2019/10/13  18:41
 * param: ${PARAM}
 * return:${RETURN}
 * Description:${TODO}
 */
@RestController
public class EsController {

    @Autowired
    private UserRepository userReposiory;

    @RequestMapping("/test")
    public String test( String str) {
        System.out.println("============="+str);
        return str;
    }

    @RequestMapping("/addUser")
    public User addUser(@RequestBody User user) {
        User user1 = userReposiory.save(user);
        System.out.println("============="+user1);
        return user1;
    }

    @RequestMapping("/findUser")
    public Optional<User> findUser(String id) {
        return userReposiory.findById(id);
    }
}
