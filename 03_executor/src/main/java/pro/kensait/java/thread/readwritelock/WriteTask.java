package pro.kensait.java.thread.readwritelock;

public class WriteTask extends Thread {

    private SharedObject share;
    private int name;

    public WriteTask(SharedObject share, int name) {
        this.share = share;
        this.name = name;
    }

    public void run() {
        System.out.println("[ WriteTask#run ] Start");
        share.writeProcess(name);
    }
}
