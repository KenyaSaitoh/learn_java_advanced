package pro.kensait.java.advanced.lesson8_3_2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main_Annotation {
    public static void main(String[] args) {
        MyInfo classAnno = Greeting.class.getAnnotation(MyInfo.class);
        System.out.println("===== Classアノテーション =====");
        System.out.println("MyInfo#value => " + classAnno.value());
        System.out.println("MyInfo#comment => " + classAnno.comment());

        Field[] fields = Greeting.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            MyInfo fieldAnno = field.getAnnotation(MyInfo.class);
            if (fieldAnno != null) {
                System.out.println("===== Fieldアノテーション =====");
                System.out.println("name => " + field.getName());
                System.out.println("MyInfo#value => " + fieldAnno.value());
                System.out.println("MyInfo#comment => " + fieldAnno.comment());
            }
        }

        Method[] methods = Greeting.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MyInfo methodAnno = method.getAnnotation(MyInfo.class);
            if (methodAnno != null) {
                System.out.println("===== Method =====");
                System.out.println("name => " + method.getName());
                System.out.println("MyInfo#value => " + methodAnno.value());
                System.out.println("MyInfo#comment => " + methodAnno.comment());
            }
            Parameter[] params = method.getParameters();
            for (int j = 0; j < params.length; j++) {
                Parameter param = params[j];
                MyParam paramAnno = param.getAnnotation(MyParam.class);
                if (paramAnno != null) {
                    System.out.println("===== Parameter =====");
                    System.out.println("name => " + param.getName());
                    System.out.println("type => " + param.getType());
                    System.out.println("MyParam#value => " + paramAnno.value());
                }
            }
        }
    }
}