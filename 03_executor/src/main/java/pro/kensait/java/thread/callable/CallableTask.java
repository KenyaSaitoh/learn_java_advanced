package pro.kensait.java.thread.callable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private String property;

    public CallableTask(String property) {
        this.property = property;
    }

    public Integer call() throws Exception {
        System.out.println("[ CallableTask#call ] property => " + property);

        // 意図的に5000ミリ秒～15000ミリ秒（ランダムに決定）スリープする
        try {
            sleepRandomTime(5000, 15000);
        } catch(RuntimeException re) {
        }

        // 結果を返す
        return property.length();
    }
}