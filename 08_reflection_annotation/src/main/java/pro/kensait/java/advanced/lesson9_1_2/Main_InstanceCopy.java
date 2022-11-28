package pro.kensait.java.advanced.lesson9_1_2;

import java.lang.reflect.Field;

public class Main_InstanceCopy {
    public static void main(String[] args) throws Exception {
        Person p = new Person("Alice", 25, GenderType.FEMALE, "中央区1-1-1");
        Customer c = new Customer(1, "Alice");

        Class<Person> personClazz = Person.class;
        Class<Customer> customerClazz = Customer.class;

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