import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel lblTitulo;
    private JLabel llblIcono;
    private JButton btnEmpezar;

    public Inicio(){
        setTitle("3 en Raya");
        setLayout(new BorderLayout());
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        panel1.setBackground(Color.MAGENTA);
        panel2 = new JPanel();
        panel2.setBackground(Color.MAGENTA);
        panel3 = new JPanel();
        panel3.setBackground(Color.MAGENTA);

        Font titulo = new Font("Tahoma", Font.PLAIN, 45);
        Icon imagen = new ImageIcon(getClass().getResource("/imagenes/tresEnRaya.png"));

        lblTitulo = new JLabel("3 EN RAYA");
        lblTitulo.setForeground(Color.CYAN);
        lblTitulo.setFont(titulo);
        panel1.add(lblTitulo);

        llblIcono = new JLabel("");
        llblIcono.setIcon(imagen);
        panel2.add(llblIcono);

        btnEmpezar = new JButton("Empezar");
        btnEmpezar.addActionListener(this);
        btnEmpezar.setBackground(Color.CYAN);
        panel3.add(btnEmpezar);


        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.SOUTH);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Menu menu = new Menu();
        setVisible(false);
        menu.setVisible(true);

    }


}
