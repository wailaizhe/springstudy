package spring.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Proxy;



/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 为接口类生成动态代理的对象
 * @date 2019年06月18日 10:41:42.
 */

public class MyFactoryBean implements FactoryBean {
    Class classes ;
    MyFactoryBean(Class classes){
        this.classes=classes;
    }
    public Object getObject() throws Exception {

        return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{classes},  new MyInvocationHandle()) ;
    }

    public Class<?> getObjectType() {
        return classes;
    }

    public boolean isSingleton() {
        return false;
    }
}
