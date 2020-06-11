package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import modelo.Persona;
import utilidad.ConexionEsBD;

public class PersonaBD {
	 private List<Persona> personas;
	 
	    public PersonaBD(){
	         personas = new ArrayList<Persona>();
	    }
	    
	     public List<Persona> getPersona() {
	        return personas;
	    }
	      
	     public boolean insertar(Persona jugador){
	    	 Connection con = null;
	 		String sql = "INSERT INTO PERSONA (codigo, "
	 				+" nombre)"
	 				+ " VALUES ("+ jugador.getCodigo()+ " , "+jugador.getNombre()+
	 				");";

	 		try {
	 			con = ConexionEsBD.getConnection();
	 			

	 			PreparedStatement ps = con.prepareStatement(sql);
	 			System.out.println(sql);
	 			/**ps.setString(1, jugador.getCodigo());
	 			ps.setString(2, jugador.getNombre());
	 			ps.setString(3, jugador.getApellido());
	 			ps.setString(4, jugador.getPuntaje());
	 			ps.executeUpdate();*/
	 			//return true;
	 		} catch (Exception e) {
	 			// TODO: handle exception
	 			e.printStackTrace();
	 		} finally {
	 			ConexionEsBD.close(con);
	 		}
	 		return false;
	 	}
	 	
	    
	    
	    public List<Persona> listar(){
			
			List<Persona> especialidades= new ArrayList<Persona>();             
			String sql="SELECT * "
					+ "FROM PERSONA";
			System.out.println(sql);
			Connection con = null;
			try {
				con = ConexionEsBD.getConnection();
			    PreparedStatement ps= con.prepareStatement(sql);
			    ResultSet rs=ps.executeQuery();
			    while(rs.next())
			    {
			        System.out.println(rs.getString("CODIGO"));
	                        
			        
			        Persona p = new Persona();
			        
			        p.setNombre(rs.getString("NOMBRE").trim());
			        p.setApellido(rs.getString("Apellido").trim());
			        p.setPuntaje(rs.getString("PUNTAJE").trim());
			      
			        
			        especialidades.add(p);
			        
			    }
			   
			} catch (Exception e) {
			    e.printStackTrace();
			} finally {
			   ConexionEsBD.close(con);
			}
			return especialidades;      
	    }
}
