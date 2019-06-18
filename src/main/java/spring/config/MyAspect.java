package spring.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月14日 16:30:20.
 */
@Aspect
public class MyAspect  {

    @Before("execution(* spring.service.impl.UserServiceImpl())")
    public void before(){
        System.out.println("before");
    }
}
