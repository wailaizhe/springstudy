package spring.config;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description: 将bean注入spring容器
 * @date 2019年06月18日 11:33:05.
 */

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // 扫描包获取对象bean的list，循环将bean注入到beanDefinition容器
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("spring.dao.UserDao");
        beanDefinitionRegistry.registerBeanDefinition("userDao",beanDefinition);


        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
        AbstractBeanDefinition beanDefinition2 = beanDefinitionBuilder2.getBeanDefinition();
        beanDefinition2.getConstructorArgumentValues().addGenericArgumentValue("spring.dao.CityDao");
        beanDefinitionRegistry.registerBeanDefinition("cityDao",beanDefinition2);
    }
}
