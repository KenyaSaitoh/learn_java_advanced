package pro.kensait.java.file.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMain2 {

    public static void main(String[] args) {
        Path path = Paths.get("hoge/fuga");

        Path fileName = path.getFileName();
        System.out.println(fileName);

        Path parent = path.getParent();
        System.out.println(parent);
    }
}