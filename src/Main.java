import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://imdb-api.com/en/API/Top250Movies/pk_bajlure"))
                .GET()
                .build();

        // Sincrono

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.version());



        // Assincrono
        /*
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> response.body())
                .thenAccept(body -> System.out.println(body));

        System.out.println("Test");

        Thread.sleep(3000);

         */
    }
}