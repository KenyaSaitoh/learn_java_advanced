package pro.kensait.java.thread.immutable;

public class SharedObject {

    private final int data;

    public SharedObject(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
