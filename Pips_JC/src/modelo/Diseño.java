package modelo;

import java.util.Hashtable;

import javafx.scene.paint.Color;

public class Dise�o {
	
	public static String MANILLA = "Manilla";
	public static String DECORACION = "Decoracion";
	

	
	
	private String tipo;
	private String tama�o;
	private Color fondo = Color.WHITE;
	private Hashtable<String, Figura> dise�o;


	public Dise�o() {
		dise�o = new Hashtable<String, Figura>();

	}

	public void crearDise�o(String name, Figura nueva) {
		dise�o.put(name, nueva);
	}

	public Figura seleccionarDise�o(String nombre) {
		return dise�o.get(nombre);
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTama�o() {
		return tama�o;
	}

	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}

	public Color getFondo() {
		return fondo;
	}

	public void setFondo(Color fondo) {
		this.fondo = fondo;
	}

	public Hashtable<String, Figura> getDise�o() {
		return dise�o;
	}
	
	
}
