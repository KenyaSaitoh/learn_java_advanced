package pro.kensait.java.file.stream;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedInputStreamMain2 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("hoge/fuga/java_logo.jpg");

        try(InputStream is = Files.newInputStream(path)) {
            BufferedInputStream bis = new BufferedInputStream(is);

            byte[] allBytes = bis.readAllBytes();
            for (byte b : allBytes) {
                System.out.println("読み込んだデータ => " + b);
            }
        }
    }
}