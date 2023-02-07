package pro.kensait.java.advanced.lsn_6_2_3.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main_POST_Sync {
    public static void main(String[] args) throws Exception {
        // HttpClientインスタンスを生成する
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // HttpRequestインスタンスを生成する
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("User-Agent", "Java SE HttpClient")
                .POST(HttpRequest.BodyPublishers.ofString("name=Alice"))
                .build();

        // HttpRequestを送信し、HttpResponseを受け取る
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // HttpResponseからステータスを取得する
        int status = response.statusCode();
        System.out.println("[ STATUS ]");
        System.out.println(status);

        // HttpResponseからヘッダを取得する
        HttpHeaders resHeaders = response.headers();
        System.out.println("[ HEADERS ]");
        for (Map.Entry<String, List<String>> entry : resHeaders.map().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get(0));
        }

        // HttpResponseからボディを取り出す
        String resBody = response.body();
        System.out.println("[ BODY ]");
        System.out.println(resBody);
    }
}