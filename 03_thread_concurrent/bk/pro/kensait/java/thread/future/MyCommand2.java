package pro.kensait.java.thread.future;

import java.util.concurrent.Callable;

import pro.kensait.java.thread.util.ThreadUtil;

public class MyCommand2 implements Callable<String> {

    private String property;

    public MyCommand2(String property) {
        this.property = property;
    }

    public String call() throws Exception {
        System.out.println("[ MyComman2d#run ] start (" + property + ")");

        // 意図的に3000ミリ秒～20000秒（ランダムに決定）スリープする
        try {
            ThreadUtil.sleepRandomTime(3000, 20000);
        } catch(RuntimeException re) {
        }

        throw new Exception("Exception in command");
    }

    public String getValue() {
        return property;
    }
}