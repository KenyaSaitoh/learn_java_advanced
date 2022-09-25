package pro.kensait.java.thread.safe2;

import static pro.kensait.java.thread.util.ThreadUtil.*;

public class SharedObject {

    private int data;

    public SharedObject(int data) {
        this.data = data;
    }

    // dataフィールドへの更新処理。
    // この処理は「アトミックな処理」ではないため、
    // synchronizedキーワードによってこのメソッドを同期化する必要がある。
    synchronized public void addData(int num) {
        int tmp = this.data + num;
        sleepAWhile(10); // 「割り込み」のチャンス
        this.data = tmp;
    }

    public int getData() {
        return data;
    }
}