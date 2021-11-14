
package opticien;

import java.sql.*;

public class BDConnexion {
	
	private static Connection connection;
	
	static{
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
			
	
			
		}
		
		catch (ClassNotFoundException e){
			e.printStackTrace();
			
		}catch (SQLException e){
			e.printStackTrace();
		}}
	public static Connection getConnection(){
		return connection ;
		
	}
	
public static void main(String[] args) {
	System.out.println("ok");
}
}