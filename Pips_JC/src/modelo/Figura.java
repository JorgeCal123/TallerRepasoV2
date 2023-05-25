package modelo;

import javafx.scene.paint.Color;

public class Figura {
	
	public final static String MANILLA_MEDIANA = "12X55";
	public final static String MANILLA_GRANDE = "17X76";

	public final static String DECORACION_PEQUEÑA = "12X12";
	public final static String DECORACION_MEDIANA = "22X22";
	public final static String DECORACION_GRANDE = "50X50";

	
	private int filas;
	private int columnas;
	
	private int pos_fila;
	private int pos_columna;
	private String nombre;

	private Pepita[][] figura;

	public Figura() {
		this.pos_columna = 0;
		this.pos_fila = 0;
	}
	
	public int getPos_fila() {
		return pos_fila;
	}

	public void setPos_fila(int pos_fila) {
		this.pos_fila = pos_fila;
	}

	public int getPos_columna() {
		return pos_columna;
	}

	public void setPos_columna(int pos_columna) {
		this.pos_columna = pos_columna;
	}


	public void crearFigura(String filas, String columnas) {
		this.filas = Integer.parseInt(filas);
		this.columnas = Integer.parseInt(columnas);

		figura = new Pepita[this.filas][this.columnas];
	}
	
	
	public void copyFigura(Pepita[][] p) {
		this.filas = p.length;
		this.columnas = p[0].length;

		figura = new Pepita[this.filas][this.columnas];
		figura = p;
	}

	public void espacio(int filas, Color color, double tamaño) {
		figura = new Pepita[filas][1];
		this.filas = filas;
		this.columnas = 1;
		this.nombre = "espacio";
		for (int i = 0; i < filas; i++) {
			Pepita p = new Pepita(i, 0, color, tamaño);
			figura[i][1] = p;
		}
	}
	public void agregarPepita(Pepita p) {
		figura[p.getFila()][p.getColumna()] = p;
	}

	public void agregarFigura(Pepita[][] p) {
		this.figura = p;
	}

	public void agregarPosPepita(Pepita p, int fila, int columna) {
		figura[fila][columna] = p;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFilas() {
		return filas;
	}


	public void setFilas(String filas) {
		this.filas = Integer.parseInt(filas);
	}


	public int getColumnas() {
		return columnas;
	}


	public void setColumnas(String columnas) {
		this.columnas = Integer.parseInt(columnas);
	}


	public Pepita[][] getFigura() {
		return figura;
	}


	public void setFigura(Pepita[][] figura) {
		this.figura = figura;
	}


	
	
}
