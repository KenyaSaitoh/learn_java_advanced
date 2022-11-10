package pro.kensait.java.advanced.lesson5_2_2;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Serialize2 {
    public static void main(String[] args) throws Exception {
        Path serPath = Paths.get("alice.ser");
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(serPath))){
            Person target = (Person) ois.readObject();
            System.out.println(target);
        }
    }
}