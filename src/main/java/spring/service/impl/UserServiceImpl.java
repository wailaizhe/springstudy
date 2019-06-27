package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import spring.dao.CityDao;
import spring.dao.UserDao;
import spring.entity.User;
import spring.exception.ParameterException;
import spring.page.PageParams;
import spring.service.UserService;
import spring.util.RedisUtil;
import spring.util.VerifyParamsUtils;

import java.util.List;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:29:10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisUtil redisUtil;
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

    @Override
    public User getUser(Integer id) throws ParameterException {
        VerifyParamsUtils.notNull(id,"id 不能为空");
        String value = redisUtil.get("id:" + id, 0);
        if (StringUtils.isEmpty(value)){
            redisUtil.set("id:"+id,id+"",0);
        }


        return userDao.getUser(id);
    }

    @Override
    public PageParams<User> getUserPage(PageParams pageParams) {
        List<User> userPage = userDao.getUserPage(pageParams);
        pageParams.setList(userPage);
        return pageParams;
    }
}
