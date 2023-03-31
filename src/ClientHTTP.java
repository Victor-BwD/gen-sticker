import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHTTP {
  public String SearchData(String url) {
    try{
      URI adress = URI.create(url);
      var newHttpClient = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(adress).GET().build();
      var response = newHttpClient.send(request, BodyHandlers.ofString());
      String body = response.body();
      return body;
    }catch(IOException | InterruptedException ex) {
      throw new RuntimeException(ex);
    }

    
  }
}
