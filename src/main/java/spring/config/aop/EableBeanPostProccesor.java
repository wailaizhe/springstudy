package spring.config.aop;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月20日 14:18:55.
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyBeanPostproccessor.class)
public @interface EableBeanPostProccesor {
}
