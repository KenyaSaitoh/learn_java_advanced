package pro.kensait.java.advanced.lesson8_2_2;

import java.lang.reflect.Field;
import java.util.Objects;

public class Main_InstanceCopy {
    public static void main(String[] args) throws Exception {
        // Person、Customer、それぞれのインスタンスを生成する
        Person p = new Person("Alice", 25, GenderType.FEMALE, "中央区1-1-1");
        Customer c = new Customer(1, "Alice");
        // Person、Customer、それぞれのClassオブジェクトを取得する
        Class<Person> personClazz = Person.class;
        Class<Customer> customerClazz = Customer.class;

        // 氏名のマッチングを行う
        Field personNameField = personClazz.getDeclaredField("personName");
        Field customerNameField = customerClazz.getDeclaredField("customerName");
        personNameField.setAccessible(true);
        customerNameField.setAccessible(true);

        if (! Objects.equals(personNameField.get(p), customerNameField.get(c))) {
            return;
        }

        // 同じフィールド名同士で、値の詰め替えを行う
        PERSON : for (Field personField : personClazz.getDeclaredFields()) {
            for (Field customerField : customerClazz.getDeclaredFields()) {
                System.out.println(personField.getName() + "/" + customerField.getName());
                if (personField.getName().equals(customerField.getName())) {
                    personField.setAccessible(true);
                    customerField.setAccessible(true);
                    customerField.set(c, personField.get(p));
                    continue PERSON;
                }
            }
        }
        System.out.println(c);
    }
}