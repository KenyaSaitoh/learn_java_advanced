package pro.kensait.java.advanced.network.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main_GET_Sync {
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

        // HTTPリクエストを送信し、HTTPレスポンスを受け取る［③］
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // HTTPレスポンスからメッセージを取り出し、表示する［④］
        int status = response.statusCode();
        System.out.println("[ STATUS ]");
        System.out.println(status);

        // HTTPレスポンスからメッセージを取り出し、表示する［⑤］
        HttpHeaders resHeaders = response.headers();
        System.out.println("[ HEADERS ]");
        for (Map.Entry<String, List<String>> entry : resHeaders.map().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(0));
        }

        // HTTPレスポンスからボディを取り出し、表示する［⑥］
        String resBody = response.body();
        System.out.println("[ BODY ]");
        System.out.println(resBody);
    }
}