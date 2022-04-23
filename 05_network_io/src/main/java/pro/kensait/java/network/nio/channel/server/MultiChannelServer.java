package pro.kensait.java.network.nio.channel.server;

import static pro.kensait.java.thread.util.ThreadUtil.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MultiChannelServer {
    private static final int PORT = 55555;

    public static void main(String[] args) throws Exception {
        try (
                // サーバチャネルをオープンする
                ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            // ポート番号をバインドする
            serverChannel.bind(new InetSocketAddress(PORT));

            while (true) {
                System.out.println("[ Server ] Start accept");
                SocketChannel clientChannel = serverChannel.accept(); // ここで受信を待機する
                new Thread(new ServerThread(clientChannel)).start();
                System.out.println("[ Server ] Finish accept");
            }
        }
    }
}

/* ======================================== */
class ServerThread implements Runnable {
    private static final int BUF_SIZE = 1000;
    private SocketChannel clientChannel;

    public ServerThread(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    public void run() {
        System.out.println("[ Server ] Start thread");

        // リクエスト用のByteBufferを作成する
        ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE);
 
        try {
            // クライアントチャネルからByteBufferにデータを読み込む
            clientChannel.read(buffer);

            // ByteBufferからデータを取り出し、何らかの業務処理を行う
            Charset charset = Charset.forName("UTF-8");
            String request = new String(buffer.array(), charset);
            String response = "!!!!!!!!!!" + request;
            sleepAWhile(5000);
            System.out.println("[ Server ] response => " + response);

            // ByteBufferの読み込み位置を0に設定する
            buffer.flip();

            // クライアントチャネルにByteBufferからデータを書き込む
            buffer = charset.encode(CharBuffer.wrap(response));
            clientChannel.write(buffer);

            // ByteBufferをクリアする
            buffer.clear();

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }

        System.out.println("[ Server ] Finish thread");
    }
}