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

	private Hashtable<String, Dise�o> categorias;
	//private ArrayList<Dise�oPersonalizado> select_resourse;
	private Dise�oPersonalizado NuevoDise�o;


	public AdminPip() {
		categorias = new Hashtable<String, Dise�o>();
	}

	public void crearCategoria(String nombre) {
		categorias.put(nombre, new Dise�o());

	}
	public Dise�o seleccionarcategoria(String nombre) {
		return categorias.get(nombre);
	}
	

	public Hashtable<String, Dise�o> getCategorias() {
		return categorias;
	}
	
	
	/*
	 * hay que corregir en caso de que la ave no exista
	 */
	public Figura buscardise�os(String categoria, String dise�o ) {
		Figura fig = categorias.get(categoria).getDise�o().get(dise�o);
		return fig;
	}
	
	public void crearDise�oPersonalizado(int filas, int columnas) {
		NuevoDise�o = new Dise�oPersonalizado(filas, columnas);
	}
	
	public void selectDise�os(String categoria, String dise�o ) {
		NuevoDise�o.agregarFigura(categorias.get(categoria).getDise�o().get(dise�o), 0, 0);
	}


	public void escribirDise�o(String categoria, String texto) {
		ArrayList<Figura> select = new ArrayList<>();
		char[] letras = texto.toCharArray();
		String letra;
		for (char c : letras) {
				letra = c+"";
				Figura figura = new Figura();
				
				if(letra.equals(" ")) {
					NuevoDise�o.ajustarTama�o();
					figura.espacio(NuevoDise�o.getFilas(), NuevoDise�o.getFondo(), Pepita.MEDIANO);
					select.add(figura);

				}
				else {
				Figura busqueda =buscardise�os(categoria, letra);
				figura.copyFigura(busqueda.getFigura());
				figura.setNombre(busqueda.getNombre());
				select.add(figura);
				}
		}
		NuevoDise�o.agregarFiguras(select, 0, 0);
		
	}
	
	
	
	public void modificarEspaciado(int espaciado, int arriba, int abajo, int izquierda, int derecha) {
		NuevoDise�o.setAbajo(abajo);
		NuevoDise�o.setArriba(arriba);
		NuevoDise�o.setDerecha(derecha);
		NuevoDise�o.setIzquierda(izquierda);
		NuevoDise�o.setEspaciado(espaciado);

	}
	
	public void actualizar() {
		NuevoDise�o.rellenar();
		
	}
	
	
	public void imprimir() {
		Pepita[][] p = NuevoDise�o.getFigura().getFigura();

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
		Dise�o cat = seleccionarcategoria(categoria);
		String nombre_design = "";
		String filas = "";
		String columnas = "";
		Color color = null;
		double tama�o = 0;
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
					cat.crearDise�o(nombre_design, new Figura());

				}
				else if(linea.contains("tamano")) {

					 String[] f = linea.split(":");
					 filas = (f[1]);
					 columnas = (f[2]);
					 figura = cat.seleccionarDise�o(nombre_design);

					 figura.crearFigura(filas, columnas);
					 figura.setNombre(nombre_design);
					 //System.out.println(figura.getFigura());

				}
				else if(linea.contains("color")) {

					color = Color.web(linea.split(":")[1]);

				}
				else if(linea.contains("tP")) {

					tama�o = Double.parseDouble(linea.split(":")[1]);

				}


				else {

					String[] posiciones = linea.split(",");
					x = Integer.parseInt(posiciones[0]);
					y = Integer.parseInt(posiciones[1]);
					Pepita nueva_pepita = new Pepita(x, y, color, tama�o);
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
