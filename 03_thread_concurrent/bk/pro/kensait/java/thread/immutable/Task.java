package pro.kensait.java.thread.immutable;

public class Task extends Thread {

    private String property;

    public Task(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
    
    public void run() {
        for(int i = 0; i < 10; i++) {
            property = property + "!";
        }
    }
}