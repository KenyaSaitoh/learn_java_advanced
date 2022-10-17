package pro.kensait.java.advanced.generics.type.invariant;

import java.util.ArrayList;
import java.util.List;

// 非変
public class GenericsInvariantMain1 {

    public static void main(String[] args) {
        // 以下はOK
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        // 以下はOK
        List<Integer> list2 = new ArrayList<Integer>();

        // 以下はコンパイルエラーになる
        // List<Number> list3 = list2;
    }
}