package pro.kensait.java.thread.readwritelock;

public class WriteTask extends Thread {

    private SharedObject share;
    private int param;

    public WriteTask(SharedObject share, int param) {
        this.share = share;
        this.param = param;
    }

    public void run() {
        System.out.println("[ WriteTask#run ] Start");
        share.writeProcess(param);
    }
}
