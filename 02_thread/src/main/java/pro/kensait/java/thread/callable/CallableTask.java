package pro.kensait.java.thread.callable;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

    private String param;

    public CallableTask(String param) {
        this.param = param;
    }

    public Integer call() throws Exception {
        System.out.println("[ CallableTask#call ] param ---> " + param);

        // 意図的に5000ミリ秒～15000秒（ランダムに決定）スリープする。
        try {
            sleepRandomTime(5000, 15000);
        } catch(RuntimeException re) {
        }

        return param.length();
    }

    public String getParam() {
        return param;
    }
}