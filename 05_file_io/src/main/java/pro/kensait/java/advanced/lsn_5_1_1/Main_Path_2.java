package pro.kensait.java.advanced.lsn_5_1_1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Path_2 {

    public static void main(String[] args) {
        Path path = Paths.get("hoge/fuga");

        Path fileName = path.getFileName();
        System.out.println(fileName);

        Path parent = path.getParent();
        System.out.println(parent);
    }
}