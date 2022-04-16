package pro.kensait.java.pattern.thread.safe;

import pro.kensait.java.thread.util.ThreadUtil;

public class SharedObject {

    private int data = 0;

    // dataフィールドへの更新処理。
    // この処理は「アトミックな処理」ではないため、synchronizedキーワードによって
    // このメソッドを全体を同期化する必要がある。
    public synchronized void addData(int x) {
        int y = this.data;
        ThreadUtil.sleepRandomTime(0, 10);
        y = y + x;
        this.data = y;
    }

    public int getData() {
        return data;
    }
}
