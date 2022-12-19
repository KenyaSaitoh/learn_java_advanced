package pro.kensait.java.advanced.lsn_6_1_2.tcp.server;

import static pro.kensait.java.advanced.common.ThreadUtil.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Main_SingleServer {
    public static void main(String[] args) {
        try (
                // ServerSocketChannelをオープンする
                ServerSocketChannel ssc = ServerSocketChannel.open()) {

            // ソケットアドレス（ポート番号）をバインドする
            ssc.bind(new InetSocketAddress(55555));

            while (true) {
                System.out.println("start accept");
                System.out.println("waiting...");
                SocketChannel socketChannel = ssc.accept(); // ここで受信を待機する
                readAndWrite(socketChannel);
                System.out.println("finish accept");
            }

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static void readAndWrite(SocketChannel socketChannel) {
        System.out.println("start process");

        // 新しいByteBufferを割り当てる（リクエスト用、レスポンス用）
        ByteBuffer requestBuffer = ByteBuffer.allocate(1000);
        ByteBuffer responseBuffer = ByteBuffer.allocate(1000);

        try {
            // SocketChannelからByteBufferにデータを読み込む
            System.out.println("waiting...");
            socketChannel.read(requestBuffer);// ここで読み込みを待機する

            // ByteBufferをフリップする
            requestBuffer.flip();

            // リクエストをByteBufferからデコードし、何らかの業務処理を行う
            String request = StandardCharsets.UTF_8.decode(requestBuffer).toString();
            String response = "Hello! 私は" + request + "です";
            sleepAWhile(2000);

            // レスポンスをByteBufferに追加する
            responseBuffer = StandardCharsets.UTF_8.encode(response);

            // SocketChannelにByteBufferからデータを書き込む
            socketChannel.write(responseBuffer);
            System.out.println("response => " + response);

            // SocketChannelをクローズする
            socketChannel.close();

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }

        System.out.println("finish process");
    }
}