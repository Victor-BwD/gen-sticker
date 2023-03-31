import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;



public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e BUSCAR os tops 250 filmes
        //String url = "https://imdb-api.com/en/API/top250Movies/k_0ojt0yvm";
        //ContentExtract extract = new IMDBContentExtract();

        String url = "https://api.nasa.gov/planetary/apod?api_key=JQ9ozRAf4SWFdfxKbO6krjOuwM1Sq0pwU9xtqT2Q";
        ContentExtract extract = new NasaContentExtract();


        var http = new ClientHTTP();
        String json = http.SearchData(url);

        // Exibir e manipular os dados
        List<Content> contents = extract.contentExtract(json);
        var gen = new StickerGenerator();

        for(int i = 0; i < 3; i++) {
          Content content = contents.get(i);  
          
          InputStream inputStream = new URL((content.getUrlImage())).openStream();

          String fileName = "saida/" + content.getTitle() + ".png";

          gen.Create(inputStream, fileName);

          System.out.println(content.getTitle());
          System.out.println();
        }
    }
}
