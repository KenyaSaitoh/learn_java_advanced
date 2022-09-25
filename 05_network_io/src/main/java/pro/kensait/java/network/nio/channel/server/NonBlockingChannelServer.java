package pro.kensait.java.network.nio.channel.server;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NonBlockingChannelServer {
    private static Selector selector;
    private static final int PORT = 55555;
    private static final int BUF_SIZE = 1000;

    public static void main(String[] args) throws Exception {
        try (
                // サーバチャネルをオープンする
                ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            // ノンブロッキングモードに設定する
            serverChannel.configureBlocking(false);

            // ポート番号をバインドする
            serverChannel.bind(new InetSocketAddress(PORT));

            // セレクタを作成する
            selector = Selector.open();

            // サーバチャネルに、セレクタと接続処理を登録する
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                // セレクタからチャネルを選択する（ここで受信を待機）
                selector.select();

                // 準備完了したセレクトキーの集合を取得する
                Iterator<SelectionKey> keyIterator = selector.selectedKeys()
                        .iterator();

                while (keyIterator.hasNext()) {
                    // 準備完了したセレクトキーを取り出す
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 接続処理の準備が完了していた場合
                        accept(serverChannel, selector);
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
            }
        }
    }

    // クライアント接続処理
    private static void accept(ServerSocketChannel serverChannel, Selector selector)
            throws IOException {
        System.out.println("[ Server#accept ] start");

        // クライアントチャネルを取得する
        SocketChannel clientChannel = serverChannel.accept();
        if (clientChannel == null) {
            System.out.println("[ Server#accept ] clientChannel => null");
            return;
        }

        // ノンブロッキングモードに設定する
        clientChannel.configureBlocking(false);

        // 新しいByteBufferを割り当てる
        ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE);

        // クライアントチャネルに、セレクタ、読み込み処理、ByteBufferを登録する
        clientChannel.register(selector, SelectionKey.OP_READ, buffer);

        System.out.println("[ Server#accept ] Finish");
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

        System.out.println("[ Server#read ] Finish");
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
        Charset charset = Charset.forName("UTF-8");
        String request = charset.decode(buffer).toString();
        String response = "Hello! 私は" + request + "です。";
        System.out.println("[ Server#write ] response => " + response);
        sleepAWhile(5000);

        // 書き込みのためにByteBufferをクリアする
        buffer.clear();

        // クライアントチャネルにByteBufferからデータを書き込む
        buffer = charset.encode(CharBuffer.wrap(response));
        clientChannel.write(buffer);

        // クライアントチャネルに、セレクタ、次の読み込み処理、ByteBufferを登録する
        clientChannel.register(selector, SelectionKey.OP_READ, buffer);

        System.out.println("[ Server#write ] Finish");
    }
}