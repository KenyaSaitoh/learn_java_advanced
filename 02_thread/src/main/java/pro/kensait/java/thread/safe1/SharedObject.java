package pro.kensait.java.thread.safe1;

import pro.kensait.java.thread.util.ThreadUtil;

public class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    // dataフィールドへの更新処理。
    // この処理は「アトミックな処理」ではないため、本来は
    // synchronizedキーワードによってこのメソッドを全体を同期化する必要がある。
    public void addData(int num) {
        int tmp = this.data + num;
        ThreadUtil.sleepAWhile(10); // 追い抜きのチャンス
        this.data = tmp;
    }

    public int getData() {
        return data;
    }
}
