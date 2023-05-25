package modelo;

import java.util.Hashtable;

import javafx.scene.paint.Color;

public class Diseño {
	
	public static String MANILLA = "Manilla";
	public static String DECORACION = "Decoracion";
	

	
	
	private String tipo;
	private String tamaño;
	private Color fondo = Color.WHITE;
	private Hashtable<String, Figura> diseño;


	public Diseño() {
		diseño = new Hashtable<String, Figura>();

	}

	public void crearDiseño(String name, Figura nueva) {
		diseño.put(name, nueva);
	}

	public Figura seleccionarDiseño(String nombre) {
		return diseño.get(nombre);
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public Color getFondo() {
		return fondo;
	}

	public void setFondo(Color fondo) {
		this.fondo = fondo;
	}

	public Hashtable<String, Figura> getDiseño() {
		return diseño;
	}
	
	
}
