package pro.kensait.java.advanced.lesson9_1_2;

public class Person {
    // フィールド
    private String name;
    private int age;
    private GenderType gender;
    private String address;
    // コンストラクタ
    public Person(String name, int age, GenderType gender, String address) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    // アクセサメソッド
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender
                + ", address=" + address + "]";
    }
}