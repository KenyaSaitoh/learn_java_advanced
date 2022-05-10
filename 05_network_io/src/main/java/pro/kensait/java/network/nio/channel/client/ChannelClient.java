package pro.kensait.java.network.nio.channel.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ChannelClient {

    public static void main(String[] args) {
        new Thread(new ChannelClientThread("Alice")).start();
        new Thread(new ChannelClientThread("Bob")).start();
        new Thread(new ChannelClientThread("Carol")).start();
    }
}

/* ======================================== */
class ChannelClientThread implements Runnable {
    private String request;
    private static final int PORT = 55555;
    private static final int BUF_SIZE = 1000;

    public ChannelClientThread(String request) {
        this.request = request;
    }

    public void run() {
        // ByteBufferを作成する
        ByteBuffer requestBuffer = ByteBuffer.allocate(BUF_SIZE);
        ByteBuffer responseBuffer = ByteBuffer.allocate(BUF_SIZE);
        Charset charset = Charset.forName("UTF-8");
        requestBuffer = charset.encode(CharBuffer.wrap(request));
        String response = null;

        try (
                // クライアントチャネルをオープンする
                SocketChannel clientChannel = SocketChannel.open(
                        new InetSocketAddress("localhost", PORT))) {

            // リクエストを書き込む
            System.out.println("[ Client ] Send request");
            clientChannel.write(requestBuffer);
            requestBuffer.clear();

            // レスポンスを読み込む
            System.out.println("[ Client ] Receive response");
            clientChannel.read(responseBuffer);
            response = new String(responseBuffer.array(), charset);
            responseBuffer.clear();

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        // コンソールに出力する
        System.out.println("[ Client ] response => " + response);
    }
}