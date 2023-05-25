package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javafx.scene.paint.Color;

public class AdminPip {

	private Hashtable<String, Diseño> categorias;
	//private ArrayList<DiseñoPersonalizado> select_resourse;
	private DiseñoPersonalizado NuevoDiseño;


	public AdminPip() {
		categorias = new Hashtable<String, Diseño>();
	}

	public void crearCategoria(String nombre) {
		categorias.put(nombre, new Diseño());

	}
	public Diseño seleccionarcategoria(String nombre) {
		return categorias.get(nombre);
	}
	

	public Hashtable<String, Diseño> getCategorias() {
		return categorias;
	}
	
	
	/*
	 * hay que corregir en caso de que la ave no exista
	 */
	public Figura buscardiseños(String categoria, String diseño ) {
		Figura fig = categorias.get(categoria).getDiseño().get(diseño);
		return fig;
	}
	
	public void crearDiseñoPersonalizado(int filas, int columnas) {
		NuevoDiseño = new DiseñoPersonalizado(filas, columnas);
	}
	
	public void selectDiseños(String categoria, String diseño ) {
		NuevoDiseño.agregarFigura(categorias.get(categoria).getDiseño().get(diseño), 0, 0);
	}


	public void escribirDiseño(String categoria, String texto) {
		ArrayList<Figura> select = new ArrayList<>();
		char[] letras = texto.toCharArray();
		String letra;
		for (char c : letras) {
				letra = c+"";
				Figura figura = new Figura();
				
				if(letra.equals(" ")) {
					NuevoDiseño.ajustarTamaño();
					figura.espacio(NuevoDiseño.getFilas(), NuevoDiseño.getFondo(), Pepita.MEDIANO);
					select.add(figura);

				}
				else {
				Figura busqueda =buscardiseños(categoria, letra);
				figura.copyFigura(busqueda.getFigura());
				figura.setNombre(busqueda.getNombre());
				select.add(figura);
				}
		}
		NuevoDiseño.agregarFiguras(select, 0, 0);
		
	}
	
	
	
	public void modificarEspaciado(int espaciado, int arriba, int abajo, int izquierda, int derecha) {
		NuevoDiseño.setAbajo(abajo);
		NuevoDiseño.setArriba(arriba);
		NuevoDiseño.setDerecha(derecha);
		NuevoDiseño.setIzquierda(izquierda);
		NuevoDiseño.setEspaciado(espaciado);

	}
	
	public void actualizar() {
		NuevoDiseño.rellenar();
		
	}
	
	
	public void imprimir() {
		Pepita[][] p = NuevoDiseño.getFigura().getFigura();

		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				if (p[i][j] == null) {
					System.out.print(" ");
				}
				else {
					System.out.print("O");
				}			}
			System.out.println();
		}
		}

	

//	public void imprimir() {
//		for (Figura figura : select_resourse) {
//			
//		
//		Pepita[][] p = figura.getFigura();
//		
//
//		for (int i = 0; i < p.length; i++) {
//			for (int j = 0; j < p[0].length; j++) {
//				if (p[i][j] == null) {
//					System.out.print(" ");
//				}
//				else {
//					System.out.print("O");
//				}
//			}
//			System.out.println();
//		}
//		}
//	}

	public void loadCategoria(String categoria) {
		Diseño cat = seleccionarcategoria(categoria);
		String nombre_design = "";
		String filas = "";
		String columnas = "";
		Color color = null;
		double tamaño = 0;
		Figura figura = null;
		int x = 0;
		int y = 0;
		File archivo = new File ("src/resourse/pip.txt");
		FileReader fr;
		try {
			fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				if(linea.contains("nombre")) {
					nombre_design = linea.split(":")[1];
					cat.crearDiseño(nombre_design, new Figura());

				}
				else if(linea.contains("tamano")) {

					 String[] f = linea.split(":");
					 filas = (f[1]);
					 columnas = (f[2]);
					 figura = cat.seleccionarDiseño(nombre_design);

					 figura.crearFigura(filas, columnas);
					 figura.setNombre(nombre_design);
					 //System.out.println(figura.getFigura());

				}
				else if(linea.contains("color")) {

					color = Color.web(linea.split(":")[1]);

				}
				else if(linea.contains("tP")) {

					tamaño = Double.parseDouble(linea.split(":")[1]);

				}


				else {

					String[] posiciones = linea.split(",");
					x = Integer.parseInt(posiciones[0]);
					y = Integer.parseInt(posiciones[1]);
					Pepita nueva_pepita = new Pepita(x, y, color, tamaño);
					figura.agregarPepita(nueva_pepita);
				}
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
