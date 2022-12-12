package pro.kensait.java.advanced.lesson8_3_2.metainfo;

import java.lang.reflect.Field;

public class Main_CustomAnnotation2 {
    public static void main(String[] args) {
        Field[] fields = Greeting.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            MyMetaInfo fieldAnno = field.getAnnotation(MyMetaInfo.class);
            if (fieldAnno != null) {
                System.out.println("name => " + field.getName());
                System.out.println("MyMetaInfo#value => " + fieldAnno.value());
            }
        }
    }
}