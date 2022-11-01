package pro.kensait.java.file.past;

import java.io.File;

public class FileMain1 {

    public static void main(String[] args) {
        File file = new File("hoge/fuga/foo.txt");

        String name = file.getName();
        System.out.println("name => " + name);

        String parent = file.getParent();
        System.out.println("parent => " + parent);

        String path = file.getPath();
        System.out.println("path => " + path);

        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath => " + absolutePath);

        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory => " + isDirectory);

        boolean isFile = file.isFile();
        System.out.println("isFile => " + isFile);

        long lastModified = file.lastModified();
        System.out.println("lastModified => " + lastModified);

        long length = file.length();
        System.out.println("length => " + length);
    }
}