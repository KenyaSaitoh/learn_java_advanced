package pro.kensait.java.advanced.lesson5_2_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_ByteArray {

    public static void main(String[] args) throws Exception {
        Path src = Paths.get("java_logo1.jpg");
        Path dest = Paths.get("java_logo2.jpg");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(InputStream is = Files.newInputStream(src)) {
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buf = new byte[10];
            while (bis.read(buf) != -1) {
                baos.write(buf);
            }
        }
        byte[] byteArray = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        try(OutputStream os = Files.newOutputStream(dest)) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int c;
            while ((c = bais.read()) != -1) {
                bos.write(c);
            }
            bos.flush();
        }
    }
}