package pro.kensait.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMain1 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        MyCommand2 command1 = new MyCommand2(1);
        service.execute(command1);
        MyCommand2 command2 = new MyCommand2(2);
        service.execute(command2);
        MyCommand2 command3 = new MyCommand2(3);
        service.execute(command3);
        MyCommand2 command4 = new MyCommand2(4);
        service.execute(command4);
        MyCommand2 command5 = new MyCommand2(5);
        service.execute(command5);
        MyCommand2 command6 = new MyCommand2(6);
        service.execute(command6);

        try {
            Thread.sleep(10000);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        service.shutdown();

    }
}

/* ======================================== */
class MyCommand2 implements Runnable {

    int info;

    public MyCommand2(int info) {
        this.info = info;
    }

    public void run() {
        System.out.println("MyCommand2 start(" + info + ")");
        try {
            Thread.sleep(10000);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        System.out.println("MyCommand2 End(" + info + ")");
    }
}