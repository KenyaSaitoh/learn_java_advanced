package pro.kensait.java.file.stream;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BufferedReaderMain2 {

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