import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Fazer uma conexão HTTP e BUSCAR os tops 250 filmes
        String url = "https://imdb-api.com/en/API/top250Movies/k_0ojt0yvm";
        URI adress = URI.create(url);
        var newHttpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(adress).GET().build();
        var response = newHttpClient.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // Extrair só os dados que interessam 
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.Parse(body);

        // Exibir e manipular os dados
        var gen = new StickerGenerator();
        for(Map<String, String> movie: moviesList) {
          String urlImage = movie.get("image");
          String title = movie.get("title");
          InputStream inputStream = new URL(movie.get(urlImage)).openStream();

          String fileName = title + ".png";

          
          gen.Create(inputStream, fileName);

          System.out.println(movie.get("title"));
          System.out.println();
        }
    }
}
