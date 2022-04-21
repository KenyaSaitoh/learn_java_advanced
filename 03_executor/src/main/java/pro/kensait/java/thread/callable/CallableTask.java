package pro.kensait.java.thread.callable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    public Integer call() throws Exception {
        System.out.println("[ CallableTask#call ] name => " + name);

        // 意図的に5000ミリ秒～15000秒（ランダムに決定）スリープする。
        try {
            sleepRandomTime(5000, 15000);
        } catch(RuntimeException re) {
        }

        return name.length();
    }

    public String getname() {
        return name;
    }
}