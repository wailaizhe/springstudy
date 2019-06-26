package spring.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月25日 16:26:09.
 */
@SpringBootApplication
@MapperScan("spring.dao")
@ComponentScan("spring.*")

public class App  implements WebMvcConfigurer {





    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
