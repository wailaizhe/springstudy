package spring.dao;

import org.apache.ibatis.annotations.Select;
import spring.entity.User;
import spring.page.PageParams;

import java.util.List;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:24:41.
 */

public interface UserDao {
    @Select("select * from user")
    String query();
    @Select("select * from user where id =#{id}")
    User getUser(Integer id);
    @Select("select * from user")
    List<User> getUserPage(PageParams pageParams);
}
