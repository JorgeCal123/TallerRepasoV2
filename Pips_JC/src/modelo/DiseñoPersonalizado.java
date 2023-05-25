package modelo;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class DiseñoPersonalizado{
	
	
	private int espaciado;
	private int arriba;
	private int abajo;
	private int izquierda;
	private int derecha;
	
	int filas;
	int columnas;
	private Color fondo = Color.WHITE;

	private Figura figura;
	
	private ArrayList<ArrayList<Figura>> select_figuras;
	
	public DiseñoPersonalizado(int filas, int columnas) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		espaciado = 0;
		arriba = 0;
		abajo = 0;
		izquierda = 0;
		derecha = 0;

		figura = new Figura();
		figura.crearFigura(filas+"", columnas+"");
		select_figuras = new ArrayList<>();

	}
	
	public void agregarFigura(Figura seleccion, int posx, int posy) {
		ArrayList<Figura> fig = new ArrayList<>();
		seleccion.setPos_columna(posx);
		seleccion.setPos_fila(posy);
		fig.add(seleccion);
		select_figuras.add(fig);
	}
	public void agregarFiguras(ArrayList<Figura> selecciones, int posx, int posy) {
		select_figuras.add(selecciones);
		acomodarFigura(selecciones, posx, posy);

	}
	
	public void dibujarfigura(Figura figura) {
		Pepita[][] p = figura.getFigura();
		int fil = figura.getFigura().length;
		int col = figura.getFigura()[0].length;
		for (int i = 0; i < fil; i++) {
			for (int j = 0; j <col; j++) {
				if (p[i][j] == null) {
					System.out.print(" ");
				}
				else {
					System.out.print("O");
				}			}
			System.out.println();
		}
		}


	/*public void actualzarDiseño() {
		int f = filas + arriba + abajo;
		int c = columnas + espaciado + izquierda + derecha;

	
	}
*/
	public int calcularColumnas() {
		int total = 0;
		for (ArrayList<Figura> figuras : select_figuras) {
			for (Figura figura2 : figuras) {
				total += figura2.getColumnas();

			}
				
			}
		
		return total;
	}
	

	public int calcularfilas() {
		int mayor = 0;
		for (ArrayList<Figura> arrayList : select_figuras) {
			for (Figura figura2 : arrayList) {
				if (mayor < figura2.getFilas()) {
					mayor = figura2.getFilas();
				}

			}
		}		
		return mayor;
	}
	
	public int calcularCantidadFiguras() {
		int total = 0;
		for (ArrayList<Figura> figuras : select_figuras) {
			for (Figura figura2 : figuras) {
				total ++;

			}
				
			}
		
		return total;
	}


	public void crearFiguraPersonalizada() {
		
		if (espaciado > 0) {
			espaciado = espaciado* calcularCantidadFiguras(); 
		}
		
		int f = calcularfilas();
		int c = calcularColumnas();
		if(filas < f) {
			filas = f;
		}
		if(columnas < c) {
			columnas = c;
		}
		figura.crearFigura(filas+"", columnas+"");

	}
	
	public void acomodarFigura(ArrayList<Figura> fig, int posX, int posY) {
		int f = posY;
		int c = posX;
		for (Figura figura : fig) {
			figura.setPos_columna(c);
			figura.setPos_fila(f);
			//f += figura.getFilas();
			c += figura.getColumnas() + espaciado;
		}
		figura.crearFigura(calcularfilas()+"", calcularColumnas()+"");

		
	}
	
	public void ajustarTamaño() {
		this.filas = calcularfilas();
		this.columnas = calcularColumnas();
	}
	
	public void rellenar() {
		for (ArrayList<Figura> arrayList : select_figuras) {
			for (Figura figura : arrayList) {
				rellenoPersonalizada(figura);
			}
		}
	}
	public void rellenoPersonalizada(Figura fig) {
		for (int i = 0; i < fig.getFigura().length; i++) {
			for (int j = 0; j < fig.getFigura()[0].length; j++) {
				figura.agregarPosPepita(fig.getFigura()[i][j], fig.getPos_fila() + i, fig.getPos_columna() + j);
			}
		}
	}


	public int getEspaciado() {
		return espaciado;
	}


	public void setEspaciado(int espaciado) {
		this.espaciado = espaciado;
	}


	public int getArriba() {
		return arriba;
	}


	public void setArriba(int arriba) {
		this.arriba = arriba;
	}


	public int getAbajo() {
		return abajo;
	}


	public void setAbajo(int abajo) {
		this.abajo = abajo;
	}


	public int getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(int izquierda) {
		this.izquierda = izquierda;
	}


	public int getDerecha() {
		return derecha;
	}


	public void setDerecha(int derecha) {
		this.derecha = derecha;
	}


	public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}


	public int getColumnas() {
		return columnas;
	}


	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}


	public Figura getFigura() {
		return figura;
	}


	public void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Color getFondo() {
		return fondo;
	}

	public void setFondo(Color fondo) {
		this.fondo = fondo;
	}
	
	
}

