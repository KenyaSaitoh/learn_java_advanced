package pro.kensait.java.ec;

public class Customers {
    public static boolean isSame(Customer c1, Customer c2) {
        return c1.equals(c2);
    }

    public static Customer aggregate(Customer c1, Customer c2) {
        c1.setPoint(c1.getPoint() + c2.getPoint());
        c2.setActive(false);
        return c1;
    }
}