import java.sql.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatabaseSelenium {

	public static void main(String[] args) throws SQLException {
		/*Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306";
		String databaseName = "Qademo";
		String username= "root";
		String Password= "mysql";
		try{
			Class.forName("com.mysql.c");
			conn= DriverManager.getConnection(url+databaseName, username, Password);
			String sqlQuery = "select * from Dollertreeinfo";
			Statement st = conn.createStatement();
			ResultSet result=st.executeQuery(sqlQuery);
			result.next();
			System.out.println(result.getString("EmailAddress"));
			System.out.println(result.getString("Zipcode"));
			System.out.println(result.getString("Firstname"));
			System.out.println(result.getString("Lastname"));
		}*/
		//Test data
		String firstname= "lucky";
		String Lastname= "billap";
		String email= "lucky@gmail.com";
		String Zipcode= "88889";

		//Input test data using selenium
		System.setProperty("webdriver.chrome.driver","/Users/sravanthigokula/Documents/space/chromedriver");
		WebDriver dr=new ChromeDriver();
		dr.get("https://www.dollartree.com/user/subscribe.jsp");
		dr.findElement(By.id("usrZip")).sendKeys("77058");
		dr.findElement(By.id("setZip")).click();
		dr.findElement(By.id("firstName")).sendKeys(firstname);
		dr.findElement(By.id("lastName")).sendKeys(Lastname);
		dr.findElement(By.id("email1")).sendKeys(email);
		dr.findElement(By.id("pcode")).sendKeys(Zipcode);
		dr.findElement(By.xpath("//label[@class='sideLabel css-label clr'")).click();
		dr.findElement(By.xpath("//label[@class='orangeCTA'")).click();
		// Connecting to database
		String host="127.0.0.1";
		String port="3306";
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host + ":"+ port + "/Qademo","root","mysql");
		Statement st=conn.createStatement();
		//ResultSet result= st.executeQuery("select * from Dollertreeinfo");
		ResultSet result= st.executeQuery("select * from Dollertreeinfo ORDER BY signupid DESC LIMIT 1");

		try
		{
		result.next();
			System.out.println(result.getString("Firstname"));
			System.out.println(result.getString("Lastname"));
			System.out.println(result.getString("EmailAddress"));
			System.out.println(result.getString("Zipcode"));

			if(!result.getString("Firstname").equals(firstname))
				System.out.println(" Firstname stored is wrong");
			if(!result.getString("Lastname").equals(Lastname))
				System.out.println("Lastname stored is wrong");
			if(!result.getString("EmailAddress").equals(email))
				System.out.println("email stored is wrong");
			if(!result.getString("Zipcode").equals(Zipcode))
				System.out.println("Zipcode stored is wrong");
		}
	catch(Exception e)
		{
		System.out.println(e);
		}
	finally{
		if(conn!=null)
		{
			conn=null;
		}
	}
	}
}

