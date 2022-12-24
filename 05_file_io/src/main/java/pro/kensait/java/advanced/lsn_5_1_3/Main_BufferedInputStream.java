package pro.kensait.java.advanced.lsn_5_1_3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedInputStream {
    public static void main(String[] args) {
        Path path = Paths.get("java_logo1.jpg");

        try(InputStream is = Files.newInputStream(path)) {
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buf = new byte[10];
            while (bis.read(buf) != -1) {
                for (byte b : buf) {
                    System.out.println("読み込んだバイトデータ => " + b);
                }
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}