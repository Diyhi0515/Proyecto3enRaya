import javax.swing.*;
import java.awt.*;

public class PanelFig extends JPanel {
    public boolean bandera;
    public int contador;
    private Graphics2D g;

    public PanelFig(){
        bandera = false;
        contador = 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(bandera){
            if (contador == 1) {
                g2.setColor(Color.CYAN);
                g2.setStroke(new BasicStroke(8));
                g2.drawLine(15, 35, 175, 175);
                g2.drawLine(175, 35, 15, 175);

            }else {
                g2.setColor(Color.YELLOW);
                g2.setStroke(new BasicStroke(8));
                g2.drawOval(20,20,150,150);
            }
        }

    }
}
