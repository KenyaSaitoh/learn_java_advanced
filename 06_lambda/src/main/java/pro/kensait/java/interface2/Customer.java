package pro.kensait.java.interface2;

public interface Customer {
    Integer getId();
    void setId(Integer id);
    String getName();
    void setName(String name) ;
    Integer getCustomerType();
    void setCustomerType(Integer customerType);
    String getAddress() ;
    void setAddress(String address) ;
    Integer getPoint();
    void setPoint(Integer point);
    boolean isActive();
    void setActive(boolean flag);
    void checkTotalPriceLimit(Integer totalPrice) throws Exception;
    abstract void addPoint(Integer point);

    static boolean isSame(Customer c1, Customer c2) {
        return c1.equals(c2);
    }

    static Customer aggregate(Customer c1, Customer c2) {
        c1.setPoint(c1.getPoint() + c2.getPoint());
        c2.setActive(false);
        return c1;
    }
}