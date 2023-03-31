import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipalIA extends JFrame {
    private GridLayout grid;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel lblTitulo;
    private JLabel lblOrden;
    private JTextField txfNombre;
    private String nombre;
    private JButton btnJugar;

    public PantallaPrincipalIA(){
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

        lblTitulo = new JLabel("Jugando contra IA");
        lblTitulo.setForeground(Color.CYAN);

        lblOrden = new JLabel("Ingrese su nombre: ");
        lblOrden.setForeground(Color.MAGENTA);

        lblTitulo.setFont(titulo);
        lblOrden.setFont(titulo);

        txfNombre = new JTextField(10);

        btnJugar = new JButton("Jugar");
        btnJugar.setBackground(Color.CYAN);

        nombre = "";

        ordenarJframe();
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        setVisible(true);

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = txfNombre.getText().toUpperCase();
                setVisible(false);

                GraficaConIA graficaConIA = new GraficaConIA();
                graficaConIA.setNomJug1(nombre);
                graficaConIA.setVisible(true);
            }
        });

    }

    public void ordenarJframe(){
        panel1.setBackground(Color.PINK);
        panel2.setBackground(Color.pink);
        panel3.setBackground(Color.PINK);
        panel4.setBackground(Color.PINK);

        panel1.add(lblTitulo);
        panel2.add(lblOrden);
        panel3.add(txfNombre);
        panel4.add(btnJugar);


    }

}
