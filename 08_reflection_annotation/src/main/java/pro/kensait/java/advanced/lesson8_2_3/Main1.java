package pro.kensait.java.advanced.lesson8_2_3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main1 {

    public static void main(String[] args) {
        //
        MyInfo classInfo = Foo.class.getAnnotation(MyInfo.class);
        System.out.println("[ Class Annotation ]");
        System.out.println("name => " + Foo.class.getName());
        System.out.println("value => " + classInfo.value());
        System.out.println("comment => " + classInfo.comment());

        //
        Method[] methods = Foo.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MyInfo methodInfo = method.getAnnotation(MyInfo.class);
            if (methodInfo != null) {
                System.out.println("[ Method Annotation ]");
                System.out.println("name => " + method.getName());
                System.out.println("value => " + methodInfo.value());
                System.out.println("comment => " + methodInfo.comment());
            }
        }

        //
        Field[] fields = Foo.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            MyInfo fieldInfo = field.getAnnotation(MyInfo.class);
            if (fieldInfo != null) {
                System.out.println("[ Field Annotation ]");
                System.out.println("name => " + field.getName());
                System.out.println("value => " + fieldInfo.value());
                System.out.println("comment => " + fieldInfo.comment());
            }
        }

    }
}