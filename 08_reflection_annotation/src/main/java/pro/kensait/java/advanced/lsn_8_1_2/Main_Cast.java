package pro.kensait.java.advanced.lsn_8_1_2;

public class Main_Cast {
    public static void main(String[] args) throws Exception {
        Integer val1 = 100;
        Object obj = val1;
        // Integer val2 = (Integer) obj;
        Integer val2 = Integer.class.cast(obj);
    }
}