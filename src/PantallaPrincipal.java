import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class PantallaPrincipal extends JFrame implements ActionListener{
    GridLayout posGird;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField jugador1;
    private JTextField jugador2;
    private String jug1;
    private String jug2;
    private JButton guardar;
    private boolean bandera;
    private  JLabel p;
    public PantallaPrincipal() {
        setTitle("3 en Raya");
        posGird = new GridLayout(6, 1);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        setLayout(posGird);
        setResizable(false); // bloque el tamanio de ventana
        setSize(600, 400);
        setLocationRelativeTo(null);

        Font titulo = new Font("Tahoma", Font.PLAIN, 35);

        setBackground(Color.PINK);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cerra ventana = terminar programa
        label1 = new JLabel("Bienvenido a 3 en Raya!!");
        label2 = new JLabel("Ingrese el nombre del Jugador 1 para X");
        label3 = new JLabel("Ingrese el nombre del Jugador 2 para O");
        jugador1 = new JTextField(10);
        jugador2 = new JTextField(10);
        jug1 = "";
        jug2 = "";
        bandera = false;
        guardar = new JButton("Guardar");

        ordenarJframe();
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);

        label1.setBounds(70, 20, 400, 40);
        label1.setFont(titulo);
        label1.setForeground(Color.CYAN);

        label2.setForeground(Color.BLUE);
        label3.setForeground(Color.BLUE);

        guardar.setBackground(Color.MAGENTA);
        guardar.addActionListener(this);

        setVisible(true);
    }
    public void ordenarJframe(){
        panel1.setBackground(Color.PINK);
        panel2.setBackground(Color.pink);
        panel3.setBackground(Color.PINK);
        panel4.setBackground(Color.PINK);
        panel5.setBackground(Color.PINK);
        panel6.setBackground(Color.PINK);

        panel1.add(label1);

        panel2.add(label2);
        panel3.add(jugador1);

        panel4.add(label3);
        panel5.add(jugador2);

        panel6.add(guardar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jug1 = jugador1.getText().toUpperCase(Locale.ROOT);
        jug2 = jugador2.getText().toUpperCase(Locale.ROOT);
        setVisible(false);

        Grafica grafica = new Grafica();

        grafica.setNomJug1(jug1);
        grafica.setNomJug2(jug2);

        grafica.setVisible(true);
    }

    public boolean isBandera() {
        return bandera;
    }
}
