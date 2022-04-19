package org.study.se.thread.executor;

import org.study.se.thread.util.ThreadUtil;

public class MyCommand implements Runnable {

    private String name;

    public MyCommand(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("[ MyCommand#run ] Start (" + name + ")");

        // 意図的に3000ミリ秒～20000秒（ランダムに決定）スリープする。
        try {
            ThreadUtil.sleepRandomTime(3000, 20000);
        } catch(RuntimeException re) {
        }

        System.out.println("[ MyCommand#run ] End (" + name + ")");
    }

    public String getValue() {
        return name;
    }
}