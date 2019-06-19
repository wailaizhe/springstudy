package spring.app;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.config.Mycomponent;
import spring.service.UserService;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:27:51.
 */
@Configurable
@ComponentScan("spring.*")
@Mycomponent
public class ApplicationContextss {
    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
        // ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextss.class);
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        //System.out.println(context.getBean(User.class));
      //  System.out.println(context.getBean("myBeanFactory"));
       /* for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }*/
        UserService bean = context.getBean(UserService.class);
       // bean.getUserName();
        // 这句将输出: hello world
        System.out.println(bean.getUserName());
    }

}
