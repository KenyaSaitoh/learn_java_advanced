package pro.kensait.java.generics.ext;

public class Hoge<T extends Number> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public void execute() {
        System.out.println("[ Hoge#execute ] Start");
        // 総称型TはNumberのサブクラスなので、Numberで定義されているメソッドを
        // キャストすることなく呼び出すことができる。
        object.byteValue();
        System.out.println("[ Hoge#execute ] End");
    }
}