package pro.kensait.java.advanced.network.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main_GET_Async3 {
    public static void main(String[] args) throws Exception {
        // HttpClientを生成する［①］
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // HttpRequestを生成する［②］
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/myserver?name=Alice"))
                .header("User-Agent", "Java SE HttpClient")
                .build();

        // リクエストを非同期で送信する［③］
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response
                        -> "### " + response.body() + " ###") // Function型を受け取る［④］
                .thenAccept(System.out::println); // Consumer型を受け取る［⑤］

        Thread.sleep(3000);
    }
}