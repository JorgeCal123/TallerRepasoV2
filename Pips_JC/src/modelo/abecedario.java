package modelo;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.scene.paint.Color;

public class abecedario {
	private int largo;
	private int ancho;
	private String name;
	
	private Hashtable<String, Diseño> categoria;
	//private Hashtable<String, Figura> figuras;
	private ArrayList<Pepita[][]> select_diseño;
	private Figura figura;
	
	
	public abecedario(String name) {
		this.name = name;
	}
	
	public void cargarABC() {
		
	}
	
	
/*	public void inicializar() {
		Pepita p1= new Pepita(0, 4, Color.BLUE, Pepita.MEDIANO);
		Pepita p2= new Pepita(1, 4, Color.BLUE, Pepita.MEDIANO);
		Pepita p3= new Pepita(2, 3, Color.BLUE, Pepita.MEDIANO);
		Pepita p4= new Pepita(2, 5, Color.BLUE, Pepita.MEDIANO);
		Pepita p5= new Pepita(3, 3, Color.BLUE, Pepita.MEDIANO);
		Pepita p6= new Pepita(3, 5, Color.BLUE, Pepita.MEDIANO);
		Pepita p7= new Pepita(4, 2, Color.BLUE, Pepita.MEDIANO);
		Pepita p8= new Pepita(4, 6, Color.BLUE, Pepita.MEDIANO);
		Pepita p9= new Pepita(5, 2, Color.BLUE, Pepita.MEDIANO);
		Pepita p10= new Pepita(5, 6, Color.BLUE, Pepita.MEDIANO);
		Pepita p11= new Pepita(6, 1, Color.BLUE, Pepita.MEDIANO);
		Pepita p12= new Pepita(6, 2, Color.BLUE, Pepita.MEDIANO);
		Pepita p13= new Pepita(6, 6, Color.BLUE, Pepita.MEDIANO);
		Pepita p14= new Pepita(6, 7, Color.BLUE, Pepita.MEDIANO);
		Pepita p15= new Pepita(7, 1, Color.BLUE, Pepita.MEDIANO);
		Pepita p16= new Pepita(7, 7, Color.BLUE, Pepita.MEDIANO);
		Pepita p17= new Pepita(7, 8, Color.BLUE, Pepita.MEDIANO);
		Pepita p18= new Pepita(8, 0, Color.BLUE, Pepita.MEDIANO);
		Pepita p19= new Pepita(8, 1, Color.BLUE, Pepita.MEDIANO);
		Pepita p20= new Pepita(8, 8, Color.BLUE, Pepita.MEDIANO);
		Pepita p21= new Pepita(8, 9, Color.BLUE, Pepita.MEDIANO);
		Pepita p22= new Pepita(9, 9, Color.BLUE, Pepita.MEDIANO);
		Pepita p23= new Pepita(9, 10, Color.BLUE, Pepita.MEDIANO);
		Pepita p24= new Pepita(9, 11, Color.BLUE, Pepita.MEDIANO);
		
		
		Pepita p25= new Pepita(5, 3, Color.BLUE, Pepita.MEDIANO);
		Pepita p26= new Pepita(5, 4, Color.BLUE, Pepita.MEDIANO);
		Pepita p27= new Pepita(5, 5, Color.BLUE, Pepita.MEDIANO);

		int filas = 10;
		int columnas = 12;
		
		figura = new Figura(filas,columnas);
		figura.crearFigura();
		
		figura.agregarPepita(p1);
		figura.agregarPepita(p2);
		figura.agregarPepita(p3);
		figura.agregarPepita(p4);
		figura.agregarPepita(p5);
		figura.agregarPepita(p6);
		figura.agregarPepita(p7);
		figura.agregarPepita(p8);
		figura.agregarPepita(p9);
		figura.agregarPepita(p10);
		figura.agregarPepita(p11);
		figura.agregarPepita(p12);
		figura.agregarPepita(p13);
		figura.agregarPepita(p14);
		figura.agregarPepita(p15);
		figura.agregarPepita(p16);
		figura.agregarPepita(p17);
		figura.agregarPepita(p18);
		figura.agregarPepita(p19);
		figura.agregarPepita(p20);
		figura.agregarPepita(p21);
		figura.agregarPepita(p22);
		figura.agregarPepita(p23);
		figura.agregarPepita(p24);
		figura.agregarPepita(p25);
		figura.agregarPepita(p26);
		figura.agregarPepita(p27);
		
		figura[p1.getX()][p1.getY()] = p1;
		figura[p2.getX()][p2.getY()] = p2;
		figura[p3.getX()][p3.getY()] = p3;
		figura[p4.getX()][p4.getY()] = p4;
		figura[p5.getX()][p5.getY()] = p5;
		figura[p6.getX()][p6.getY()] = p6;
		figura[p7.getX()][p7.getY()] = p7;
		figura[p8.getX()][p8.getY()] = p8;
		figura[p9.getX()][p9.getY()] = p9;
		figura[p10.getX()][p10.getY()] = p10;
		figura[p11.getX()][p11.getY()] = p11;
		figura[p12.getX()][p12.getY()] = p12;
		figura[p13.getX()][p13.getY()] = p13;
		figura[p14.getX()][p14.getY()] = p14;
		figura[p15.getX()][p15.getY()] = p15;
		figura[p16.getX()][p16.getY()] = p16;
		figura[p17.getX()][p17.getY()] = p17;
		figura[p18.getX()][p18.getY()] = p18;
		figura[p19.getX()][p19.getY()] = p19;
		figura[p20.getX()][p20.getY()] = p20;
		figura[p21.getX()][p21.getY()] = p21;
		figura[p22.getX()][p22.getY()] = p22;
		figura[p23.getX()][p23.getY()] = p23;
		figura[p24.getX()][p24.getY()] = p24;

		figura[p25.getX()][p25.getY()] = p25;
		figura[p26.getX()][p26.getY()] = p26;
		figura[p27.getX()][p27.getY()] = p27;
		
		
		// almacena las disponibles
		Diseño diseños = new Diseño();
		
		diseños.agregarDiseño("a", figura);
		
		
		//figuras = new Hashtable<String, Figura>();
		//figuras.put("a",figura);
		
		categoria = new Hashtable<String, Diseño>();
		categoria.put("abecedario", diseños);

		// almacena las que voy a usar
		select_diseño = new ArrayList<>();	
		select_diseño.add(categoria.get("abecedario").getDiseños().get("a").getFigura());
		select_diseño.add(categoria.get("abecedario").getDiseños().get("a").getFigura());
		select_diseño.add(categoria.get("abecedario").getDiseños().get("a").getFigura());

	}
	
*/	public void imprimir() {
		for (Pepita[][] pepitas : select_diseño) {
			
		
		Pepita[][] p = pepitas;
		

		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				if (p[i][j] == null) {
					System.out.print(" ");
				}
				else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
		}
	}
	

}
