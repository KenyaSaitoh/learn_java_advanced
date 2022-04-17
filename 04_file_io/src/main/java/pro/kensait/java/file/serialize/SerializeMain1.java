package pro.kensait.java.file.serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Paths;

public class SerializeMain1 {

    public static void main(String[] args) throws Exception {
        File serFile = Paths.get("hoge/alice.ser").toFile();
        Person target = new Person(1, "Alice", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFile))) {
            oos.writeObject(target);
        }
    }
}

/* ======================================== */
class Person implements Serializable {

    private static final long serialVersionUID = -6011243720394071084L;
    Integer personId;
    String personName;
    transient Integer age;
    Person(Integer personId, String personName, Integer age) {
        super();
        this.personId = personId;
        this.personName = personName;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [personId=" + personId + ", personName=" + personName + ", age=" + age + "]";
    }
}