import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main{
	/**
	*
	*/
	String hostname = "localhost";	// If PostgreSQL is running on some other machine enter the IP address of the
	String username = "root"; // Enter your PostgreSQL username
	String password = "password"; // Enter your PostgreSQL password
	String dbName = "dbms"; // Enter the name of the database that has the university tables.
	String connectionUrl = "jdbc:mysql://localhost/dbms";
	Connection conn;
	Main() {
		try{
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe){
				System.out.println("Could not find the JDBC driver!");
				System.exit(1);
		}

		try {
				conn = DriverManager.getConnection(connectionUrl,username, password);
				System.out.println("Connected successfully");
		} catch (SQLException sqle) {
					 System.out.println("Connection failed");
					 System.out.println(sqle);
					 System.exit(1);
		}
}
	public static void main(String args[]) {
		
		Main f = new Main();
		
	}	
}

//package dbsample;
//import java.sql.*;
/*
public           class           Main           {
public           static           void           main(String[]           args)           {
String           url           =           "jdbc:mysql://localhost/dbms";
String           username           =           "root";
String           passwd           =           "password";
Connection           conn           =           null;
Statement           stmt           =           null;
try{
Class.forName("com.mysql.jdbc.Driver");
conn           =           DriverManager.getConnection(url,           username,           passwd);
stmt           =           conn.createStatement();
String           query           =           "select           *           from           NCP";
ResultSet           rs           =           stmt.executeQuery(query);
while(rs.next()){
System.out.println(rs.getInt(1)           +           "           "           +           rs.getString(2));
}
stmt.close();
conn.close();
}catch(Exception           e){
e.printStackTrace();
}
}
}*/
