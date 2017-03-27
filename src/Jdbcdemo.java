import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcdemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="127.0.0.1";
		String port="3306";
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":"+ port + "/Qademo","root","mysql");
		Statement s=con.createStatement();
		ResultSet rs= s.executeQuery("select * from Employeeinfo;");
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			/*System.out.println(rs.getString("location"));
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("age"));*/
		}
	}

}
