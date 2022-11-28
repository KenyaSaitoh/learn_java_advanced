package pro.kensait.java.advanced.lesson6_1_2.tcp.nonblockingserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Main_NonBlockingServer_bk {
    private static Selector selector;

    public static void main(String[] args) throws Exception {
        try (
                // サーバチャネルをオープンする
                ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            // ノンブロッキングモードに設定する
            serverChannel.configureBlocking(false);

            // ポート番号をバインドする
            serverChannel.bind(new InetSocketAddress(55555));

            // セレクタを作成する
            selector = Selector.open();

            // サーバチャネルに、セレクタと接続処理を登録する
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            int count;
            while (0 < (count = selector.select())) { // ここで受信を待機
                // 準備完了したセレクトキーの集合を取得する
                Iterator<SelectionKey> keyIterator = selector.selectedKeys()
                        .iterator();

                while (keyIterator.hasNext()) {
                    // 準備完了したセレクトキーを取り出す
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (key.isAcceptable()) {
                        // 接続処理の準備が完了していた場合
                        accept(key);
                    }

                    if (key.isReadable()) {
                        // 読み込み処理の準備が完了していた場合
                        read(key);
                    }

                    if (key.isWritable()) {
                        // 書き込み処理の準備が完了していた場合
                        write(key);

                        // クライアントとの接続をクローズする
                        key.channel().close();
                    }
                }
                System.out.println("selector's count => " + count);
            }
        }
    }

    // クライアント接続処理
    private static void accept(SelectionKey key) throws IOException {
        System.out.println("[ Server#accept ] start");

        ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
        SocketChannel clientChannel = ssc.accept();

        // ノンブロッキングモードに設定する
        clientChannel.configureBlocking(false);

        // 新しいByteBufferを割り当てる
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        // クライアントチャネルに、セレクタ、読み込み処理、ByteBufferを登録する
        clientChannel.register(selector, SelectionKey.OP_READ, buffer);

        System.out.println("[ Server#accept ] finish");
    }

    // 読み込み処理
    private static void read(SelectionKey key) throws IOException {
        System.out.println("[ Server#read ] start");

        // セレクトキーからクライアントチャネルを取得する
        SocketChannel clientChannel = (SocketChannel) key.channel();

        // セレクトキーにアタッチされたByteBufferを取得する
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        // クライアントチャネルからByteBufferにデータを読み込む
        clientChannel.read(buffer);

        // クライアントチャネルに、セレクタ、書き込み処理、ByteBufferを登録する
        clientChannel.register(selector, SelectionKey.OP_WRITE, buffer);

        System.out.println("[ Server#read ] finish");
    }

    // 書き込み処理
    private static void write(SelectionKey key) throws IOException {
        System.out.println("[ Server#write ] start");

        // セレクトキーからクライアントチャネルを取得する
        SocketChannel clientChannel = (SocketChannel) key.channel();

        // セレクトキーにアタッチされたByteBufferを取得する
        ByteBuffer buffer = (ByteBuffer) key.attachment();

        // ByteBufferの読み込み位置を0に設定する
        buffer.flip();

        // ByteBufferからデータを取り出し、何らかの業務処理を行う
        Charset charset = StandardCharsets.UTF_8;
        String request = charset.decode(buffer).toString();
        String response = "Hello! 私は" + request + "です";
        //sleepAWhile(3000);
        System.out.println("[ Server#write ] response => " + response);

        // 書き込みのためにByteBufferをクリアする
        buffer.clear();

        // クライアントチャネルにByteBufferからデータを書き込む
        buffer = charset.encode(response);
        clientChannel.write(buffer);

        // クライアントチャネルに、セレクタ、次の読み込み処理、ByteBufferを登録する
        //clientChannel.register(selector, SelectionKey.OP_READ, buffer);

        System.out.println("[ Server#write ] finish");
    }
}