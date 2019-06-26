package spring.config;

import org.apache.ibatis.annotations.Select;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;


/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月18日 10:51:20.
 */

public class MyInvocationHandle implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getAnnotation( Select.class).value()[0]);
        return proxy;
    }
}
