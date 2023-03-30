

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {

  public void Create(InputStream inputStream, String fileName) throws Exception {
    // leitura da imagem
    //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")))
    //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_.jpg").openStream();
    var originalImage = ImageIO.read(inputStream);

    // cria uma nova imagem em memória com transparencia
    var width = originalImage.getWidth();
    var height = originalImage.getHeight();
    var newHeight = height + 200;
    var newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra nova imagem
    var graphics = (Graphics2D)newImage.getGraphics();
    graphics.drawImage(originalImage, null, 0, 0);

    // configurar fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.yellow);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", width - 850, (newHeight - 100));

   

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File(fileName));
  }
}
