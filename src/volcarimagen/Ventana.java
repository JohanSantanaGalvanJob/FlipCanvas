package volcarimagen;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import static volcarimagen.VOLCARIMAGEN.imagen2;
import static volcarimagen.VOLCARIMAGEN.imagen;

public class Ventana extends JFrame {

    Dibujo d;
    JButton VoltearH;
    JButton VoltearV;
    JButton Rotar;
    JTextField angulo_text;

    public Ventana() {
        setLayout(null);
        setSize(600, 600);// Tamaño de la ventana  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d = new Dibujo();
        add(d);
        VoltearH = new JButton();
        VoltearH.setText("Rotación Horizontal");
        VoltearH.setBounds(200, 700, 200, 40);
        add(VoltearH);
        VoltearH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                voltearHorizontalActionClicked(evt);
            }
        });
        VoltearV = new JButton();
        VoltearV.setText("Rotación Vertical");
        VoltearV.setBounds(400, 700, 200, 40);
        add(VoltearV);
        setVisible(true);
        VoltearV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                voltearVerticalActionClicked(evt);
            }
        });
        
        Rotar = new JButton();
        Rotar.setText("Rotar Imagen");
        Rotar.setBounds(600, 700, 200, 40);
        add(Rotar);
        setVisible(true);
        Rotar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                rotarImagenActionClicked(evt);
            }
        });
        
        angulo_text= new JTextField();
        angulo_text.setBounds(600,800,200,20);
        add(angulo_text);
          angulo_text.addKeyListener(new KeyListener(){
        public void keyTyped(KeyEvent evt){
             char c = evt.getKeyChar();
      if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
        if(angulo_text.getText().length() >=3){
            evt.consume();
        }
        }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
    });
        setVisible(true);
    }

    public void voltearHorizontalActionClicked(ActionEvent e) {

        if (this.d.click) {
            this.d.setClick(false);
        } else {
            this.d.setClick(true);
        }
        this.d.repaint();

    }

    public void voltearVerticalActionClicked(ActionEvent e) {

        if (this.d.click2) {
            this.d.setClick2(false);
        } else {
            this.d.setClick2(true);
        }
        this.d.repaint();

    }
    
    public void rotarImagenActionClicked(ActionEvent e) {

        if (this.d.click3) {
            this.d.angulo= Integer.parseInt(angulo_text.getText());
            this.d.setClick3(false);
        } else {
            
            this.d.setClick3(true);
        }
        this.d.repaint();

    }
}
