package shoppingapplication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Buyprod {

	ConnectionManager con= new ConnectionManager();
	public void buydetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("1)Buysell\n2)Viewproduct\n3)Logout\n");
		System.out.println("Enter the choice");
		int num= s.nextInt();
		
		switch(num)
		{
		case 1: 
		Statement s1= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r= s1.executeQuery("select * from Addproduct");//for display
		System.out.println("Enter the ID:");
		int id= s.nextInt();
		System.out.println("Enter the quantity:");
		int quant= s.nextInt();
		int cost=0;
		int qu=0;
		int q=0;
		while(r.next())//check next element
		{
			if(id==r.getInt(1)) {//check given id and database id is same or not
				
			cost=r.getInt(4);
			qu=r.getInt(3);
			break;
			}
		}
			int cost1=quant*cost;
			System.out.println("Cost->"+cost1);
			System.out.println("Enter 1 to confirm booking(1)");
			int a= s.nextInt();
			if(a==1)
			{
				System.out.println("Your booking is confirmed");
				System.out.println("Thank you....!!!");
			}
			
			q=qu-quant;			
			PreparedStatement st= (PreparedStatement) con.getConnection().prepareStatement("update Addproduct SET Quantity=? where Product_ID=?");
			st.setInt(1,q);
			st.setInt(2, id);
			st.executeUpdate();
			Buyprod buy= new Buyprod();
			buy.buydetails();
			
		break;
		case 2: 	
		System.out.println("~~~~~~List of products~~~~~~");
		Statement s2= (Statement)con.getConnection().createStatement();//callable statement
		ResultSet r1= s2.executeQuery("select * from Addproduct");//for display
		while(r1.next())
		{
			System.out.println("Product ID->"+r1.getInt(1));
			System.out.println("Product Name->"+r1.getString(2));
			System.out.println("Quantity->"+r1.getInt(3));
			System.out.println("Price->"+r1.getInt(4));
		}
			
		Buyprod buy1= new Buyprod();
		buy1.buydetails();
		break;
		case 3: System.out.println("Agent account logout");
		Case1 c=new Case1();
		c.choice();
		break;
		}
		
		}
		
		
	}


