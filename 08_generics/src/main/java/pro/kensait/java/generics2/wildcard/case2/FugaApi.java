package pro.kensait.java.generics2.wildcard.case2;

import java.util.List;

public class FugaApi {

    public void process1(List<Bar> src, List<Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }

    public void process2(List<? extends Bar> src, List<? super Bar> dest) {
        for (Bar bar : src) {
            dest.add(bar);
        }
    }
}

class Foo {}
class Bar extends Foo {}
class Baz extends Bar {}