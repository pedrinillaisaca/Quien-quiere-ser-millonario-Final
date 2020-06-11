package Vista;

import modelo.Persona;
import modelo.Preguntas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Controlador.GestionJuego;
import Controlador.PersonaBD;


/**
 *
 * @author LENOVO
 */
public class VentanaInicio extends JFrame implements ActionListener{
    private JButton btnRegistrar,btnBD;
    private JButton btnJugar;
    private JTextField txtnombre;
    private JTextField txtApellido;
    private JTextField txtCodigo;
    PersonaBD pbd = new PersonaBD();
    /**
     * Constructur.
     */
    public VentanaInicio(){
        initComponentes();
    }
    private void initComponentes() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("QUIEN QUIERE SER MILLONARIO.");
        //Contenedor de informacion.
        Container cp = getContentPane();
        BorderLayout  layout= new BorderLayout();
        cp.setLayout(layout);
        // LBL para el fondo de inicio de juego 
        JLabel lblLogo = new JLabel();
        ImageIcon supreme = new ImageIcon("/Users/kevingodoy/Downloads/Millonario/imagenes/logo.jpg");
        Icon icono = new ImageIcon(supreme.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono);
        this.repaint();
        // panel para el registro
        JPanel panelJugador = new JPanel();
        panelJugador.setLayout(new GridLayout(5, 4));
        
        JLabel lblNombre = new JLabel("Nombre:");
        Font auxFont1=lblNombre.getFont(); 
        lblNombre.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 10));
        txtnombre = new JTextField(2);
        
        JLabel lblApellido = new JLabel("Apellido:");
        Font auxFont=lblApellido.getFont(); 
        lblApellido.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 10));
        
        
        JLabel lblCodigo = new JLabel("Codigo:");
        txtCodigo = new JTextField(2);
        Font auxFont2=lblCodigo.getFont(); 
        lblCodigo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 10));
        
        txtApellido = new JTextField(2);
        btnRegistrar = new JButton("registrar");
        btnRegistrar.setActionCommand("bRegistrar");
        btnRegistrar.addActionListener(this);
        
        btnBD = new JButton("BD");
        btnBD.setActionCommand("btnBD");
        btnBD.addActionListener(this);
        
        btnJugar = new JButton("JUGAR");
        btnJugar.setActionCommand("bjugar");
        btnJugar.addActionListener(this);
        
        
        
        panelJugador.add(lblCodigo);
        panelJugador.add(txtCodigo);
        panelJugador.add(lblNombre);
        panelJugador.add(txtnombre);
        panelJugador.add(lblApellido);
        panelJugador.add(txtApellido);
        
        panelJugador.add(btnRegistrar);
        panelJugador.add(btnBD);
        panelJugador.add(btnJugar);
         
        
        cp.add(lblLogo,BorderLayout.CENTER);
        cp.add(panelJugador,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Eventos menu " + comando);
        switch(comando){
            case "bjugar":
                cambioVentna();
                break;
            case "bRegistrar":
                registrar();
                break;
        }
 }

    private void registrar() {
		// TODO Auto-generated method stub
          	Persona es = new Persona();
	       es.setCodigo(txtCodigo.getText());
          String codigo = (txtCodigo.getText());
          es.setCodigo(codigo);
         
         es.setNombre(txtnombre.getText());
         String nombre = txtnombre.getText();
         es.setNombre(nombre);
         
         es.setNombre(txtApellido.getText());
         String apellido = txtApellido.getText();
         es.setApellido(apellido);
         
   
         String puntaje = "0";
         es.setPuntaje(puntaje);
	
         pbd.insertar(es);
        
	}
	private void cambioVentna() {
    	 Controlador.GestionJuego gp = new Controlador.GestionJuego();
         ArrayList<Preguntas> p=gp.recuperarPreguntas();
         
         Ventana v=new Ventana(p);
         v.setVisible(true);
       
        //VentanaInicio inio = new VentanaInicio();
       // inio.setVisible(false);
        this.setVisible(false);
    }

   
}