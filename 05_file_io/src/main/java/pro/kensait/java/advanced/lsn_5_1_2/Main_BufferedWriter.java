package pro.kensait.java.advanced.lsn_5_1_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_BufferedWriter {
    public static void main(String[] args) {
        Path src = Paths.get("hoge/fuga/foo.txt");
        Path dest = Paths.get("hoge/fuga/foo2.txt");

        try (BufferedReader br = Files.newBufferedReader(src);
                BufferedWriter bw = Files.newBufferedWriter(dest)) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + System.lineSeparator());
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}