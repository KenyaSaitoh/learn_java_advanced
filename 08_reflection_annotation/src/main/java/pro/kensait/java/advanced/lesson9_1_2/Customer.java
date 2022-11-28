package pro.kensait.java.advanced.lesson9_1_2;

public class Customer {
    // フィールド
    private Integer id;
    private String name;
    private GenderType gender;
    private String address;
    // コンストラクタ
    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    // アクセサメソッド
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public GenderType getGender() {
        return gender;
    }
    public void setGender(GenderType gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", gender=" + gender
                + ", address=" + address + "]";
    }
}