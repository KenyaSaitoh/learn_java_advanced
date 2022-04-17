package pro.kensait.java.file.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Paths;

public class SerializeMain2 {

    public static void main(String[] args) throws Exception {
        File serFile = Paths.get("hoge/alice.ser").toFile();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFile))){
            Person target = (Person)ois.readObject();
            System.out.println(target);
        }
    }
}