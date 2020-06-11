package modelo;

import java.util.ArrayList;

public class Preguntas {
private String pregunta;
private String codigo;
private ArrayList<Respuesta> listaRespuestas;
private int acierto;

public Preguntas() {
	pregunta = new String();
	listaRespuestas=new ArrayList<>();
}

public int getAcierto() {
	return acierto;
}

public void setAcierto(int acierto) {
	this.acierto = acierto;
}

public String getPregunta() {
	return pregunta;
}

public void setPregunta(String pregunta) {
	this.pregunta = pregunta;
}

public ArrayList<Respuesta> getListaRespuestas() {
	return listaRespuestas;
}

public void setListaRespuestas(ArrayList<Respuesta> listaRespuestas) {
	this.listaRespuestas = listaRespuestas;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

@Override
public String toString() {
	return "Preguntas [pregunta=" + pregunta + ", codigo=" + codigo + ", listaRespuestas=" + listaRespuestas
			+ ", acierto=" + acierto + "]";
}



}
