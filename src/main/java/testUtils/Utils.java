package testUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class Utils {

	public static void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertDataInTestResultsDB(String name, int status,String desc,String testgroup,String sysname, double testexecutiontime) throws Exception {
		Connection dbcon;
		String dburl = "jdbc:mysql://database-1.cqga2bbfb2f2.us-east-1.rds.amazonaws.com:3306/";
		String username = "admin";
		String password = "12345678";
		String dbName = "testresults";

		Class.forName("com.mysql.cj.jdbc.Driver");
		dbcon = DriverManager.getConnection(dburl + dbName, username, password);
		
		String query =("INSERT into testresults.javaresults(test_name,test_status,created_at,test_description,test_groups,created_by,test_execution_time)values('"+name+"','"+status+"',current_timestamp(),'"+desc+"','"+testgroup+"','"+sysname+"','"+testexecutiontime+"')");
		Statement st = dbcon.createStatement();
		st.executeUpdate(query);

		dbcon.close();
	}
	
	private static String ConvertArrayToString(String[] testgroup)
	{
		if (testgroup.length > 0) {
		    StringBuilder nameBuilder = new StringBuilder();

		    for (String n : testgroup) {
		        nameBuilder.append("'").append(n.replace("'", "\\'")).append("',");
		        // can also do the following
		        // nameBuilder.append("'").append(n.replace("'", "''")).append("',");
		    }

		    nameBuilder.deleteCharAt(nameBuilder.length() - 1);

		    return nameBuilder.toString();
		} else {
		    return "";
		}
	}
	
	
	
}
