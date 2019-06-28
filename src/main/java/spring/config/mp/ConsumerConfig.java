package spring.config.mp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月27日 17:28:30.
 */
@Getter
@Setter
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "rocketmq.consumer")
@Configuration
@ToString
public class ConsumerConfig  {
//    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
   // @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
}
