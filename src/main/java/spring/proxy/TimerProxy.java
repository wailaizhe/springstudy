package spring.proxy;

import spring.entity.User;
import spring.service.UserService;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 静态代理
 * @date 2019年06月19日 13:50:20.
 */

public class TimerProxy implements UserService {
    private UserService userService;

    public TimerProxy(UserService userService){
        this.userService=userService;
    }

    public String getUserName() {
        System.out.println("this is time");
        return userService.getUserName();
    }

    public void getUser(String name) {

    }

    @Override
    public User getUser(Integer id) {
        return null;
    }
}
