package modelo;

public class Persona {

 private String nombre;
 private String apellido;
 private String puntaje;
 private String codigo;
 public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public Persona() {
	 
 }

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getPuntaje() {
	return puntaje;
}

public void setPuntaje(String puntaje) {
	this.puntaje = puntaje;
}

@Override
public String toString() {
	return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", puntaje=" + puntaje + ", codigo=" + codigo + "]";
}
 
 
}
