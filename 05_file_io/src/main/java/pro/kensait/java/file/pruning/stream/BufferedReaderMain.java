package pro.kensait.java.file.pruning.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderMain {

    public static void main(String[] args) throws Exception {
        String fileName = "hoge/fuga/foo.txt";
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}