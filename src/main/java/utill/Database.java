package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class Database {

	public static String get(String columnName) throws ClassNotFoundException, SQLException {
		//setting properties for mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		//create a connection to your local database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techfios", "root", "root");
		//empowering the con refrence valiable to excute queries 
		Statement smt = con.createStatement();
		//delivering the sql query 
		ResultSet rs = smt.executeQuery("select * from users");
		while (rs.next()) {    // this will loop through the table data and if there is one more pc of data next
								//this retun true if there is no data it return false
			return rs.getString(columnName);  //if it has data it will return column name
		}
		return null;
	}
	}

