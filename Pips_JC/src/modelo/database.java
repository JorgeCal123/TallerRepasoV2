package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class database {

	public static final String URL ="jdbc:mysql://localhost:3306/pips_jc";
	public static final String USERNAME ="root";
	public static final String PASSWORD ="1234";
	
	
	public static Connection getConection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("conexion exitosa");
		} catch (Exception e) {
			System.out.println("fallo en la conexion");
		}
				
		return con;
	}
	
	public static void getData() {
		Connection con = null;
		try {
			con = getConection();
			PreparedStatement ps;
			ResultSet res;
			ps = con.prepareStatement("Select * from pip");
			res = ps.executeQuery();
			if(res.next()) {
				System.out.println(res.getString("fila") + " " + res.getString("columna") + " " + res.getDouble("tamano") );
			}
			else {
				System.out.println("no existen datos");
			}
			con.close();
		} catch (Exception e) {
			System.out.println("fallo en la conexion");
		}


	}
	
	
	public static void saveData(int fila, int columna, String color, Double tamano) {
		Connection con = null;
		try {
			con = getConection();
			PreparedStatement ps;
			int res;
			ps = con.prepareStatement("Insert into pip (fila, columna, color, tamano) values(?,?,?,?)");
			ps.setInt(1, fila);
			ps.setInt(2, columna);
			ps.setString(3, color);
			ps.setDouble(4, tamano);
			
			res = ps.executeUpdate();
			if(res > 0) {
				System.out.println("Se guardaron los datos");
			}
			else {
				System.out.println("no se guardaron los datos");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void searchData(String color) {
		Connection con = null;
		try {
			con = getConection();
			PreparedStatement ps;
			ResultSet res;
			ps = con.prepareStatement("select * from pip where color = ?");
			ps.setString(1, color);
			
			res = ps.executeQuery();
			if(res.next()) {
				System.out.println(res.getString("fila"));
				System.out.println(res.getString("columna"));
				System.out.println(res.getString("color"));
				System.out.println(res.getString("tamano"));
			}
			else {
				System.out.println("no se encontraron los datos");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void setdata(int id, int fila, int columna, String color, Double tamano) {
		Connection con = null;
		try {
			con = getConection();
			PreparedStatement ps;
			int res;
			ps = con.prepareStatement("update pip set fila=?, columna=?, color=?, tamano=? where id=?");
			ps.setInt(1, fila);
			ps.setInt(2, columna);
			ps.setString(3, color);
			ps.setDouble(4, tamano);
			ps.setInt(5, id);
			
			res = ps.executeUpdate();
			if(res > 0) {
				System.out.println("Se modificaron los datos");
		
			}
			else {
				System.out.println("no se pudo encontrar los datos");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void deleteData(int id) {
		Connection con = null;
		try {
			con = getConection();
			PreparedStatement ps;
			int res;
			ps = con.prepareStatement("delete from pip where id = ?");
			ps.setInt(1, id);
			
			res = ps.executeUpdate();
			if(res > 0) {
				System.out.println("se elimino el dato");
				
			}
			else {
				System.out.println("no se pudo eliminar el dato");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
