package question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public DBConnection() throws SQLException {
	}

	private final String DB_URL = "jdbc:mariaDB:localhost:@127.0.0.1:3306:mariaDB";
	private final String DB_DRIVE= "org.mariadb.jdbc.Driver";
	private String dbId = "study";
	private String dbPw = "1234";

	Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/","study","1234");
	Statement stmt = conn.createStatement();

	// boolean b = stmt.execute("CREATE TABLE SOLVING_PROBLEM ");
	// ResultSet rs = stmt.executeQuery("insert ");
	// ResultSet rs = stmt.executeQuery("select ");
}
