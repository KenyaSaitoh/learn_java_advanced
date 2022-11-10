package pro.kensait.java.advanced.lesson5_1_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_Files2 {

    public static void main(String[] args) throws Exception {
        Path srcFile = Paths.get("hoge/fuga/foo.txt");

        Path destFile1 = Paths.get("hoge/fuga/foo2.txt");
        Files.copy(srcFile, destFile1);

        Path destFile2 = Paths.get("hoge/piyo/foo.txt");
        Files.move(srcFile, destFile2);

        Path srcDir = Paths.get("hoge/piyo");
        Path destDir = Paths.get("hoge/piyo2");
        Files.move(srcDir, destDir);

        // 元に戻す
        Files.delete(destFile1);
        Files.move(destDir, srcDir);
        Files.move(destFile2, srcFile);
    }
}