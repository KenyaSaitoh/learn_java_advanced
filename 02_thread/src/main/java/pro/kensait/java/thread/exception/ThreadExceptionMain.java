package pro.kensait.java.thread.exception;

public class ThreadExceptionMain {

    public static void main(String[] args) {
        System.out.println("[ ThreadExceptionMain ] Start");
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        try {
            t.start();
        } catch(RuntimeException re) {
            System.out.println("Catch Exception in Main Method ---> " +
                    re.getMessage());
        }
        System.out.println("[ ThreadExceptionMain ] End");
    }
}

/* ======================================== */
class MyRunnable implements Runnable {

    public void run() {
        System.out.println("[ MyRunnable#run ] Start");
        throw new RuntimeException("Exception in Thread");
    }
}