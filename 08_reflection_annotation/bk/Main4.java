package pro.kensait.java.advanced.lesson9_1_2;

import java.lang.reflect.Field;

public class Main4 {
    public static void main(String[] args) {
        try {
            // クラスオブジェクトを取得する
            Class<?> clazz = Class.forName("pro.kensait.java.advanced.lesson9_1_2.Person");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // フィールドオブジェクト（宣言されたフィールド）を取得する
            System.out.println("===== 宣言されたフィールドを表示 =====");
            Field[] declaredFieldList = clazz.getDeclaredFields();
            for (int i = 0; i < declaredFieldList.length; i++) {
                Field field = declaredFieldList[i];
                String fieldType = field.getType().getName();
                String fieldName = field.getName();
                // フィールド情報を表示する
                System.out.println(fieldType + " / " + fieldName);
            }

            // フィールドオブジェクト（publicなフィールド）を取得する
            System.out.println("===== publicなフィールドを表示 =====");
            Field[] publicFieldList = clazz.getFields();
            for (int i = 0; i < publicFieldList.length; i++) {
                Field field = publicFieldList[i];
                String fieldType = field.getType().getName();
                String fieldName = field.getName();
                // フィールド情報を表示する
                System.out.println(fieldType + " / " + fieldName);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}