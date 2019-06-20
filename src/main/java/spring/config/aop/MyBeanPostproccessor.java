package spring.config.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import spring.service.UserService;




/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 模拟后置处理器
 * @date 2019年06月20日 13:39:11.
 */
public class MyBeanPostproccessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       if ("userService".equals(beanName)){
           bean= Proxy.newProxyInstance(MyBeanPostproccessor.class.getClassLoader(),new Class[]{UserService.class},  new MyInvocationHandle2(bean));
       }

        return bean;
    }
}
