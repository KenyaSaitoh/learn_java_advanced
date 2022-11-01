package pro.kensait.java.file.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedOutputStreamMain {

    public static void main(String[] args) throws Exception {
        Path src = Paths.get("hoge/fuga/java_logo.jpg");
        Path dest = Paths.get("hoge/fuga/java_logo2.jpg");

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