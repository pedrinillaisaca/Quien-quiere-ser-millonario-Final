package Vista;

import javax.swing.JFrame;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import org.omg.CORBA.VersionSpecHelper;

import Controlador.GestionJuego;
import modelo.Preguntas;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
     
    /**  for (int i = 0; i < p.size(); i++) {
		System.out.println(p.get(i).toString());
	}*/
		JFrame vtn = new VentanaInicio();
        vtn.setVisible(true);
        
                        /**
                 * asignacion de sonido en formato mp3.
                 */
                try{
                    FileInputStream archivo;
                    Player player;
                    
                    archivo = new FileInputStream("/Users/kevingodoy/Downloads/Millonario/song/Millonario.mp3");
                    BufferedInputStream sonido = new BufferedInputStream(archivo);
                    
                    player = new Player(sonido);
                    player.play();
                }catch(JavaLayerException e){
                    e.printStackTrace();
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                
               
        
    }
      
      
	}


