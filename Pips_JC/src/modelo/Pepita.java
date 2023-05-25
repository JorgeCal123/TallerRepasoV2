package modelo;

import javafx.scene.paint.Color;

public class Pepita {

	private int fila;
	private int columna;
	private Color color;
	private double tamaño;
	
	public static double PEQUEÑO= 1;
	public static double MEDIANO= 2;
	public static double GRANDE= 3;
	
	public Pepita(int fila, int columna, Color color, double tamaño) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.color = color;
		this.tamaño = tamaño;
	}

	
	public int getFila() {
		return fila;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}


	public int getColumna() {
		return columna;
	}


	public void setColumna(int columna) {
		this.columna = columna;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	public double getTamaño() {
		return tamaño;
	}


	public void setTamaño(String tamaño) {
		this.tamaño = Double.parseDouble(tamaño);
	}

	
}