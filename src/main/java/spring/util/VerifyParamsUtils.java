package spring.util;


import org.springframework.util.StringUtils;
import spring.exception.ParameterException;

/**
 * 参数校验
 *
 * @since 1.0
 */
public class VerifyParamsUtils {

    private VerifyParamsUtils() {

    }

    public static void notNull(Object object, String message) throws ParameterException {
        if (object == null) {
            throw new ParameterException(-1, message);
        }
    }

    public static void notEmpty(String text, String message) throws ParameterException {
        if (StringUtils.isEmpty(text)) {
            throw new ParameterException(-1, message);
        }
    }

    public static void isTrue(boolean expression, String message) throws ParameterException {
        if (!expression) {
            throw new ParameterException(-1, message);
        }
    }

}
