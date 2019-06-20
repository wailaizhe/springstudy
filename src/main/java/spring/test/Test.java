package spring.test;

import spring.service.CityService;
import spring.service.UserService;
import spring.service.impl.CityServiceImpl;
import spring.service.impl.UserServiceImpl;
import spring.util.ProxyUtil;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 静态代理的聚合代理 继承代理的对象，并包含抽象类
 * @date 2019年06月19日 13:57:29.
 */

public class Test{
    public static void main(String[] args) throws Exception {
        UserService userService=new UserServiceImpl();
        CityService cityService=new CityServiceImpl();
       /*UserService prosy=new LogProxy(userService);
       UserService proxy=new TimerProxy(prosy);
        System.out.println(proxy.getUserName());*/
        //Proxy
        CityService proxy= (CityService) ProxyUtil.newInstanceProxy(cityService);
        proxy.getCityName();
    }
}
