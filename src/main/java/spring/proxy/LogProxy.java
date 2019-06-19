package spring.proxy;

import spring.service.UserService;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 静态代理
 * @date 2019年06月19日 13:50:20.
 */

public class LogProxy implements UserService {
    private UserService userService;

    public LogProxy(UserService userService){
        this.userService=userService;
    }

    public String getUserName() {
        System.out.println("this is log");
        return userService.getUserName();
    }

    public void getUser(String name) {

    }
}
