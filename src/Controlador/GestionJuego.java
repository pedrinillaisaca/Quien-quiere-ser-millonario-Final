package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Persona;
import modelo.Preguntas;
import modelo.Respuesta;
import utilidad.ConexionEsBD;

public class GestionJuego {
	
private ArrayList<Preguntas> preguntas;
private ArrayList<Respuesta> listRest;
public GestionJuego() {
	preguntas= new ArrayList<>();
	
}

public ArrayList<Preguntas> recuperarPreguntas() {
	String sql = "SELECT *  " 
		
			+ "FROM MILLONARIO"
			;
	System.out.println(sql);
	Connection con = null;
	try {
		con = ConexionEsBD.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		//ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	        Preguntas p = new Preguntas();
	        
			p.setCodigo(rs.getString("CODIGO"));
			p.setPregunta(rs.getString("PREGUNTA"));
			p.setAcierto(rs.getInt("ACIERTO"));

			preguntas.add(p);
			System.out.println(p.toString());
			//return p;
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		ConexionEsBD.close(con);
	}
	//return null;
	
	for (int i = 0; i <preguntas.size(); i++) {
		String code=preguntas.get(i).getCodigo();
		
		String sql1 = "SELECT *  " 
				
			+ "FROM MILLONARIO "
			+ " where codigo= "+code;
			;
	System.out.println(sql1);
	Connection con1 = null;
	try {
		con1 = ConexionEsBD.getConnection();
		PreparedStatement ps = con1.prepareStatement(sql1);
		//ps.setInt(1, codigo);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listRest=new ArrayList<>();
			Respuesta r1=new Respuesta();
			r1.setRespuesta(rs.getString("R1"));
			Respuesta r2=new Respuesta();
			r2.setRespuesta(rs.getString("R2"));
			Respuesta r3=new Respuesta();
			r3.setRespuesta(rs.getString("R3"));
			Respuesta r4=new Respuesta();
			r4.setRespuesta(rs.getString("R4"));
			listRest.add(r1);
			listRest.add(r2);
			listRest.add(r3);
			listRest.add(r4);

			//System.out.println(p.toString());
			//return p;
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		ConexionEsBD.close(con1);
	}
	//return null;
	preguntas.get(i).setListaRespuestas(listRest);
	//return preguntas;
	}
	return preguntas;
}




}
