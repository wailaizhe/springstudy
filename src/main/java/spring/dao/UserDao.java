package spring.dao;

import spring.config.MySelect;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:24:41.
 */

public interface UserDao {
    @MySelect("select * from user")
    String query();
}
