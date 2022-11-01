package pro.kensait.java.thread.pruning;

public class ThreadResultMain {

    public static void main(String[] args) {
        ResultGettableTask task = new ResultGettableTask(3000);
        task.start();

        try {
            // t1とジョインする。
            task.join();
            System.out.println("===== THREAD 1 finish =====");
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }

        System.out.println(task.getResult());
    }
}
