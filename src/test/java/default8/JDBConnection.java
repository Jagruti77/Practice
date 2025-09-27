package default8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class JDBConnection {
	
	public static void main(String args[]) throws SQLException
	{
		String host = "localhost";
		String port = "3306";
		
		//Set connection - connecting java script to mysql server
Connection con= DriverManager.getConnection("Jdbc:mysql://"+host+": "+port+" /Clientdemo", "root", "Jagu_7");
        //createstatement object to send sql query to database 
       Statement s  = con.createStatement();  //
      ResultSet rs  = s.executeQuery("select * from Clientcredentials where scenario = 'zerobalancecard'");
      
      while(rs.next()) //if index is available then pick the value - mandatory step otherwise it will throw error
      {
    	  
    	  
    	  WebDriver driver= new ChromeDriver();

    	  driver.get("https://login.salesforce.com");

    	  driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

    	  driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password1"));

               
	}
}
}
