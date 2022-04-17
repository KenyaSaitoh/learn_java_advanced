package pro.kensait.java.file.pruning.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedStreamMain {

    public static void main(String[] args) throws Exception {
        String inputFileName = "hoge/fuga/foo.txt";
        String outputFileName = "hoge/fuga/foo_out.txt";
        // 文字データの読み込み → 書き込み
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile));
        byte[] buf = new byte[10];
        int size;
        while ((size = bis.read(buf, 0, buf.length)) != -1) {
            bos.write(buf, 0, size);
            System.out.println("ファイルに書き込んだbyte値のサイズ => " + size);
        }
        bis.close();
        bos.close();
    }
}