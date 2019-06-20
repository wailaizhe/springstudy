package spring.config.aop;


import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;


/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月18日 10:51:20.
 */

public class MyInvocationHandle2 implements InvocationHandler {
    private Object object;
    public MyInvocationHandle2(Object object){
        this.object=object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this is handle");
        return method.invoke(object,args);
    }
}
