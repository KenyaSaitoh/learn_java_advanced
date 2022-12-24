package pro.kensait.java.advanced.lsn_5_2_2;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Ser_1 {
    public static void main(String[] args) throws Exception {
        Person target = new Person("Alice", 25, "female");
        Path serPath = Paths.get("alice.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(serPath))) {
            oos.writeObject(target);
        }
    }
}