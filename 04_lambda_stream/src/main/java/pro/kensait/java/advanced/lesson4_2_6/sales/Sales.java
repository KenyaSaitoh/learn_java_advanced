package pro.kensait.java.advanced.lesson4_2_6.sales;

public class Sales {
    private final Integer id;
    private final String productName;
    private final Integer count;

    public Sales(Integer id, String productId, Integer count) {
        this.id = id;
        this.productName = productId;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Sales [id=" + id + ", productName=" + productName + ", count=" + count
                + "]";
    }
}
