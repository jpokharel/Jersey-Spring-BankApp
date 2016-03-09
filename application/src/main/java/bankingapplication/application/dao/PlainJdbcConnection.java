package bankingapplication.application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlainJdbcConnection {

	// JDBC driver name and database URL
	static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static String DB_URL = "jdbc:oracle:thin:@localhost:1521:oracle";

	// Database credentials
	static String USER = "system";
	static String PASS = "Jiwan251";
	static int accountNum=0;

	static Connection conn = null;
	static Statement stmt = null;

	public static void main(String args[]){
		System.out.println(returnNameOfAccount(123));
	}
	public static int returnNameOfAccount(int accountId){
	try

	{
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		String sql = "SELECT account_id from ACCOUNT where account_id="+accountId;
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			 accountNum=rs.getInt("ACCOUNT_ID");
		}

		rs.close();
		stmt.close();
		conn.close();
	} catch(

	Exception se)

	{
		se.printStackTrace();
	} finally

	{
		// finally block used to close resources
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		} // nothing we can do
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // end finally try
	} // end try
	System.out.println("Goodbye!");
return accountNum;
}
}
