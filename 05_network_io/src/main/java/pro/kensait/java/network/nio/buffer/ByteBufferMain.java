package pro.kensait.java.network.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferMain {

    public static void main(String[] args) {
        //1024バイトのバッファを持つByteBufferを生成する
        ByteBuffer buffer = ByteBuffer.allocate(100);

        // 書き込む値を変数にセットする
        int val1 = 10; // 4バイト
        long val2 = 1000L; // 8バイト
        String str = "ABCDEFGHIJKLMN"; // 14バイト

        // 数値（int型）をByteBufferに書き込む
        buffer.putInt(val1);

        // 数値（long型）をByteBufferに書き込む
        buffer.putLong(val2);

        // 文字列からバイト列を生成し、ByteBufferに書き込む
        byte[] b = str.getBytes(StandardCharsets.UTF_8);
        buffer.put(b);

        // ByteBufferの読み込み位置を0に設定する
        buffer.flip();

        // 最初に書き込んだ数値（int型）を取り出して表示する（0バイト目から4バイト分）
        System.out.println("最初の数値 => " + buffer.getInt());
        // ByteBufferの残りバイト数を表示する
        System.out.println("残りバイト => " + buffer.remaining());

        // 2度目に書き込んだ数値（long型）を取り出して表示する（4バイト目から8バイト分）
        System.out.println("2度目の数値 => " + buffer.getLong());
        // ByteBufferの残りバイト数を表示する
        System.out.println("残りバイト => " + buffer.remaining());

        // 次に書き込んだバイト列から文字列をデコードし、表示する（11バイト目から14バイト分）
        String str2 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println("次の文字列 => " + str2);
        // ByteBufferの残りバイト数を表示する
        System.out.println("残りバイト => " + buffer.remaining());

        // ByteBufferの読み込み位置を4バイト目に設定する
        buffer.position(4);

        // 2度目に書き込んだ数値（long型）を取り出して表示する（4バイト目から8バイト分）
        System.out.println("2度目の数値 => " + buffer.getLong());
        // ByteBufferの残りバイト数を表示する
        System.out.println("残りバイト => " + buffer.remaining());
    }
}