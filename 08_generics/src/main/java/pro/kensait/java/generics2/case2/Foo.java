package pro.kensait.java.generics2.case2;

public class Foo {
    private Object target;

    /*
    このように、クラスではなくメソッドやコンストラクタの前に総称型の宣言を
    することもできる。
    ※「パラメータ化されたメソッド宣言」
    ※「パラメータ化されたコンストラクタ宣言」
    ただしこの場合は、パラメータ化された型をフィールドに持つことができない
    ので、メソッドの中で閉じるする処理しか考えられずあまり使う意味がない。
    これの意味が生じてくるのは、ワイルドカードを引数・戻り値に使うとき。
    */
    public <T> Foo(T target) {
        this.target = target;
    }

    public <T> Object getTarget() {
        return this.target;
    }

    public <T> void setTarget(T target) {
        this.target = target;
    }
}