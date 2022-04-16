package pro.kensait.java.pattern.thread.readwritelock;

public class ReadTask extends Thread {

    private SharedObject share;

    public ReadTask(SharedObject share) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadTask#run ] Start");
        int result = share.readProcess();
        System.out.println("[ ReadTask#run ] result ---> " + result);
    }
}
