package volcarimagen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import static sun.jvm.hotspot.HelloWorld.e;
import static volcarimagen.VOLCARIMAGEN.imagen;
import static volcarimagen.VOLCARIMAGEN.imagen2;
import static volcarimagen.VOLCARIMAGEN.imagen3;
import static volcarimagen.VOLCARIMAGEN.imagen4;

public class Dibujo extends Canvas {
    Ventana v;
    int angulo;
    int azar(int x) {
        return (int) Math.floor(Math.random() * x);
    }

    boolean repaint = false;
    Graphics g;
    boolean click;
    boolean click2;
    boolean click3;

    public Dibujo() {
        setSize(1200, 700);
        this.setBackground(Color.black);
        this.repaint();
        click = true;
        click2 = true;
        click3=true;
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D k;
        this.g = g;
        k = (Graphics2D) imagen.getGraphics();
        if (click == true) {
            int t, x, y;
            double a = 0; //ángulo     
            int xa, ya;
            int radio = 50;
            int lados = 5;
            xa = radio;
            ya = 0;
            for (t = 0; t <= lados; t++) {
                a += ((double) 360 / lados) * Math.PI / 180;
                x = (int) (radio * Math.cos(a));
                y = (int) (radio * Math.sin(a));
                k.drawLine(radio + xa, radio + ya, radio + x, radio + y);
                k.drawLine(radio + xa + 150, radio + ya + 150, radio + x + 150, radio + y + 150);
                xa = x;
                ya = y;
            }
            if (!repaint) {
                for (int s = 1; s < 10000; s++) {
                    imagen.setRGB(azar(300), azar(300), 0x0000ff);
                }
                repaint = true;
            }

        } else if (click == false) {
            int p;

            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                    p = imagen.getRGB(i, j);
                    imagen2.setRGB(299 - i, j, p);
                }
            }
            this.g.drawImage(imagen2, 300, 0, null);
        } 
         
        if (click2 == false) {
            int a;

            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                    a = imagen.getRGB(i, j);
                    imagen3.setRGB(i, 299 - j, a);
                }
            }
            this.g.drawImage(imagen3, 0, 300, null);
        }
        
        if (click3 == false) {
          
            int q;
            //Borrar Imagen4
            for (int i = 0; i < 429; i++) {
                for (int j = 0; j < 429; j++) {
                    imagen4.setRGB(i,j, 0x000000);
                }
                }
          //Rotacion
            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                      try{
                            
                    q = imagen.getRGB(i, j);
                  
                    double ang=angulo*Math.PI/180;
                    double x1=i-300/2;
                    double y1=j-300/2;
                    
                    double x3=Math.round(x1*Math.cos(ang)-y1*Math.sin(ang)+429/2);
                    double y3=Math.round(x1*Math.sin(ang)+y1*Math.cos(ang)+429/2);
                    //double x3=Math.round(x2+429/2);
                    //double y3=Math.round(y2+429/2);
                      
                    imagen4.setRGB((int)x3,(int)y3, q);
                    
                    repaint=true;
                    
                      
                    }catch(Exception e){}
                }
            }
            this.g.drawImage(imagen4, 700, 250, null);
            
        }
        g.drawImage(imagen, 0, 0, null);
    }

    public boolean isClick2() {
        return click2;
    }

    public void setClick2(boolean click2) {
        this.click2 = click2;
    }

    public boolean isClick() {
        return click;
    }

    public void setClick(boolean click) {
        this.click = click;
    }

    public boolean isClick3() {
        return click3;
    }

    public void setClick3(boolean click3) {
        this.click3 = click3;
    }

}
