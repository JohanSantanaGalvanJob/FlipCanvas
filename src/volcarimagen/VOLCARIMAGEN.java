package volcarimagen;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
public class VOLCARIMAGEN {  
    public static BufferedImage imagen;  
    public static BufferedImage imagen2;
    public static BufferedImage imagen3; 
    public static BufferedImage imagen4; 
    public static void main(String[] args)
    {
        imagen =new BufferedImage(300,300,TYPE_INT_RGB);
        imagen2 =new BufferedImage(300,300,TYPE_INT_RGB);
        imagen3 =new BufferedImage(300,300,TYPE_INT_RGB); 
        imagen4 =new BufferedImage(429,429,TYPE_INT_RGB); 
        new Ventana();
    }    
}
    

