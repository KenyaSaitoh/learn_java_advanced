package pro.kensait.java.thread.pruning;

public class ReadTask extends Thread {

    private SharedObject share;

    public ReadTask(SharedObject share, String str) {
        this.share = share;
    }

    public void run() {
        System.out.println("[ ReadTask#run ] start");
        System.out.println("[ ReadTask#run ] Call ReadProcess");
        int result = share.readProcess();
        System.out.println("[ ReadTask#run ] finish / result => " + result);
    }
}
