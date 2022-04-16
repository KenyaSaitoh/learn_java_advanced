package pro.kensait.java.thread.join;

public class ResultGettableTask extends Thread {

    int timer;
    String result;

    public ResultGettableTask(int timer) {
        this.timer = timer;
    }

    public void run() {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        result = "Task is done!";
    }

    public String getResult() {
        return result;
    }
}
