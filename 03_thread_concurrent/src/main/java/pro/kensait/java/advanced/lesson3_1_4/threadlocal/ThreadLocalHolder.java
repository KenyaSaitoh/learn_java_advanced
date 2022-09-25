package pro.kensait.java.advanced.lesson3_1_4.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalHolder {
    private static ThreadLocal<Map<String, String>> context =
            new ThreadLocal<>() {
        @Override
        public Map<String, String> initialValue() {
            return new HashMap<String, String>();
        }
    };

    public static Map<String, String> get() {
        return context.get();
    }
}