package pro.kensait.java.generics.wildcard.boundary1;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain4 {
    public static void main(String[] args) {
        FugaApi fuga = new FugaApi();

        List<Baz> list1 = new ArrayList<>();
        list1.add(new Baz()); list1.add(new Baz()); list1.add(new Baz());

        List<Foo> list2 = new ArrayList<>();

        // BarまたはBarのサブクラスのリストを、BarまたはBarのスーパークラスのリストに
        // コピーする
        fuga.process2(list1, list2);

        for (Foo foo : list2) {
            System.out.println(foo);
        }

        /* 第一引数は、仮引数List<? extends Bar>に対して、List<Baz>型を渡す。
         * 第二引数は、仮引数List<? super Bar>型に対して、List<Foo>型を渡す。
         * 第一引数は、BarまたはBarのサブクラス型をパラメータとして持つリスト（ここではList<Baz>型）から、
         * Bar型として取得する。これがJavaにおける共変。
         * この場合は上限境界（? extends XXX）が使われる。
         * Bar elem = list1.get(i);
         * 
         * 第二引数は、BarまたはBatのスーパークラス型をパラメータとして持つリスト（ここではList<Foo>型）に、
         * Bar型を格納する。これがJavaにおける反変。
         * この場合は下限境界（? super XXX）が使われる。
         * list2.add(elem);
         * この場合、Barと継承関係のないQux型は格納できない。
         */
    }
}
