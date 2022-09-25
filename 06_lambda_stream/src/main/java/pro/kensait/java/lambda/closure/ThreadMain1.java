package pro.kensait.java.lambda.closure;

public class ThreadMain1 {
    private int count;

    public ThreadMain1(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        new ThreadMain1(10).process1();
        new ThreadMain1(10).process2();
    }

    private void process1() {
        String str = "###";
        // スレッドを生成し、起動する
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // 無名クラス内から外側クラスのフィールドやローカル変数をキャプチャすることができる
                for (int i = 0; i < count; i++) {
                    System.out.println(str + " " + i + " " + str);
                }
            }
        };
        r.run();
    }
    
    private void process2() {
        String str = "###";
        // スレッドを生成し、起動する
        Runnable r = () -> {
            // ラムダ式内から外側クラスのフィールドやローカル変数をキャプチャすることができる
            for (int i = 0; i < count; i++) {
                System.out.println(str + " " + i + " " + str);
            }
        };
        r.run();
    }
}