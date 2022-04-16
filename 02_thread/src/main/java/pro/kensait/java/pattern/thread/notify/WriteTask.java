package pro.kensait.java.pattern.thread.notify;

public class WriteTask extends Thread {

    private SharedObject share;

    public WriteTask(SharedObject share, String str) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ WriteTask#run ] Start");
        System.out.println("[ WriteTask#run ] Call WriteProcess");
        share.writeProcess();
        System.out.println("[ WriteTask#run ] End");
    }
}
