package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.User;
import spring.service.UserService;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月25日 16:59:37.
 */
@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/name")
    public User getName(Integer id){
        return userService.getUser(id);
    }
}
