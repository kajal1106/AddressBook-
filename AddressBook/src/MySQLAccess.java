import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAccess {

	
static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "root", "");
		
		return con;
	}
	
	
	}
