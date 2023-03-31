import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grafica extends JFrame implements ActionListener {
    private PanelFig[][] paneles;
    private JPanel panel1;
    private PantallaPrincipal pantalla1;
    private JPanel arriba;
    private JPanel pantallaTableto;
    GridLayout grid;
    BorderLayout border;
    private int[][] tablero;
    private int cont;
   private String nomJug1;
   private String nomJug2;
   private JLabel lblJuega;
   private JLabel lblganador;
   private JLabel lblImagen;
   private JLabel lblJugador;
   private JButton btnSalir;
   private JButton  btnJugarDenuevo;
   private boolean seguir;
    public Grafica(){
        border = new BorderLayout();
        tablero = new int[3][3];
        arriba = new JPanel();
        arriba.setBackground(Color.CYAN);
        pantallaTableto = new JPanel();
        setResizable(false);
        setTitle("3 en Raya");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(border);
        setVisible(true);

        cont = 1;
        seguir = true;

        lblJuega = new JLabel("");
        lblganador= new JLabel("");
        lblJugador = new JLabel("");
        nomJug1 = "";
        nomJug2 = "";

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(Color.GREEN);
        btnSalir.addActionListener(this);

        btnJugarDenuevo = new JButton("Jugar de nuevo");
        btnJugarDenuevo.setBackground(Color.ORANGE);
        btnJugarDenuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // menu = new Menu();
                setVisible(false);
                //menu.setVisible(true);
            }
        });

        pantallaArriba();
        tableroJuego();
        arriba.setPreferredSize(new Dimension(600,162));
        pantallaTableto.setPreferredSize(new Dimension(600,600));
        add(arriba,BorderLayout.NORTH);
        add(pantallaTableto,BorderLayout.SOUTH);
        setVisible(true);

        Ganador();

    }

    public void setNomJug1(String nomJug1) {
        this.nomJug1 = nomJug1;
        lblJugador.setText(nomJug1);

    }

    public void setNomJug2(String nomJug2) {
        this.nomJug2 = nomJug2;
    }

    public String getNomJug1() {
        return nomJug1;
    }

    public String getNomJug2() {
        return nomJug2;
    }

    public void pantallaArriba(){
        arriba.setLayout(new FlowLayout());
        Font titulo = new Font("Tahoma", Font.PLAIN, 38);
        Icon imagen = new ImageIcon(getClass().getResource("/imagenes/feliz.png"));

        lblImagen = new JLabel();
        lblImagen.setIcon(imagen);
        lblImagen.setBounds(120, 50, 100,80 );
        lblJuega.setFont(titulo);
        lblJugador.setFont(titulo);
        lblganador.setFont(titulo);

        nomJug1 = getNomJug1();
        nomJug2 = getNomJug2();

        lblJuega.setForeground(Color.MAGENTA);
        lblJugador.setForeground(Color.PINK);
        lblganador.setForeground(Color.ORANGE);


        lblJuega.setText("Juega el jugador: ");
        if(seguir) {
            arriba.add(lblJuega);
           if(!tableroLleno()) {
                arriba.add(lblJugador);
           }
        }

        arriba.setVisible(true);
    }

    public void tableroJuego(){
        grid = new GridLayout(3, 3);
        paneles = new PanelFig[3][3];
        pantallaTableto.setLayout(grid);
        pantallaTableto.setVisible(true);
        constructorPorPanel();
        paneles[0][0].setBackground(Color.MAGENTA);
        paneles[0][2].setBackground(Color.MAGENTA);
        paneles[1][1].setBackground(Color.MAGENTA);
        paneles[2][0].setBackground(Color.MAGENTA);
        paneles[2][2].setBackground(Color.MAGENTA);
        paneles[0][1].setBackground(Color.PINK);
        paneles[1][0].setBackground(Color.PINK);
        paneles[1][2].setBackground(Color.PINK);
        paneles[2][1].setBackground(Color.PINK);
    }

    private void constructorPorPanel(){
        for (int i = 0; i < paneles.length; i++) {
            for (int j = 0; j < paneles[0].length ; j++) {
                paneles[i][j] = new PanelFig();
                pantallaTableto.add(paneles[i][j]);
                paneles[i][j].setPreferredSize(new Dimension(200,200));
                paneles[i][j].setLayout(grid);
                dibujarLinea(paneles,i,j);
            }
        }

    }

    public void dibujarLinea(PanelFig[][] panel, int x, int y){
       panel[x][y].addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
                if(seguir) {
                    panel[x][y].bandera = true;
                    if (cont == 1 && tablero[x][y] == 0) {
                        panel[x][y].contador = 1;
                        cont = 2;
                        tablero[x][y] = 1;
                        Ganador();
                        if (!tableroLleno() && seguir) {
                            lblJugador.setText(nomJug2);
                            arriba.add(lblJugador);
                        } else if(seguir){
                            lblJugador.setText("");
                            lblJuega.setForeground(Color.RED);
                            Icon imagen2 = new ImageIcon(getClass().getResource("/imagenes/tristes.png"));
                            lblJuega.setText("Hubo Empate UwU, nimodo");
                            lblImagen.setIcon(imagen2);
                            arriba.add(lblImagen);
                            arriba.add(btnSalir);
                            arriba.add(btnJugarDenuevo);
                        }
                    } else if (cont == 2 && tablero[x][y] == 0) {
                        panel[x][y].contador = 2;
                        tablero[x][y] = 2;
                        cont = 1;
                        Ganador();
                        if (!tableroLleno() && seguir) {
                            lblJugador.setText(nomJug1);
                            arriba.add(lblJugador);
                        }
                    }
                }
               panel[x][y].setBackground(paneles[x][y].getBackground());
               verificarGanadorX();

           }

           @Override
           public void mouseReleased(MouseEvent e) {
                panel[x][y].setEnabled(false);
           }

           @Override
           public void mouseEntered(MouseEvent e) {

           }

           @Override
           public void mouseExited(MouseEvent e) {

           }
       });
    }
    public boolean tableroLleno(){
        int veri = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j] != 0){
                    veri++;
                }
            }
        }
        return veri == 9;
    }
    public void verificarGanadorX(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j]+ " | ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public boolean ganadorVertical(int num){
        int verificar = 0;
        for (int i = 0; i < tablero.length; i++) {
            if(verificar == 0) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[j][i] == num) {
                        verificar++;
                    }else {
                        verificar = 0;
                    }
                }
            }
        }
        return verificar == 3;
    }
    public boolean ganadorHorizontal(int num2){
        int verificar2 = 0;
        for (int i = 0; i < tablero.length; i++) {
            if(verificar2 == 0){
                for (int j = 0; j < tablero[0].length; j++) {
                    if(tablero[i][j] == num2){
                        verificar2++;
                    }else {
                        verificar2 = 0;
                    }
                }
            }

        }
        return verificar2 == 3;
    }
    public boolean ganadorDiagonal1(int num3){
        int verificar3 = 0;
        for (int i = 0; i < tablero.length; i++) {
            if(tablero[i][i] == num3){
                verificar3++;
            }else {
                verificar3 = 0;
            }
        }
        return verificar3 == 3;
    }
    public boolean ganadorDiagonal2(int num4){
        int verificar4 = 0;
        int j = 2;
        for (int i = 0; i < tablero.length; i++) {
            if(tablero[i][j] == num4){
                verificar4++;
            }else {
                verificar4 = 0;
            }
            j--;
        }
        return verificar4 == 3;
    }
    public void gana1(){
        lblJuega.setText("Ganó el jugador: ");
        lblJugador.setText("");
        lblganador.setText(nomJug1);
        arriba.add(lblganador);
        arriba.add(lblImagen);
        arriba.add(btnSalir);
        arriba.add(btnJugarDenuevo);
        seguir = false;
    }
    public void gana2(){
        lblJuega.setText("Ganó el Jugador: ");
        lblJugador.setText("");
        lblganador.setText(nomJug2);
        arriba.add(lblganador);
        arriba.add(lblImagen);
        arriba.add(btnSalir);
        arriba.add(btnJugarDenuevo);
        seguir = false;

    }
    public void Ganador(){
        if(ganadorVertical(1)){
            gana1();
        }
        if(ganadorVertical(2)){
            gana2();
        }
        if(ganadorHorizontal(1)){
            gana1();
        }
        if(ganadorHorizontal(2)){
            gana2();
        }
        if(ganadorDiagonal1(1)){
            gana1();
        }
        if(ganadorDiagonal1(2)){
            gana2();
        }
        if (ganadorDiagonal2(1)) {
            gana1();
        }
        if(ganadorDiagonal2(2)){
            gana2();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
