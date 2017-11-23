package DbContext;
import java.sql.*;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.ReplicationDriver;
import com.sun.xml.internal.fastinfoset.sax.Properties;


public final class dbConnection {
//	private static Connection appDbConnection = null;
//	private static Connection masterConnection = null;
//	private static Connection slaveConnection = null;
	private static String username = "root";
	private static String password = "asdf";
	private static String masterUrl = "jdbc:mysql://localhost:3306/moviedb?autoReconnect=true&amp;useSSL=false";
	private static String slaveUrl = "jdbc:mysql://localhost:3306/moviedb?autoReconnect=true&amp;useSSL=false";
	private static String driverName = "com.mysql.jdbc.Driver";
	
	public static Connection GetConnection(String setting){
		try{
			Class.forName(driverName).newInstance();
            if(setting.equals("master")){
            	return DriverManager.getConnection(masterUrl, username, password); 
            }
            else{
            	Random rand = new Random();
            	int n = rand.nextInt(100);
            	if(n%2 == 0)
            		return DriverManager.getConnection(masterUrl, username, password); 
            	else
            		return DriverManager.getConnection(slaveUrl, username, password); 
            }
		}
		catch(Exception e){
			System.out.println("Could not make connection to database. Please check your connection or your login credentials");
			return null;
		}
	}
}
