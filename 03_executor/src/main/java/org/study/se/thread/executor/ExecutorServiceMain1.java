package org.study.se.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMain1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        MyCommand command1 = new MyCommand("1");
        executor.execute(command1);

        MyCommand command2 = new MyCommand("2");
        executor.execute(command2);

        MyCommand command3 = new MyCommand("3");
        executor.execute(command3);

        MyCommand command4 = new MyCommand("4");
        executor.execute(command4);

        MyCommand command5 = new MyCommand("5");
        executor.execute(command5);

        MyCommand command6 = new MyCommand("6");
        executor.execute(command6);
    }
}