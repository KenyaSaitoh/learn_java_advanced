package pro.kensait.java.advanced.lesson9_1_3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main1 {

    public static void main(String[] args) {
        //
        ElementInfo classInfo = Foo.class.getAnnotation(ElementInfo.class);
        System.out.println("[ Class Annotation ]");
        System.out.println("name => " + Foo.class.getName());
        System.out.println("value => " + classInfo.value());
        System.out.println("version => " + classInfo.version());
        System.out.println("comment => " + classInfo.comment());

        //
        Method[] methods = Foo.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            ElementInfo methodInfo = method.getAnnotation(ElementInfo.class);
            if (methodInfo != null) {
                System.out.println("[ Method Annotation ]");
                System.out.println("name => " + method.getName());
                System.out.println("value => " + methodInfo.value());
                System.out.println("version => " + methodInfo.version());
                System.out.println("comment => " + methodInfo.comment());
            }
        }

        //
        Field[] fields = Foo.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ElementInfo fieldInfo = field.getAnnotation(ElementInfo.class);
            if (fieldInfo != null) {
                System.out.println("[ Field Annotation ]");
                System.out.println("name => " + field.getName());
                System.out.println("value => " + fieldInfo.value());
                System.out.println("version => " + fieldInfo.version());
                System.out.println("comment => " + fieldInfo.comment());
            }
        }

    }
}