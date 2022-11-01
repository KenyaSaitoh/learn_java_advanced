package pro.kensait.java.file.stream;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderMain1 {

    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("hoge/fuga/foo.txt");

        try (BufferedReader br = Files.newBufferedReader(path1,
                Charset.forName("UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        Path path2 = Paths.get("hoge/fuga/bar.txt");

        try (BufferedReader br = Files.newBufferedReader(path2,
                Charset.forName("Shift_JIS"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}