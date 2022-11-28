package pro.kensait.java.advanced.lesson9_1_3;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
public @interface ElementInfo {
    int value();
    String version() default "0.0";
    String comment() default "This is Default Comment";
}