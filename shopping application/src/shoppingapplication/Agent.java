package shoppingapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agent {

	ConnectionManager con= new ConnectionManager();
	public void agentdetail() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the username");
		String user1= s.next();
		System.out.println("Enter the password");
		String pass1= s.next();
		Statement s1= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r= s1.executeQuery("select * from Agentlogin");//for display
		while(r.next())
		{
			String us= r.getString(1);
			String pa= r.getString(2);
			if(user1.equals(us) && pass1.equals(pa))
			{
				System.out.println("Successfully verified");
				Buyprod buy= new Buyprod();
				buy.buydetails();
				
				}
		}
		
		
		
	}

}
