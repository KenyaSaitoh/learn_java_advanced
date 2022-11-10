package pro.kensait.java.advanced.lesson5_1_3;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedInputStream2 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("java_logo1.jpg");

        try(InputStream is = Files.newInputStream(path)) {
            BufferedInputStream bis = new BufferedInputStream(is);

            byte[] allBytes = bis.readAllBytes();
            for (byte b : allBytes) {
                System.out.println("読み込んだデータ => " + b);
            }
        }
    }
}