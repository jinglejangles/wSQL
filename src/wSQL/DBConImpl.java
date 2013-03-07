package wSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConImpl {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	Connection conn = null;
	Statement stmt = null;
	private String username;
	private String pass;
	private String hostname;
	private String database;
	
	
	DBConImpl(){
		this.hostname = null;
		this.pass = null;
		this.username = null;
		this.database = null;
	}
	
	public boolean attemptConnect(){
		System.out.println("I got some " + hostname + " plus some " + username + " secrectstuff " + pass);
		if(this.hostname.isEmpty()){
			System.out.println("No hostname, using local host");
			hostname = "localhost";
		}
		if(this.pass.isEmpty() || this.username.isEmpty()){
			System.out.println("not user or pass, not attempting connection");
			return false;
		}
			 try {
			        System.out.println("Create the driver instance.<br>");
			        Class.forName("com.mysql.jdbc.Driver").newInstance();
			        System.out.println("jdbc:mysql://"+ hostname + ":3306/information_schema");
			        conn = DriverManager.getConnection("jdbc:mysql://"+ hostname + ":3306/test", username, pass);
			        stmt = conn.createStatement();
			        System.out.println("Currently connected to " + hostname);
			        return true;
			        /*
			        String sql = "SELECT * FROM example";
			        ResultSet rs = stmt.executeQuery(sql);
			        while(rs.next()){
			        	System.out.println(rs.getString(1) + " " + rs.getString(2) + rs.getInt(3));
			        }*/
			    } catch (Exception e)
			    {
			    	
			        System.out.println(e.toString()+"<br>");
			        e.printStackTrace();
			        System.exit(0);
			    }
	
			 return true;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public boolean runQuery(){
		return false;
	}
	public void disposeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
