package spring.config.aop;

import org.apache.ibatis.annotations.Select;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月14日 16:30:20.
 */
@Aspect
@Component
public class MyAspect  {
    @Pointcut("execution(* spring.dao.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method.getAnnotation( Select.class)!=null){
            String annotation = method.getAnnotation( Select.class).value()[0];
            System.out.println(annotation);
        }

        System.out.println("before");
    }
}
