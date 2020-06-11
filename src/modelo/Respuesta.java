package modelo;

public class Respuesta {
private String respuesta;
private boolean bandera;
public Respuesta() {
	this.respuesta=new String();
	bandera=new Boolean(false);
	
}
public String getRespuesta() {
	return respuesta;
}
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}
public boolean isBandera() {
	return bandera;
}
public void setBandera(boolean bandera) {
	this.bandera = bandera;
}
@Override
public String toString() {
	return "Respuesta [respuesta=" + respuesta + ", bandera=" + bandera + "]";
}

}
