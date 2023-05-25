package application;
	
import javax.lang.model.util.AbstractElementVisitor6;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.AdminPip;
import modelo.Dise�o;
import modelo.Figura;
import modelo.abecedario;
import modelo.database;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
				
		AdminPip admin = new AdminPip();
		admin.crearCategoria("abecedario");
		admin.crearCategoria("anime");
		admin.crearCategoria("nombres");
		admin.loadCategoria("abecedario");
		
		
		admin.crearDise�oPersonalizado(10,10);
		admin.escribirDise�o("abecedario", "TATIANA    CALAMBAS");
		admin.modificarEspaciado(2, 3, 4, 5, 6);
		admin.actualizar();
		//admin.agregarSeleccion();
		admin.imprimir();
		
		database db = new database();
		// MOSTRAR DATOS
		//db.getData();
		
		// GUARDAR DATOS
		/*db.saveData(3, 50, "Black", 3.8);
		db.saveData(4, 62, "Black", 2.5);
		db.saveData(5, 85, "Black", 5.212);

		//BUSCAR DATOS
		 */
		//db.searchData("Green");
		
		//EDITAR DATOS
		//db.setdata(8, 200, 360, "Blue", 23.3);
		
		//ELIMINAR DATOS
		//db.deleteData(8);
/*
		Dise�o categoria =admin.seleccionarcategoria("abecedario");

		categoria.crearDise�o("a");
		categoria.setTipo(Dise�o.MANILLA);
		categoria.setTama�o(Figura.MANILLA_MEDIANA);
		
		Figura dise�o = categoria.seleccionarFigura("a");
		int filas = Integer.parseInt(categoria.getTama�o().split("x")[0]);
		int columnas= Integer.parseInt(categoria.getTama�o().split("x")[1]);
		dise�o.crearFigura(filas, columnas);
		
		
		Figura figura = categoria.seleccionarFigura("a");
		
		pepita[][] pepitas = admin.LoadDesignstxt();
			
		}
*/	
		
		//admin.escribirDise�o("aaa");
		//admin.LoadDesignstxt();
	}
}
