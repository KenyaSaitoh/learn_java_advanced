package pro.kensait.java.advanced.lsn_6_1_2.udp.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Main_SingleServer {
    public static void main(String[] args) {
        // 新しいByteBufferを割り当てる（リクエスト用）
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        try (
                // DatagramChannelをオープンする
                DatagramChannel channel = DatagramChannel.open()) {

            // ソケットアドレス（ポート番号）をバインドする
            channel.bind(new InetSocketAddress(55555));

            while (true) {
                // 受信を待機する
                channel.receive(buffer);

                // ByteBufferをフリップする
                buffer.flip();

                // リクエストをByteBufferから取り出す
                String request = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("Hello! 私は" + request + "です");
            }

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}