package pro.kensait.java.advanced.lesson8_2_2;

public class BarImpl implements Bar {
    //
    public int doSomething(int param) {
        System.out.println("[ BarImpl#doSomething ] Start");
        System.out.println("[ BarImpl#doSomething ] param => " + param);
        System.out.println("[ BarImpl#doSomething ] End");
        return param * param;
    }
}