package pro.kensait.java.thread.futuretask;

import java.util.concurrent.Callable;

import pro.kensait.java.thread.util.ThreadUtil;

public class MyCommand implements Callable<String> {

    private String property;

    public MyCommand(String property) {
        this.property = property;
    }

    public String call() throws Exception {
        System.out.println("[ MyCommand#run ] start (" + property + ")");

        // 意図的に3000ミリ秒～20000秒（ランダムに決定）スリープする。
        try {
            ThreadUtil.sleepRandomTime(3000, 20000);
        } catch(RuntimeException re) {
        }

        System.out.println("[ MyCommand#run ] End (" + property + ")");
        return "MyCommand(" + property + ") is finished";
    }

    public String getValue() {
        return property;
    }
}