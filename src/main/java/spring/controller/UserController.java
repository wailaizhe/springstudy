package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.RespBean;
import spring.exception.ParameterException;
import spring.page.PageParams;
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
    public RespBean getName(Integer id)  {
        try {

            return RespBean.ok("查询成功", userService.getUser(id));
        } catch (ParameterException e) {
            return RespBean.error(e.getErrorMessage());
        }catch (Exception e){
            return RespBean.error("查询失败");
        }

    }
    @RequestMapping("page")
    public RespBean pageUser(){
        PageParams pageParams=new PageParams();
        pageParams.setCheckFlag(false);
        pageParams.setUseFlag(true);
        pageParams.setPageSize(2);
        pageParams.setPage(1);

        return RespBean.ok("查询成功",userService.getUserPage(pageParams));
    }
}
