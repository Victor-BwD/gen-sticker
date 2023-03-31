import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtract implements ContentExtract {
  public List<Content> contentExtract (String json)  {
    // Extrair só os dados que interessam 
    JsonParser parser = new JsonParser();
    List<Map<String, String>> AtributtesList = parser.Parse(json);

    List<Content> contents = new ArrayList<>();

    for (Map<String, String> atributtes : AtributtesList) {
      String title = atributtes.get("title");
      String urlImage = atributtes.get("url");
      var content = new Content(title, urlImage);

      contents.add(content);
    }

    return contents;
  }
}
