package spring.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:自定义注解扫描
 * @date 2019年06月18日 14:12:20.
 */
@Retention(RetentionPolicy.RUNTIME)
// 此注解就是为 MyImportBeanDefinitionRegister 扫描用的
@Import(MyImportBeanDefinitionRegister.class)
public @interface Mycomponent {
}
