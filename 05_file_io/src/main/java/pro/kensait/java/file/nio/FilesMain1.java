package pro.kensait.java.file.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FilesMain1 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("hoge/fuga/foo.txt");

        boolean isDirectory = Files.isDirectory(path);
        System.out.println("isDirectory => " + isDirectory);

        FileTime lastModified = Files.getLastModifiedTime(path);
        System.out.println("lastModified => " + lastModified);

        long length = Files.size(path);
        System.out.println("length => " + length);

        UserPrincipal owner = Files.getOwner(path);
        System.out.println("owner => " + owner);
    }
}