package spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月24日 14:39:55.
 */

public class Slf4j {
    private  static Logger logger= LoggerFactory.getLogger("slf4j");

    public static void main() {
        logger.info("this is slf4j log");
    }
}
