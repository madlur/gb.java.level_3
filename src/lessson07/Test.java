package lessson07;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

/**
 * priority increases when numbers increase
 * priority = 1 is the lowest
 */

public @interface Test {
    int priority() default 1;
}
