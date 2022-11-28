package pro.kensait.java.advanced.lesson9_1_3;

@ElementInfo(value = 101, version = "3.0")
public class Foo {

    @SuppressWarnings("unused")
    @ElementInfo(value = 102, version = "4.0")
    private int field1;
    private int field2;

    @ElementInfo(value = 103, version = "5.0")
    public int getField2() {
        return field2;
    }

    @ElementInfo(value = 104, version = "6.0")
    public void setField2(int field2) {
        this.field2 = field2;
    }
}