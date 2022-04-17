package pro.kensait.java.file.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMain1 {

    public static void main(String[] args) {
        Path path1 = Paths.get("hoge/fuga/foo.txt");

        Path fileName1 = path1.getFileName();
        System.out.println("fileName => " + fileName1);

        Path parent1 = path1.getParent();
        System.out.println("parent => " + parent1);

        Path absolutePath1 = path1.toAbsolutePath();
        System.out.println("absolutePath => " + absolutePath1);

        Path path2 = Paths.get("./hoge/fuga/foo.txt");
        Path absolutePath21 = path2.toAbsolutePath();
        System.out.println("absolutePath => " + absolutePath21);
        Path absolutePath22 = path2.toAbsolutePath().normalize();
        System.out.println("absolutePath => " + absolutePath22);
    }
}