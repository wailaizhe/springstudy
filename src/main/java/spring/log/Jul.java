package spring.log;

import java.util.logging.Logger;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月24日 14:28:18.
 */

public class Jul {
    private static Logger logger=Logger.getLogger("log");

    public static void main() {
        logger.info("this is jul log");
    }
}
