package spring.config.mp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月27日 17:12:24.
 */
@Setter
@Getter
@ToString
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "rocketmq.producer")
@Configuration
@Slf4j
public class ProducerConfig {
    //@Value("${rocketmq.producer.groupName}")
    private String groupName;
   // @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
}
