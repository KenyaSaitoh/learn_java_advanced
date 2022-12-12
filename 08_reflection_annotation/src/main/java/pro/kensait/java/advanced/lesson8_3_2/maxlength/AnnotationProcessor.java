package pro.kensait.java.advanced.lesson8_3_2.maxlength;

import java.lang.reflect.Field;

public class AnnotationProcessor {
    public static void checkMaxLength(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            MaxLength fieldAnno = field.getAnnotation(MaxLength.class);
            if (fieldAnno == null) continue;
            try {
                field.setAccessible(true);
                String str = (String) field.get(object);
                int max = fieldAnno.value();
                if (max < str.length()) {
                    throw new RuntimeException(
                            "文字列長が指定された長さを超えています");
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}