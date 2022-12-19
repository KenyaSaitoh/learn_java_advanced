package pro.kensait.java.advanced.lsn_5_1_3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedOutputStream {

    public static void main(String[] args) throws Exception {
        Path src = Paths.get("java_logo1.jpg");
        Path dest = Paths.get("java_logo2.jpg");

        try(InputStream is = Files.newInputStream(src);
                OutputStream os = Files.newOutputStream(dest)) {
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] buf = new byte[10];
            while (bis.read(buf) != -1) {
                bos.write(buf);
            }
            bos.flush(); // これがないと書き込まれない
        }
    }
}