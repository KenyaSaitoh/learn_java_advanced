package pro.kensait.java.advanced.lsn_6_2_1.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Main_GET_Async_1 {
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
        CompletableFuture<HttpResponse<String>> future =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // 非同期でHttpResponseを受け取る
        HttpResponse<String> response = future.get();

        // HttpResponseからボディを取り出す
        String resBody = response.body();
        System.out.println(resBody);
    }
}