import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
   private GridLayout grid;
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panel4;
   private JLabel lblSaludo;
   private JLabel lblOpcionJuego;
   private JButton btnIA;
   private JButton btn2jug;

   public Menu() {
       grid = new GridLayout(4, 1);
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       panel4 = new JPanel();

       setLayout(grid);
       setResizable(false); // bloque el tamanio de ventana
       setSize(600, 400);
       setLocationRelativeTo(null);

       Font titulo = new Font("Tahoma", Font.PLAIN, 35);

       setBackground(Color.PINK);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cerra ventana = terminar programa

       lblSaludo = new JLabel("Bienvenido a 3 en Raya!!");
       lblOpcionJuego = new JLabel("Elija la opción de juego que prefiera: ");

       btnIA = new JButton("Jugar con IA");
       btn2jug = new JButton("Jugar con un amigo");

       ordenarJframe();
       add(panel1);
       add(panel2);
       add(panel3);
       add(panel4);

       lblSaludo.setFont(titulo);
       lblOpcionJuego.setFont(titulo);

       lblSaludo.setForeground(Color.CYAN);
       lblOpcionJuego.setForeground(Color.BLUE);

       btnIA.setBackground(Color.ORANGE);
       btn2jug.setBackground(Color.GREEN);

       setVisible(true);

       btnIA.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              PantallaPrincipalIA pantallaPrincipalIA = new PantallaPrincipalIA();
               pantallaPrincipalIA.setVisible(true);
               setVisible(false);
           }
       });
       btn2jug.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
               pantallaPrincipal.setVisible(true);
               setVisible(false);
           }
       });
   }
   public void ordenarJframe(){
       panel1.setBackground(Color.MAGENTA);
       panel2.setBackground(Color.MAGENTA);
       panel3.setBackground(Color.MAGENTA);
       panel4.setBackground(Color.MAGENTA);

       panel1.add(lblSaludo);
       panel2.add(lblOpcionJuego);
       panel3.add(btnIA);
       panel4.add(btn2jug);
   }

}
