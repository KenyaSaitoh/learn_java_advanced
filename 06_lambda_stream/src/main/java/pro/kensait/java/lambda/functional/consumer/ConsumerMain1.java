package pro.kensait.java.lambda.functional.consumer;

// 独自の関数型インタフェースConsumerを引数に受け取るAPIを新規作成するケース
public class ConsumerMain1 {

    public static void main(String[] args) {
        new ConsumerMain1().process();
    }

    private void process() {
        // コンソールに出力する（Printerオブジェクトを渡す）
        printSomething("foo", new Printer<String>() {
            @Override
            public void print(String param) {
                System.out.println(param);
            }
        });

        // コンソールに出力する（ラムダ式を渡す）
        printSomething("foo", param -> System.out.println(param));

        // コンソールに出力する（メソッド参照を渡す）
        printSomething("foo", System.out::println);
    }

    private void printSomething(String param, Printer<String> printer) {
        printer.print(param);
    }
}

/* ======================================== */
@FunctionalInterface
interface Printer<T> {
    void print(T t);
}