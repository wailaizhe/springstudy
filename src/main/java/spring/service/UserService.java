package spring.service;

import spring.entity.User;
import spring.exception.ParameterException;
import spring.page.PageParams;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:28:40.
 */

public interface UserService {
    String getUserName();
    void getUser(String name);
    User getUser(Integer id) throws ParameterException;
    PageParams<User> getUserPage(PageParams pageParams);
}
