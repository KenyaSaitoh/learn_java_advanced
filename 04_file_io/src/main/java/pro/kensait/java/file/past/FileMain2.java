package pro.kensait.java.file.past;

import java.io.File;

public class FileMain2 {

    public static void main(String[] args) throws Exception {

        // ディレクトリを作成する
        File file1 = new File("hogehoge");
        file1.mkdirs();

        // ファイルを作成する
        File file2 = new File("hogehoge", "moge.txt");
        file2.createNewFile();

        // ファイルの存在確認をする
        System.out.println("File exists? => " + file2.exists());

        // ファイルを削除する
        file2.delete();

        // ディレクトリを削除する（ファイルが存在していると削除できない）
        file1.delete();

        // ディレクトリの存在確認をする
        System.out.println("Directory exists? => " + file1.exists());
    }
}