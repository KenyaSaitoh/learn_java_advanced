package pro.kensait.java.thread.timer;

public class TimerMain {

    boolean stopFlag = false;

    public static void main(String[] args) {
        System.out.println("TimerMain ---> Start");
        new TimerMain().method();
    }

    private void method() {
        TimerThread timer = new TimerThread(this, 10000);
        timer.start();
        while (!stopFlag) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("TimerMain ---> Executed");
        }
        System.out.println("TimerMain ---> End");
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }
}

/* ======================================== */
class TimerThread extends Thread {

    TimerMain client;
    int timer;

    public TimerThread(TimerMain client, int timer) {
        this.client = client;
        this.timer = timer;
    }

    public void run() {
        System.out.println("TimerThread ---> Start Watching...");
        try {
            Thread.sleep(timer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TimerThread ---> Time Over!!!");
        client.setStopFlag(true);
    }
}