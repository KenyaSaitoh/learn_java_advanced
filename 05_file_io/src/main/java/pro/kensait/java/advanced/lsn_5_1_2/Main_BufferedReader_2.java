package pro.kensait.java.advanced.lsn_5_1_2;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main_BufferedReader_2 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("hoge/fuga/foo.txt");

        try (BufferedReader br = Files.newBufferedReader(path)) {

            List<String> fileContents = Files.readAllLines(path);
            for (String line : fileContents) {
                System.out.println(line);
            }
        }
    }
}