package custom.annotation;

import java.lang.annotation.*;

/**
 * @author:leeyf
 * @date:Created in10:22 2018/10/8
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();

    String author();

    int age() default 18;
}
