package wSQL;
import java.util.Observable;
import java.sql.*;

public class myModel extends Observable{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql//student.cs.appstate.edu";
	
	public void hello(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean attemptConnect(String hostName, String userName, String pass) {
		System.out.println("I got some" + hostName + "plus some " + userName + "secrectstuff " + pass);
		Connection conn = null;
		Statement stmt = null;
		 
		  
			 try {

			        System.out.println("Create the driver instance.<br>");
			        Class.forName("com.mysql.jdbc.Driver").newInstance();

			        System.out.println("Get the connection.<br>");
			        conn = DriverManager.getConnection("jdbc:mysql://"+ hostName + ":3306/3430", userName, pass);
			        stmt = conn.createStatement();
			        String sql = "SELECT * FROM lin";
			        ResultSet rs = stmt.executeQuery(sql);
			        while(rs.next()){
			        	String uname = rs.getString(1);
			        	String enc = rs.getString(2);
			        	int valid = rs.getInt(3);
			        	System.out.println(uname + " " + enc + " " + valid);
			        }
			        

			        //...
			    } catch (Exception e)
			    {
			        System.out.println(e.toString()+"<br>");
			        e.printStackTrace();
			        System.exit(0);
			    }
		return true;
	}
}
