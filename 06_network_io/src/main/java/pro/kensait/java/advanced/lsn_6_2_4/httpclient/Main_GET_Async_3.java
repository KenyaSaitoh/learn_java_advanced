package pro.kensait.java.advanced.lsn_6_2_4.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main_GET_Async_3 {
    public static void main(String[] args) throws Exception {
        // HttpClientインスタンスを生成する
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // HttpRequestインスタンスを生成する
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080?name=Alice"))
                .header("User-Agent", "Java SE HttpClient")
                .build();

        // HttpRequestを送信し、HTTPサーバーを非同期で呼び出す
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response
                        -> "### " + response.body() + " ###") // Function型を受け取る
                .thenAccept(System.out::println); // Consumer型を受け取る

        Thread.sleep(3000);
    }
}