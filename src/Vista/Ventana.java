package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import jssc.SerialPortEvent;
//import jssc.SerialPortEventListener;
//import jssc.SerialPortException;
//import gnu.io.SerialPortEvent;
//import gnu.io.SerialPortEventListener;

import modelo.Preguntas;
import modelo.Respuesta;

public class Ventana extends JFrame implements ActionListener{
    private  JLabel lblcien,lblP1,lbl2oo,lbl300,lbl500,lblmil,lbl2mil,lbl4mil,lbl8mil,lbl16mil,lbl32mil,lbl64mil,lbl125mil,lbl250mil,lblmediomillon,lblmillon;
    private JButton btnA, btnB,btnC,btnD,cmd50,cmdllamada;
   // private Pregunta2 p2 ;
    //--------------------------------------------------------------
    // Variable que representa el puerto USB y permite realizar la conexion con el mismo
    // Variable que representa el flujo de datos que envia el puerto USB
    private java.io.DataInputStream flujoUSB;
    
    private java.io.DataOutputStream outUSB;
    //private java.io.DataInputStream inUSB;
    
    // Variable con la coordenada x que envia la tarjeta electronica
    private int x;
    // Variable con la coordenada y que envia la tarjeta electronica
    private int y;
    //PROFE
       // Variable con la coordenada x que envia la tarjeta electronica
    private int a;
    // Variable con la coordenada y que envia la tarjeta electronica
    private int b;
    private int c;
    private int d;
    private ArrayList<Preguntas>p;
    //----------------------------------------------------------------------
    /**
     * Constructor.
     * @param p 
     */
    public Ventana(ArrayList<Preguntas> p){
    	this.p=p;
        
        initComponents();
        
    }

    private void initComponents() {
        this.setSize(1000, 610);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PREGUNTAS:");
        //Contenedor de informacion.
        Container cp = getContentPane();
        BorderLayout  layout= new BorderLayout();
        cp.setLayout(layout);
        // LBL para el fondo de inicio de juego 
        JPanel panelImagen = new JPanel();
        panelImagen.setBackground(Color.GRAY);
        ImageIcon qm = new ImageIcon("imagenes/millonario.png");
               JLabel imagen = new JLabel(qm);
                Icon icono = new ImageIcon(qm.getImage().getScaledInstance(900,520, Image.SCALE_DEFAULT));
                imagen.setIcon(icono);
   
              panelImagen.add(imagen,BorderLayout.CENTER);
              cp.add(panelImagen,BorderLayout.NORTH);
        this.repaint();
        
        //Panel para la  pregunta 
        JPanel panelPregunta = new JPanel(new BorderLayout());
        String p1=p.get(14).getPregunta();
        ArrayList<Respuesta> res=new ArrayList<>();
        res=p.get(14).getListaRespuestas();
        String uno=res.get(0).getRespuesta();
        String dos=res.get(1).getRespuesta();
        String tre=res.get(2).getRespuesta();
        String cua=res.get(3).getRespuesta();

      
        
        lblP1 = new JLabel(p1);
        Font auxFont1=lblP1.getFont(); 
        lblP1.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 12));
       
	    panelPregunta.add(lblP1);
	   
        JPanel respuestas = new JPanel();
        
        btnA = new JButton(uno);
        btnA.addActionListener(this);
        btnA.setActionCommand("A");
        GridBagConstraints gbc1 = new GridBagConstraints();
	    gbc1.gridx =0;
	    gbc1.gridy =1;
	    respuestas.add(btnA,gbc1);
        
        btnB = new JButton(dos);
        btnB.addActionListener(this);
        btnB.setActionCommand("B");
        GridBagConstraints gbc2 = new GridBagConstraints();
	    gbc2.gridx =2;
	    gbc2.gridy =1;
	    respuestas.add(btnB,gbc2);
        
        btnC = new JButton(tre);
        btnC.addActionListener(this);
        btnC.setActionCommand("C");
        GridBagConstraints gbc3 = new GridBagConstraints();
	    gbc3.gridx =0;
	    gbc3.gridy =2;
	    respuestas.add(btnC,gbc3);
        
        btnD = new JButton(cua);
        btnD.addActionListener(this);
        btnD.setActionCommand("D");
        GridBagConstraints gbc4 = new GridBagConstraints();
	    gbc4.gridx =2;
	    gbc4.gridy =2;
	    respuestas.add(btnD,gbc4);
	    
	  
       // panelPregunta.add(respuestas,BorderLayout.CENTER);
        
	    panelPregunta.setBackground(Color.GRAY);
	    respuestas.setBackground(Color.GRAY);
	    
	    
	    JPanel l = new JPanel();
        l.add(panelPregunta,BorderLayout.NORTH);
        l.add(respuestas,BorderLayout.CENTER);
	    
        cp.add(l,BorderLayout.SOUTH);
	    
        l.setBackground(Color.GRAY);
        // PANEL PARA NUMERO DE PREGUNTAS
        JPanel panelnumeroPreuntas = new JPanel(new GridBagLayout());
        
        JLabel lbl200 = new JLabel("$ 200");
        GridBagConstraints gbc200 = new GridBagConstraints();
	    gbc200.gridx =0;
	    gbc200.gridy =1;
        panelnumeroPreuntas.add(lbl200,gbc200);
        
        JLabel lbl100 = new JLabel("$ 100");
        GridBagConstraints gbc100 = new GridBagConstraints();
	    gbc100.gridx =0;
	    gbc100.gridy =0;
	    panelnumeroPreuntas.add(lbl100,gbc100);
        
        
        
        
        
     
        
        //cp.add(panelnumeroPreuntas);
              JPanel Dinero = new JPanel();
              GridBagLayout layouts = new GridBagLayout();
              Dinero.setLayout(layouts);
       
       
              
              Dinero.setBackground(Color.
            		  GRAY);
              lblmillon = new JLabel("15 <> $1.000.000"+"\n");
              GridBagConstraints gbc5 = new GridBagConstraints();
	         gbc5.gridx =0;
	         gbc5.gridy =0;
	         Dinero.add(lblmillon,gbc5);
              
             
             
               lblmediomillon = new JLabel("14 <> $500.000"+"\n");
              GridBagConstraints gbc6 = new GridBagConstraints();
	      gbc6.gridx =0;
	      gbc6.gridy =1;
	      Dinero.add(lblmediomillon,gbc6);
             
              
              lbl250mil = new JLabel("13 <> $250.000"+"\n");
              GridBagConstraints gbc7 = new GridBagConstraints();
	      gbc7.gridx =0;
	      gbc7.gridy =2;
	      Dinero.add(lbl250mil,gbc7);
              
              lbl125mil = new JLabel("12 <> $125.000"+"\n");
              GridBagConstraints gbc8 = new GridBagConstraints();
	      gbc8.gridx =0;
	      gbc8.gridy =3;
	      Dinero.add(lbl125mil,gbc8);
              
               lbl64mil = new JLabel("11 <> $64.000"+"\n"+"\n");
              GridBagConstraints gbc9 = new GridBagConstraints();
	      gbc9.gridx =0;
	      gbc9.gridy =4;
	      Dinero.add(lbl64mil,gbc9);
              
               lbl32mil = new JLabel("10 <> $32.000"+"\n"+"\n");
              GridBagConstraints gbc10 = new GridBagConstraints();
	      gbc10.gridx =0;
	      gbc10.gridy =5;
	      Dinero.add(lbl32mil,gbc10);
              
              lbl16mil = new JLabel("9 <> $16.000"+"\n");
              GridBagConstraints gbc11 = new GridBagConstraints();
	      gbc11.gridx =0;
	      gbc11.gridy =6;
	      Dinero.add(lbl16mil,gbc11);
              
              lbl8mil = new JLabel("8 <> $8.000"+"\n");
              GridBagConstraints gbc12= new GridBagConstraints();
	      gbc12.gridx =0;
	      gbc12.gridy =7;
	      Dinero.add(lbl8mil,gbc12);
              
              lbl4mil = new JLabel("7 <> $4.000"+"\n");
              GridBagConstraints gbc13 = new GridBagConstraints();
	      gbc13.gridx =0;
	      gbc13.gridy =8;
	      Dinero.add(lbl4mil,gbc13);
              
              lbl2mil = new JLabel("6 <> $2.000"+"\n");
              GridBagConstraints gbc14 = new GridBagConstraints();
	      gbc14.gridx =0;
	      gbc14.gridy =9;
	      Dinero.add(lbl2mil,gbc14);
              
               lblmil= new JLabel("5 <> $1.000"+"\n");
              GridBagConstraints gbc15 = new GridBagConstraints();
	      gbc15.gridx =0;
	      gbc15.gridy =10;
	      Dinero.add(lblmil,gbc15);
              
              lbl500 = new JLabel("4 <> $500"+"\n");
              GridBagConstraints gbc16 = new GridBagConstraints();
	      gbc16.gridx =0;
	      gbc16.gridy =11;
	      Dinero.add(lbl500,gbc16);
              
              lbl300 = new JLabel("3 <> $300"+"\n");
              GridBagConstraints gbc17 = new GridBagConstraints();
	      gbc17.gridx =0;
	      gbc17.gridy =12;
	      Dinero.add(lbl300,gbc17);
              
              lbl2oo = new JLabel("2 <> $200"+"\n");
              GridBagConstraints gbc18 = new GridBagConstraints();
	      gbc18.gridx =0;
	      gbc18.gridy =13;
	      Dinero.add(lbl2oo,gbc18);
              
              lblcien = new JLabel("1 <> $100"+"\n");
              GridBagConstraints gbc19 = new GridBagConstraints();
	      gbc19.gridx =0;
	      gbc19.gridy =14;
	      Dinero.add(lblcien,gbc19);
              
              cmd50= new JButton("50-50%");
              cmd50.setActionCommand("50");
              cmd50.addActionListener(this);
              GridBagConstraints gbc20 = new GridBagConstraints();
	      gbc20.gridx =0;
	      gbc20.gridy =15;
	      Dinero.add(cmd50,gbc20);
              //panelImagen.add(lblP,BorderLayout.CENTER);
              
              panelImagen.add(Dinero,BorderLayout.WEST);
              cp.add(panelImagen,BorderLayout.EAST);  
      //-----------------------------------------------
    }
   
    int cont=14;
    int op=0;
    
   
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Eventos menu " + comando);
        switch(comando){
            case "A":
            	op=1;
                break;
                
            case"B":
            	op=2;
                break;
            case "C":
            	op=3;
                break;
            case "D":
            	op=4;
                break;
        }
        System.out.println(p.get(cont).getAcierto());
        if(p.get(cont).getAcierto()==op) {
        	cont--;
        	try {
            	actuializarCom();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         ganador();
        }else{
        	 JOptionPane.showMessageDialog(rootPane, "Respuesta Incorrecta gracias por jugar");
             System.exit(0);
        }
        
    }

	private void actuializarCom() {
		lblP1.setText(p.get(cont).getPregunta());
		btnA.setText(""+(p.get(cont).getListaRespuestas().get(0).getRespuesta()));
		btnB.setText(""+(p.get(cont).getListaRespuestas().get(1).getRespuesta()));
		btnC.setText(""+(p.get(cont).getListaRespuestas().get(2).getRespuesta()));
		btnD.setText(""+(p.get(cont).getListaRespuestas().get(3).getRespuesta()));
		 if(cont==13) {
		    	lblcien.setForeground(Color.RED);
		 }else{
			 if(cont==12) {
				 lbl2oo.setForeground(Color.RED);
			 }else{
				 if(cont==11) {
					 lbl300.setForeground(Color.RED);
				 }else{
					 if(cont==10) {
						 lbl500.setForeground(Color.RED);
						
					        
					 }else{
						 if(cont==9) {
							 lblmil.setForeground(Color.RED);
						 }else{
							 if(cont==8) {
								 lbl2mil.setForeground(Color.RED);
							 }else{
								 if(cont==7) {
									 
									 lbl4mil.setForeground(Color.RED);
								 }else{
									 if(cont==6) {
										 
										 lbl8mil.setForeground(Color.RED);
									 }else{
										 if(cont==5) {
											 
											 lbl16mil.setForeground(Color.RED);
											 
										 }else{
											 if(cont==4) {
												 lbl32mil.setForeground(Color.RED);
											 }else{
												 if(cont==3) {
													 lbl64mil.setForeground(Color.RED);
												 }else{
													 if(cont==2) {
														 lbl125mil.setForeground(Color.RED);
													 }else{
														 if(cont==1) {
															 lbl250mil.setForeground(Color.RED);
														 }else{
															 if(cont==0) {
																 lblmediomillon.setForeground(Color.RED);
															
																
															 }
																 
														 }
															 
													 }
														 
												 }
													
											 }
												
										 }
									 }
										 
								 }
									 
							 }
								 
						 }
							 
					 }
						 
				 }
					 
			 }
		
			 
		    }
	
		
		
	}
	public void ganador() {
		 if(cont<0) {
			 lblmillon.setForeground(Color.ORANGE);
			 JOptionPane.showMessageDialog(rootPane, "FELICIDADES HA GANADO UN MILLON DE DOLARES !!!!");
			 
		 }
	}
	
}