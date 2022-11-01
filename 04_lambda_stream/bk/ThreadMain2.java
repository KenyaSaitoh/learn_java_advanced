package pro.kensait.java.lesson6_1_3.closure;

public class ThreadMain2 {

    public static void main(String[] args) {
        Runnable r = () -> {
            // MyRunnableクラスのcountフィールドや変数strにアクセスしたいが、
            // ラムダ式を外から渡す場合は、外側クラスのフィールドやローカル変数をキャプチャすることはできない
            for (int i = 0; i < 10; i++) {
                System.out.println("### " + i + " ###");
            }
        };
        new MyRunnable(10).process(r);
    }
}

class MyRunnable {
    private int count;

    public MyRunnable(int count) {
        this.count = count;
    }

    public void process(Runnable r) {
        String str = "###";
        r.run();
    }
}