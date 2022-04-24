package pro.kensait.java.generics.wildcard.use;

import java.util.ArrayList;
import java.util.List;

public class GenericsArrayCopyMain {
    public static void main(String[] args) {
        // コピー元のリストを生成し、値を追加する。
        List<Integer> src = new ArrayList<Integer>();
        src.add(10);
        src.add(20);
        src.add(30);

        // コピー先のリストを生成する。
        List<Number> dst = new ArrayList<Number>();

        // コピーメソッドを呼び出す。
        copy(src, dst);

        // コピー先リストの内容を出力する。
        for (Number number : dst) {
            System.out.println(number);
        }
    }

    public static <E> void copy(List<? extends E> src, List<? super E> dst) {
        for (E e : src) {
            dst.add(e);
        }
    }
}
