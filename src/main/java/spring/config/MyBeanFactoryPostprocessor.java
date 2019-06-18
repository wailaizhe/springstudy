package spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring.entity.User;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:动态改变bean的类
 * @date 2019年06月18日 11:04:05.
 */

public class MyBeanFactoryPostprocessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(configurableListableBeanFactory);
        GenericBeanDefinition city = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("city");
        city.setBeanClass(User.class);

    }
}
