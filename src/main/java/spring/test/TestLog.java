package spring.test;

import spring.log.Jul;
import spring.log.Slf4j;
import spring.log.SpringLog;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月24日 14:09:44.
 */

public class TestLog {
    public static void main(String[] args) {
       // Log4j.main();
        Jul.main();
        Slf4j.main();
        SpringLog.main();
    }
}
