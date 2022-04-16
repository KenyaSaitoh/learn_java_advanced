package pro.kensait.java.pattern.thread.notify;

public class ReadTask extends Thread {

    private SharedObject share;

    public ReadTask(SharedObject share, String str) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadTask#run ] Start");
        System.out.println("[ ReadTask#run ] Call ReadProcess");
        int result = share.readProcess();
        System.out.println("[ ReadTask#run ] End / result ---> " + result);
    }
}
