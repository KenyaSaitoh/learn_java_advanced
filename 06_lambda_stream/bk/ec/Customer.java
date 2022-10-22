package pro.kensait.java.ec;

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
    void addPoint(Integer point);

    // ���񂹂̂��߂̃`�F�b�N���\�b�h�Ȃ̂ŁA�P����equals�ł͔���ł��Ȃ�
    // ���O�ƏZ������v���Ă�����A�����ڋq�ƌ��Ȃ�
    static boolean isSame(Customer c1, Customer c2) {
        if (c1.getName().equals(c2.getName())
                && c1.getAddress().equals(c2.getAddress())) {
            return true;
        }
        return false;
    }

    static Customer aggregate(Customer c1, Customer c2) {
        c1.setPoint(c1.getPoint() + c2.getPoint());
        c2.setActive(false);
        return c1;
    }
}