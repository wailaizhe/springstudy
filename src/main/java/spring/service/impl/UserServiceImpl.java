package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.dao.CityDao;
import spring.dao.UserDao;
import spring.service.UserService;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:29:10.
 */
@Component
@Service("userService")
public class UserServiceImpl implements UserService {
   @Autowired
    private CityDao cityDao;
    @Autowired
    private UserDao userDao;
    public String getUserName() {
        System.out.println("get name");
        return "this is name";
    }

    public void getUser(String name) {

    }
}
