package pro.kensait.java.file.bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamMain {

    public static void main(String[] args) throws Exception {
        byte[] buf = { 1, 2, 3 };
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < buf.length; i++) {
            // バッファに書き込む
            baos.write(buf[i]);
            System.out.println("バッファに書き込んだ値 => " + buf[i]);
        }
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        int c;
        while ((c = bais.read()) != -1) {
            // バッファから読み込む
            System.out.println("バッファから読み込んだ値 => " + c);
        }
        bais.close();
    }
}